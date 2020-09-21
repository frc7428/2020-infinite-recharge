/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MecanumDriveSubsystem;

public class DriveCommand extends CommandBase {
  private final MecanumDriveSubsystem mDrive;
  private final Joystick mJoystick;
  /**
   * Creates a new DriveCommand.
   */
  public DriveCommand(MecanumDriveSubsystem driveSubsystem, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    mJoystick = joystick;
    mDrive = driveSubsystem;
    addRequirements(mDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mDrive.drive(-mJoystick.getY(), mJoystick.getX(), mJoystick.getZ());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
