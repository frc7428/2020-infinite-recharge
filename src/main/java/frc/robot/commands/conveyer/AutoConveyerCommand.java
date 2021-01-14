/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.conveyer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyerSubsystem;

public class AutoConveyerCommand extends CommandBase {
  private final ConveyerSubsystem mAutoConvey;
  private final boolean mOn;
  private final boolean mUp;
  /**
   * Creates a new AutoConveyerCommand.
   */
  public AutoConveyerCommand(ConveyerSubsystem convey, boolean on, boolean up) {
    // Use addRequirements() here to declare subsystem dependencies.
    mAutoConvey = convey;
    mOn = on;
    mUp = up;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mAutoConvey.convey(mOn, mUp);
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
