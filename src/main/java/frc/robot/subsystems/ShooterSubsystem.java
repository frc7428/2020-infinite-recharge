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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final SpeedControllerGroup pew; 
  

  /**
   * Creates a new ShooterSubsystem.
   */
  public ShooterSubsystem() {
    CANSparkMax pewLeft = new CANSparkMax(Constants.PEW_LEFT_CAN_ID, MotorType.kBrushless);
    CANSparkMax pewRight = new CANSparkMax(Constants.PEW_RIGHT_CAN_ID, MotorType.kBrushless);
    pewLeft.setInverted(true);
    SmartDashboard.putNumber("Shooter", 0); 

    pew = new SpeedControllerGroup(pewLeft, pewRight);
  }
  public void shooter(boolean on) {
    double speed = SmartDashboard.getNumber("Shooter", 1);
    if (speed > 1) speed = 1;
    else if (speed < -1) speed = -1;
    pew.set(on ? speed : 0); 
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
