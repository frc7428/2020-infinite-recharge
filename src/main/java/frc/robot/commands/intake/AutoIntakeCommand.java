/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntakeCommand extends CommandBase {
  private final IntakeSubsystem mAutoIntake;
  private final boolean mOn;
  private final boolean mUp;

  /**
   * Creates a new AutoIntakeCommand.
   */
  public AutoIntakeCommand(IntakeSubsystem intake, boolean on, boolean up) {
    mAutoIntake = intake;
    mOn = on;
    mUp = up;
    addRequirements(mAutoIntake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mAutoIntake.intake(mOn, mUp);
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
