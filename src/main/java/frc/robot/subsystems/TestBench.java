/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestBench extends SubsystemBase {

private SpeedController LeftMotor = new WPI_VictorSPX(0);
private SpeedController RightMotor = new WPI_VictorSPX(1); 

  /**
   * Creates a new TestBench.
   */
  public TestBench() {
LeftMotor = new WPI_VictorSPX(0); 
RightMotor = new WPI_VictorSPX(1); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void SpinLeft(double speed){
    LeftMotor.set(speed);  
    
  }
  public void SpinRight(double speed){
  RightMotor.set(speed); 

  }
}
