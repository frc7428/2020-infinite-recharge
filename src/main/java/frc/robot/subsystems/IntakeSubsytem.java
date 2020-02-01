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

public class IntakeSubsytem extends SubsystemBase {
  private final WPI_VictorSPX lowerIntake = new WPI_VictorSPX(Constants.LOWER_INTAKE_CAN_ID);
  private final WPI_VictorSPX upperIntake = new WPI_VictorSPX(Constants.UPPER_INTAKE_CAN_ID);
  /**
   * Creates a new IntakeSubsytem.
   */
  public IntakeSubsytem() {
    lowerIntake.setInverted(true);
  }

  public void intake(boolean lower, boolean upper) {
    lowerIntake.set(lower ? 1 : 0);
    upperIntake.set(upper ? 1 : 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
