/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class InvertIntakeSubsystem extends SubsystemBase {
  private final WPI_VictorSPX intake = new WPI_VictorSPX(Constants.INTAKE_CAN_ID);

  /**
   * Creates a new InvertIntakeSubsystem.
   */
  public InvertIntakeSubsystem() {
    SmartDashboard.putNumber("InvertIntake", 1);
    intake.setInverted(true);


  }

  public void intake(boolean on) {
    double speed = SmartDashboard.getNumber("InvertIntake", 1);
    if (speed > 1) speed = 1;
    else if (speed < -1) speed = -1;

    intake.set(on ? speed : 0); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}