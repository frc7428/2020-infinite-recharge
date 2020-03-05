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
import frc.robot.commands.colorWheel.PneumaticsCommand;
import frc.robot.commands.colorWheel.colorWheelCommand;
import frc.robot.commands.conveyer.ConveyerCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.MecanumDriveSubsystem;
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
  private final Joystick driveJoystick = new Joystick(Constants.USB_ID.DRIVE_JOYSTICK_USB_ID);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final XboxController driveController = new XboxController(Constants.USB_ID.XBOX_CONTROLLER_USB_ID);
  // private final RightActuatorSubsystem rightActuatorSubsystem = new
  // RightActuatorSubsystem();
  // private final LeftActuatorSubsystem leftActuatorSubsystem = new
  // LeftActuatorSubsystem();
  private final ConveyerSubsystem conveyerSubsystem = new ConveyerSubsystem();
  private final ColorWheelSubsystem ColorWheelSubsystem = new ColorWheelSubsystem();

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
    final JoystickButton intakeButton = new JoystickButton(driveJoystick, Constants.BUTTON_ID.INTAKE_BUTTON);
    intakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, false));
    intakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, false));

    final JoystickButton invertedIntakeButton = new JoystickButton(driveJoystick,
        Constants.BUTTON_ID.INVERTED_INTAKE_BUTTON);
    invertedIntakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, true));
    invertedIntakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, true));

    final JoystickButton conveyerButton = new JoystickButton(driveController, Constants.BUTTON_ID.CONVEYER_BUTTON);
    conveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, true));
    conveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, true));

    final JoystickButton invertedConveyerButton = new JoystickButton(driveController,
        Constants.BUTTON_ID.INVERTED_CONVEYER_BUTTON);
    invertedConveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, false));
    invertedConveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, false));

    final JoystickButton shooterButton = new JoystickButton(driveController,
        Constants.BUTTON_ID.INVERTED_SHOOTER_BUTTON);
    shooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true, true));
    shooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false, true));

    final JoystickButton invertedShooterButton = new JoystickButton(driveController,
        Constants.BUTTON_ID.SHOOTER_BUTTON);
    invertedShooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true, false));
    invertedShooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false, false));

    final JoystickButton colorWheelButton = new JoystickButton(driveController, Constants.BUTTON_ID.COLOR_WHEEL_BUTTON);
    colorWheelButton.whileHeld(new colorWheelCommand(ColorWheelSubsystem, true, false));
    colorWheelButton.whenReleased(new colorWheelCommand(ColorWheelSubsystem, false, false));

    final JoystickButton pneumaticsUpButton = new JoystickButton(driveController, Constants.BUTTON_ID.PNEUMATIC_UP_BUTTON);
    pneumaticsUpButton.whenReleased(new PneumaticsCommand(ColorWheelSubsystem, true));
    //pneumaticsUpButton.whileHeld(new PneumaticsCommand(ColorWheelSubsystem, false));
    final JoystickButton pneumaticsDownButton = new JoystickButton(driveController, Constants.BUTTON_ID.PNEUMATIC_DOWN_BUTTON);
    pneumaticsDownButton.whenReleased(new PneumaticsCommand(ColorWheelSubsystem, false));
    //pneumaticsDownButton.whileHeld(new PneumaticsCommand(ColorWheelSubsystem, false));

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