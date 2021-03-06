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
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.actuator.LeftActuatorCommand;
import frc.robot.commands.actuator.RightActuatorCommand;
import frc.robot.commands.colorWheel.ColorCountCommand;
import frc.robot.commands.colorWheel.ColorMatchCommand;
import frc.robot.commands.colorWheel.PneumaticsCommand;
import frc.robot.commands.colorWheel.ResetCommand;
import frc.robot.commands.colorWheel.StopColorWheel;
import frc.robot.commands.conveyer.AutoConveyerCommand;
import frc.robot.commands.conveyer.ConveyerCommand;
import frc.robot.commands.drive.AutoDriveCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.intake.AutoIntakeCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.commands.shooter.AutoShooterCommand;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LeftActuatorSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;
import frc.robot.subsystems.RightActuatorSubsystem;
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
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final Joystick driveJoystick = new Joystick(Constants.COMPUTER_USB_PORTS.DRIVE_JOYSTICK);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
  private final XboxController driveController = new XboxController(Constants.COMPUTER_USB_PORTS.XBOX_CONTROLLER);
  private final RightActuatorSubsystem rightActuatorSubsystem = new RightActuatorSubsystem();
  private final LeftActuatorSubsystem leftActuatorSubsystem = new LeftActuatorSubsystem();
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
    
    JoystickButton intakeButton = new JoystickButton(driveJoystick, Constants.DRIVE_JOYSTICK_BUTTONS.INTAKE);
    intakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, true));
    intakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, true));

    JoystickButton invertedIntakeButton = new JoystickButton(driveJoystick, Constants.DRIVE_JOYSTICK_BUTTONS.INVERTED_INTAKE);
    invertedIntakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, false));
    invertedIntakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, false));

    JoystickButton conveyerButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.CONVEYER);
    conveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, true));
    conveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, true));

    JoystickButton invertedConveyerButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.INVERTED_CONVEYER);
    invertedConveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, false));
    invertedConveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, false));

    JoystickButton shooterButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.SHOOTER);
    shooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true, true));
    shooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false, true));

    JoystickButton invertedShooterButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.INVERTED_SHOOTER);
    invertedShooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true, false));
    invertedShooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false, false));

    JoystickButton leftActuatorButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.LEFT_ACTUATOR);
    leftActuatorButton.whileHeld(new LeftActuatorCommand(leftActuatorSubsystem, true, true));
    leftActuatorButton.whenReleased(new LeftActuatorCommand(leftActuatorSubsystem, false, true));

    JoystickButton invertedLeftActuatorButton = new JoystickButton(driveJoystick, Constants.DRIVE_JOYSTICK_BUTTONS.INVERTED_LEFT_ACTUATOR);
    invertedLeftActuatorButton.whileHeld(new LeftActuatorCommand(leftActuatorSubsystem, true, false));
    invertedLeftActuatorButton.whenReleased(new LeftActuatorCommand(leftActuatorSubsystem, false, false));

    JoystickButton rightActuatorButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.RIGHT_ACTUATOR);
    rightActuatorButton.whileHeld(new RightActuatorCommand(rightActuatorSubsystem, true, true));
    rightActuatorButton.whenReleased(new RightActuatorCommand(rightActuatorSubsystem, false, true));

    JoystickButton invertedRightActuatorButton = new JoystickButton(driveJoystick, Constants.DRIVE_JOYSTICK_BUTTONS.INVERTED_RIGHT_ACTUATOR);
    invertedRightActuatorButton.whileHeld(new RightActuatorCommand(rightActuatorSubsystem, true, false));
    invertedRightActuatorButton.whenReleased(new RightActuatorCommand(rightActuatorSubsystem, false, false));

    final POVButton stageOneButton = new POVButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.STAGE_ONE_POV);
    stageOneButton.whenReleased(new PneumaticsCommand(colorWheelSubsystem, false)
        .andThen(new ResetCommand(colorWheelSubsystem)).andThen(new ColorCountCommand(colorWheelSubsystem))
        .andThen(new WaitCommand(0.5)).andThen(new PneumaticsCommand(colorWheelSubsystem, true)));

    final POVButton stageTwoButton = new POVButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.STAGE_TWO_POV);
    stageTwoButton.whenReleased(new PneumaticsCommand(colorWheelSubsystem, false)
        .andThen(new ResetCommand(colorWheelSubsystem)).andThen(new ColorMatchCommand(colorWheelSubsystem))
        .andThen(new WaitCommand(0.5)).andThen(new PneumaticsCommand(colorWheelSubsystem, true)));

    final POVButton stopColorWheel = new POVButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.STOP_COLOR_WHEEL_POV);
    stopColorWheel.whenReleased(
        new StopColorWheel(colorWheelSubsystem).andThen(new PneumaticsCommand(colorWheelSubsystem, true)));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new AutoDriveCommand(driveSubsystem, 1, 0,0 )
    .andThen(new WaitCommand(5));
    
    
  }
}