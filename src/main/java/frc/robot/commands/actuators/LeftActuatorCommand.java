/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.actuators;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LeftActuatorSubsystem;

public class LeftActuatorCommand extends CommandBase {
  private final LeftActuatorSubsystem mActuator;
  private final boolean mOn;

  /**
   * Creates a new ActuatorsCommand.
   */
  public LeftActuatorCommand(LeftActuatorSubsystem actuator, boolean on) {
    // Use addRequirements() here to declare subsystem dependencies.
    mActuator = actuator;
    mOn = on; 
    addRequirements(mActuator);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mActuator.actuate(mOn); 
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
