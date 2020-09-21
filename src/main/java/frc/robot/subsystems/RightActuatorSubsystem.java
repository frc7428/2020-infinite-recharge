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

public class RightActuatorSubsystem extends SubsystemBase {
  private final WPI_VictorSPX rightActuator = new WPI_VictorSPX(Constants.CAN_ID.RIGHT_ACTUATOR_CAN_ID);
  /**
   * Creates a new RightActuatorSubsystem.
   */
  public RightActuatorSubsystem() {
    rightActuator.setInverted(true);
  }

  public void actuate(boolean on, boolean up) {
    if (on) {
      if (up){
        rightActuator.set(1);
      } else {
        rightActuator.set(-1);
      }
    } else {
      rightActuator.set(0);
    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
