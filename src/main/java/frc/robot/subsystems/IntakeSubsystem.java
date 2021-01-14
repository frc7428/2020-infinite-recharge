/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax intake = new CANSparkMax(Constants.SPARK_MAX_CAN.INTAKE_CAN_ID, MotorType.kBrushless);
  
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
  }

  public void intake(Boolean mOn, Boolean mUp) {
    if (mOn) {
      if (mUp) {
        intake.set(1);
      } else {
        intake.set(-1);
      }
    } else {
      intake.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
