/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsytem;

public class IntakeCommand extends CommandBase {
  private final IntakeSubsytem mIntake;
  private final JoystickButton mLowerControl;
  private final JoystickButton mUpperControl;

  /**
   * Creates a new IntakeCommand.
   */
  public IntakeCommand(IntakeSubsytem intake,Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    mIntake = intake; 
    mLowerControl = new JoystickButton(joystick, Constants.LOWER_INTAKE_BUTTON);
    mUpperControl = new JoystickButton(joystick, Constants.UPPER_INTAKE_BUTTON);
    addRequirements(mIntake);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mIntake.intake(mLowerControl.get(), mUpperControl.get());
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
