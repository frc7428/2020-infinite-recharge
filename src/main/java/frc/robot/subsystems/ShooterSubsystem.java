/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final SpeedControllerGroup pew;

  /**
   * Creates a new ShooterSubsystem.
   */
  public ShooterSubsystem() {
    CANSparkMax pewLeft = new CANSparkMax(Constants.SPARK_MAX_CAN.PEW_LEFT, MotorType.kBrushless);
    CANSparkMax pewRight = new CANSparkMax(Constants.SPARK_MAX_CAN.PEW_RIGHT, MotorType.kBrushless);
    pewRight.setInverted(false);

    pew = new SpeedControllerGroup(pewLeft, pewRight);
  }

  public void shooter(boolean on, boolean up) {
    if (on) {
      if (up) {
        pew.set(1);
      } else {
        pew.set(-1);
      }
    } else {
      pew.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
