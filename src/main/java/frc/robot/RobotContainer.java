/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.commands.actuators.LeftActuatorCommand;
//import frc.robot.commands.actuators.RightActuatorCommand;
import frc.robot.commands.colorwheel.ColorWheelCommand;
//import frc.robot.commands.colorwheel.ColorWheelCommand;
import frc.robot.commands.conveyer.ConveyerCommand;
//import frc.robot.commands.conveyer.InvertedConveyerCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
// import frc.robot.subsystems.LeftActuatorSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;
// import frc.robot.subsystems.RightActuatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final MecanumDriveSubsystem driveSubsystem = new MecanumDriveSubsystem();
  private final IntakeSubsytem intakeSubsystem = new IntakeSubsytem();
  private final Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_USB_ID);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
  private final XboxController driveController = new XboxController(Constants.XBOX_CONTROLLER_USB_ID);
  //private final RightActuatorSubsystem rightActuatorSubsystem = new RightActuatorSubsystem();
  //private final LeftActuatorSubsystem leftActuatorSubsystem = new LeftActuatorSubsystem(); 
  private final ConveyerSubsystem conveyerSubsystem = new ConveyerSubsystem(); 

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, driveJoystick));
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton intakeButton = new JoystickButton(driveJoystick, Constants.INTAKE_BUTTON); 
    intakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, true)); 
    intakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, true)); 

    JoystickButton invertedIntakeButton = new JoystickButton(driveJoystick, Constants.INVERTED_INTAKE_BUTTON);
    invertedIntakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, false));
    invertedIntakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, false)); 

    JoystickButton conveyerButton = new JoystickButton(driveController, Constants.CONVEYER_BUTTON);
    conveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, true)); 
    conveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, true));

    JoystickButton invertedConveyerButton = new JoystickButton(driveController, Constants.INVERTED_CONVEYER_BUTTON);
    invertedConveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, false));
    invertedConveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, false));

    JoystickButton shooterButton = new JoystickButton(driveController, Constants.SHOOTER_BUTTON);
    shooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true));
    shooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false));

   // JoystickButton leftActuatorButton = new JoystickButton(driveController, Constants.LEFT_ACTUATOR_BUTTON);
   // leftActuatorButton.whileHeld(new LeftActuatorCommand(leftActuatorSubsystem, true));
   // leftActuatorButton.whenReleased(new LeftActuatorCommand(leftActuatorSubsystem, false));

   // JoystickButton rightActuatorButton = new JoystickButton(driveController, Constants.RIGHT_ACTUATOR_BUTTON);
   // rightActuatorButton.whileHeld(new RightActuatorCommand(rightActuatorSubsystem, true));
   // rightActuatorButton.whenReleased(new RightActuatorCommand(rightActuatorSubsystem, false));

    JoystickButton colorWheelButton = new JoystickButton(driveController, Constants.COLOR_WHEEL_BUTTON);
    colorWheelButton.whileHeld(new ColorWheelCommand(colorWheelSubsystem, true));
    colorWheelButton.whenReleased(new ColorWheelCommand(colorWheelSubsystem, false)); 
 
    //JoystickButton invertedConveyerButton = new JoystickButton(driveController, Constants.INVERTED_CONVEYER_BUTTON);
   //invertedConveyerButton.whileHeld(new InvertedConveyerCommand(conveyerSubsystem, true));
   // invertedConveyerButton.whenReleased(new InvertedConveyerCommand(conveyerSubsystem, false));
  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}