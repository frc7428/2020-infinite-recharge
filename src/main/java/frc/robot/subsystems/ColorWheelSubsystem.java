/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorWheelSubsystem extends SubsystemBase {
  private final WPI_VictorSPX spinner = new WPI_VictorSPX(Constants.CAN_ID.COLOR_WHEEL_CAN_ID);
  private final ColorSensorV3 sensor = new ColorSensorV3(Port.kOnboard);
  private final DoubleSolenoid positioner = new DoubleSolenoid(Constants.PCM_ID.COLOR_WHEEL_UP, Constants.PCM_ID.COLOR_WHEEL_DOWN);

  /**
   * Creates a new ColorWheelSubsystem.
   */
  public ColorWheelSubsystem() {
    spinner.setInverted(true);
    positioner.set(Value.kForward);
    sensor.getRawColor();
  }

  public void positioner(boolean up, boolean down) {
    positioner.set(up ? Value.kForward : Value.kReverse); 
  }

  public void spinner(boolean on, boolean out) {
    spinner.set(on ? Constants.SPEEDS.COLORWHEEL : 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
