/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorWheelSubsystem extends SubsystemBase {
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private int colorCount = 0;
  private Color lastColor = null;
  private Color currentColor = null;
  private Color fmsColor = null;

  private final WPI_VictorSPX spinner = new WPI_VictorSPX(Constants.VICTOR_SPX_CAN.COLOR_WHEEL_CAN_ID);
  private final ColorSensorV3 sensor = new ColorSensorV3(Port.kOnboard);
  private final DoubleSolenoid positioner = new DoubleSolenoid(Constants.PCM.COLOR_WHEEL_UP, Constants.PCM.COLOR_WHEEL_DOWN);

  /**
   * Creates a new ColorWheelSubsystem.
   */
  public ColorWheelSubsystem() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    positioner.set(Value.kForward);
    sensor.getRawColor();
  }

  public void positioner(boolean on) {
    positioner.set(on ? Value.kForward : Value.kReverse);
  }

  public void spinner(boolean on) {
    // TODO: We probably don't want full speed. This will need to be fixed.
    spinner.set(on ? 1 : 0);
  }

  public void detectColor() {
    currentColor = m_colorMatcher.matchClosestColor(sensor.getColor()).color;
    String colorString;
    if (currentColor != lastColor) {
      colorCount++;
      lastColor = currentColor;
    }

    if (currentColor == kBlueTarget) {
      colorString = "Blue";
    } else if (currentColor == kRedTarget) {
      colorString = "Red";
    } else if (currentColor == kGreenTarget) {
      colorString = "Green";
    } else if (currentColor == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    SmartDashboard.putString("Detected Color", colorString);
    SmartDashboard.putNumber("Color Count", colorCount);
  }

  public void reset() {
    colorCount = 0;
    lastColor = null;
  }

  private Color convertFMSColor() {
    Color retVal = null;
    if (fmsColor == kBlueTarget) {
      retVal = kRedTarget;
    } else if (fmsColor == kYellowTarget) {
      retVal = kGreenTarget;
    } else if (fmsColor == kRedTarget) {
      retVal = kBlueTarget;
    } else if (fmsColor == kGreenTarget) {
      retVal = kYellowTarget;
    }
    return retVal;

  }

  private void updateFMS() {
    String dataString = DriverStation.getInstance().getGameSpecificMessage();
    if (dataString.length() < 1) {
      return;
    }

    char letter = dataString.charAt(0);
    Color readColor = null;
    switch (letter) {
    case 'R':
      readColor = kRedTarget;
      break;
    case 'G':
      readColor = kGreenTarget;
      break;
    case 'B':
      readColor = kBlueTarget;
      break;
    case 'Y':
      readColor = kYellowTarget;
      break;
    }

    if (readColor != null && readColor != fmsColor) {
      fmsColor = readColor;
    }
  }

  /**
   * @return the colorCount
   */
  public int getColorCount() {
    return colorCount;
  }

  public boolean currentMatchesFMS() {
    return lastColor == convertFMSColor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    detectColor();
    updateFMS();
  }
}
