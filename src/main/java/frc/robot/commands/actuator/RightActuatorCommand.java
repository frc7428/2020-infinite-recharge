/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.actuator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RightActuatorSubsystem;

public class rightActuatorCommand extends CommandBase {
  private final RightActuatorSubsystem mRightActuate;
  private final boolean mOn;
  private final boolean mUp;
  /**
   * Creates a new rightActuatorCommand.
   */
  public RightActuatorCommand(RightActuatorSubsystem actuator, boolean on, boolean up) {
    // Use addRequirements() here to declare subsystem dependencies.
    mActuator = actuator;
    mOn = on; 
    mUp = up;
    addRequirements(mActuator);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mActuator.actuate(mOn, mUp); 
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
