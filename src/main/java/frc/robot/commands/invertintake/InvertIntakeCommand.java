/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.invertintake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InvertIntakeSubsystem;

public class InvertIntakeCommand extends CommandBase {
  private final InvertIntakeSubsystem mInvertIntake;
  private final boolean mOn;
  /**
   * Creates a new InvertIntakeCommand.
   */
  public InvertIntakeCommand(InvertIntakeSubsystem invertIntake, boolean on) {
    // Use addRequirements() here to declare subsystem dependencies.
  mInvertIntake = invertIntake; 
  mOn = on;
  addRequirements(mInvertIntake);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mInvertIntake.intake(mOn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
