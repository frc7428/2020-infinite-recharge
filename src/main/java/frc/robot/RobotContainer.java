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
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.actuator.leftActuatorCommand;
import frc.robot.commands.actuator.rightActuatorCommand;
import frc.robot.commands.colorWheel.ColorCountCommand;
import frc.robot.commands.colorWheel.ColorMatchCommand;
import frc.robot.commands.colorWheel.PneumaticsCommand;
import frc.robot.commands.colorWheel.ResetCommand;
import frc.robot.commands.colorWheel.StopColorWheel;
import frc.robot.commands.conveyer.ConveyerCommand;
import frc.robot.commands.drive.AutoDriveCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
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
        private final IntakeSubsytem intakeSubsystem = new IntakeSubsytem();
        private final Joystick driveJoystick = new Joystick(Constants.USB_ID.DRIVE_JOYSTICK_USB_ID);
        private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
        private final XboxController driveController = new XboxController(Constants.USB_ID.XBOX_CONTROLLER_USB_ID);
        // private final RightActuatorSubsystem rightActuatorSubsystem = new
        // RightActuatorSubsystem();
        // private final LeftActuatorSubsystem leftActuatorSubsystem = new
        // LeftActuatorSubsystem();
        private final ConveyerSubsystem conveyerSubsystem = new ConveyerSubsystem();
        private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
        private final LeftActuatorSubsystem leftActuatorSubsystem = new LeftActuatorSubsystem();
        private final RightActuatorSubsystem rightActuatorSubsystem = new RightActuatorSubsystem();

        private final Command driveForwardAuto = new ParallelRaceGroup(new AutoDriveCommand(driveSubsystem, 1, 0, 0),
                        new WaitCommand(1)).andThen(new AutoDriveCommand(driveSubsystem, 0, 0, 0));

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
                final JoystickButton intakeButton = new JoystickButton(driveJoystick,
                                Constants.BUTTON_ID.INTAKE_BUTTON);
                intakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, false));
                intakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, false));

                final JoystickButton invertedIntakeButton = new JoystickButton(driveJoystick,
                                Constants.BUTTON_ID.INVERTED_INTAKE_BUTTON);
                invertedIntakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, true));
                invertedIntakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, true));

                final JoystickButton conveyerButton = new JoystickButton(driveController,
                                Constants.BUTTON_ID.CONVEYER_BUTTON);
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

                final JoystickButton stageOneButton = new JoystickButton(driveController,
                                Constants.BUTTON_ID.STAGE_ONE_BUTTON);
                stageOneButton.whenReleased(new PneumaticsCommand(colorWheelSubsystem, false)
                                .andThen(new ResetCommand(colorWheelSubsystem))
                                .andThen(new ColorCountCommand(colorWheelSubsystem)).andThen(new WaitCommand(0.5))
                                .andThen(new PneumaticsCommand(colorWheelSubsystem, true)));
                final JoystickButton stageTwoButton = new JoystickButton(driveController,
                                Constants.BUTTON_ID.STAGE_TWO_BUTTON);
                stageTwoButton.whenReleased(new PneumaticsCommand(colorWheelSubsystem, false)
                                .andThen(new ResetCommand(colorWheelSubsystem))
                                .andThen(new ColorMatchCommand(colorWheelSubsystem)).andThen(new WaitCommand(0.5))
                                .andThen(new PneumaticsCommand(colorWheelSubsystem, true)));

                final JoystickButton stopColorWheel = new JoystickButton(driveController,
                                Constants.BUTTON_ID.STOP_COLOR_WHEEL);
                stopColorWheel.whenReleased(new StopColorWheel(colorWheelSubsystem)
                                .andThen(new PneumaticsCommand(colorWheelSubsystem, true)));

                final JoystickButton leftActuatorButton = new JoystickButton(driveJoystick,
                                Constants.BUTTON_ID.LEFT_ACTUATOR_BUTTON_UP);
                leftActuatorButton.whileHeld(new leftActuatorCommand(leftActuatorSubsystem, true, true));
                leftActuatorButton.whenReleased(new leftActuatorCommand(leftActuatorSubsystem, false, true));

                final JoystickButton leftActuatorButtonDown = new JoystickButton(driveJoystick,
                                Constants.BUTTON_ID.LEFT_ACTUATOR_BUTTON_DOWN);
                leftActuatorButtonDown.whileHeld(new leftActuatorCommand(leftActuatorSubsystem, true, false));
                leftActuatorButtonDown.whenReleased(new leftActuatorCommand(leftActuatorSubsystem, false, false));

                final JoystickButton rightActuatorButton = new JoystickButton(driveJoystick,
                                Constants.BUTTON_ID.RIGHT_ACTUATOR_BUTTON_UP);
                rightActuatorButton.whileHeld(new rightActuatorCommand(rightActuatorSubsystem, true, true));
                rightActuatorButton.whenReleased(new rightActuatorCommand(rightActuatorSubsystem, false, true));

                final JoystickButton rightActuatorButtonDown = new JoystickButton(driveJoystick,
                                Constants.BUTTON_ID.RIGHT_ACTUATOR_BUTTON_DOWN);
                rightActuatorButtonDown.whileHeld(new rightActuatorCommand(rightActuatorSubsystem, true, false));
                rightActuatorButtonDown.whenReleased(new rightActuatorCommand(rightActuatorSubsystem, false, false));

                final JoystickButton dualActuatorDown = new JoystickButton(driveJoystick, Constants.BUTTON_ID.DUAL_ACTUATOR_DOWN);
                dualActuatorDown.whileHeld(
                                new ParallelCommandGroup(new rightActuatorCommand(rightActuatorSubsystem, true, true),
                                                new leftActuatorCommand(leftActuatorSubsystem, true, true)));
                dualActuatorDown.whenReleased(
                                new ParallelCommandGroup(new rightActuatorCommand(rightActuatorSubsystem, false, true),
                                                new leftActuatorCommand(leftActuatorSubsystem, false, true)));

                final JoystickButton dualActuatorUp = new JoystickButton(driveJoystick, Constants.BUTTON_ID.DUAL_ACTUATOR_UP);
                dualActuatorUp.whileHeld(
                                new ParallelCommandGroup(new rightActuatorCommand(rightActuatorSubsystem, true, false),
                                                new leftActuatorCommand(leftActuatorSubsystem, true, false)));
                dualActuatorUp.whenReleased(
                                new ParallelCommandGroup(new rightActuatorCommand(rightActuatorSubsystem, false, false),
                                                new leftActuatorCommand(leftActuatorSubsystem, false, false)));

        }

        /**
         * Use this to pass the autonomous command to the main {@link Robot} class.
         *
         * @return the command to run in autonomous
         */
        public Command getAutonomousCommand() {
                // An ExampleCommand will run in autonomous
                return driveForwardAuto;
        }
}