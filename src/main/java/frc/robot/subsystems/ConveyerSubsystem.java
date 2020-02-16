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

public class ConveyerSubsystem extends SubsystemBase {
  private final WPI_VictorSPX conveyer = new WPI_VictorSPX(Constants.CONVEYER_CAN_ID);
  /**
   * Creates a new ConveyerSubsystem.
   */
  public ConveyerSubsystem() {
    SmartDashboard.putNumber("Conveyor", 1);
    conveyer.setInverted(true);
  }

  public void convey(boolean on) {
    double speed = SmartDashboard.getNumber("Conveyor", 1);
    if (speed > 1) speed = 1;
    else if (speed < -1) speed = -1;
    
    conveyer.set(on ? speed : 0);
  }
  public void convey(boolean on, boolean up);
  double speed = SmartDashboard.getNumber("InvertedConveyer", 1);
  if (speed > 1) speed

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
