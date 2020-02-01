/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MecanumDriveSubsystem extends SubsystemBase {
  private final WPI_VictorSPX frontLeft = new WPI_VictorSPX(Constants.FRONT_LEFT_CAN_ID);
  private final WPI_VictorSPX frontRight = new WPI_VictorSPX(Constants.FRONT_RIGHT_CAN_ID);
  private final WPI_VictorSPX rearLeft = new WPI_VictorSPX(Constants.REAR_LEFT_CAN_ID);
  private final WPI_VictorSPX rearRight = new WPI_VictorSPX(Constants.REAR_RIGHT_CAN_ID);
  private final MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

  /**
   * Creates a new MecanumDrive.
   */
  public MecanumDriveSubsystem() {

  }

  public void drive(double forward, double right, double clockwise) {
    double scaledRight = Math.pow(right, 3);
    double scaledForward = Math.pow(forward, 3);
    double scaledClockwise = 0.5 * clockwise;

    drive.driveCartesian(scaledRight, scaledForward, scaledClockwise);

    SmartDashboard.putNumber("Scaled right", scaledRight);
    SmartDashboard.putNumber("Scaled forward", scaledForward);
    SmartDashboard.putNumber("Scaled clockwise", scaledClockwise);

    SmartDashboard.putNumber("frontLeft", frontLeft.get());
    SmartDashboard.putNumber("frontRight", frontRight.get());
    SmartDashboard.putNumber("rearLeft", rearLeft.get());
    SmartDashboard.putNumber("rearRight", rearRight.get());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
