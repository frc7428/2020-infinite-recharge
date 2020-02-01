/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MecanumDriveSubsystem extends SubsystemBase {
  private final WPI_VictorSPX frontLeft = new WPI_VictorSPX(Constants.FRONT_LEFT_CAN_ID);
  private final WPI_VictorSPX frontRight = new WPI_VictorSPX(Constants.FRONT_RIGHT_CAN_ID);
  private final WPI_VictorSPX rearLeft = new WPI_VictorSPX(Constants.REAR_LEFT_CAN_ID);
  private final WPI_VictorSPX rearRight= new WPI_VictorSPX(Constants.REAR_RIGHT_CAN_ID);
  private final MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);


  /**
   * Creates a new MecanumDrive.
   */
  public MecanumDriveSubsystem() {

  }

  public void drive(double forward, double right, double clockwise) {
    drive.driveCartesian(right, forward, clockwise);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
