/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorWheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class PneumaticsCommand extends CommandBase {
  private final ColorWheelSubsystem mPositioner;
  private final boolean mOn;
 // private final boolean mDown;
  /**
   * Creates a new PneumaticsCommand.
   */
  public PneumaticsCommand(ColorWheelSubsystem positioner, boolean on) {
    mPositioner = positioner;
    mOn = on;
    //mDown = down; , boolean down, mDown
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mPositioner.positioner(mOn);
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
