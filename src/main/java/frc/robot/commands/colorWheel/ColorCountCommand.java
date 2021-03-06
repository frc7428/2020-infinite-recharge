/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorWheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class ColorCountCommand extends CommandBase {
  private final ColorWheelSubsystem mcolorWheelSubsystem;
  /**
   * Creates a new ColorCountCommand.
   */
  public ColorCountCommand(ColorWheelSubsystem colorWheelSubsystem) {
    mcolorWheelSubsystem = colorWheelSubsystem;
    addRequirements(mcolorWheelSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mcolorWheelSubsystem.spinner(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mcolorWheelSubsystem.spinner(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return mcolorWheelSubsystem.getColorCount() >= 28;
  }
}
