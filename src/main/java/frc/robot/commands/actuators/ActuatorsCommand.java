/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.actuators;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.ActuatorsSubsystem;

public class ActuatorsCommand extends CommandBase {
  private final ActuatorsSubsystem mActuators;
  private final JoystickButton mLeftActuatorControl;
  private final JoystickButton mRightActuatorControl;
  /**
   * Creates a new ActuatorsCommand.
   */
  public ActuatorsCommand(ActuatorsSubsystem actuators, XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    mActuators = actuators;
    mLeftActuatorControl = new JoystickButton(controller, Constants.LEFT_ACTUATOR_BUTTON);
    mRightActuatorControl = new JoystickButton(controller, Constants.RIGHT_ACTUATOR_BUTTON);
    addRequirements(mActuators);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mActuators.actuators(mLeftActuatorControl.get(), mRightActuatorControl.get()); 
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
