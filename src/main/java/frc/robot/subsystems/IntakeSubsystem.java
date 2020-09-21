/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final WPI_VictorSPX intake = new WPI_VictorSPX(Constants.INTAKE_CAN_ID);
  
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
  }

  public void intake(boolean on, boolean up) {
    if (on) {
      if (up) {
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
