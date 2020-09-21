/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // TODO: Make Constants static classes
    public static final int PEW_LEFT_CAN_ID = 1; 
    public static final int PEW_RIGHT_CAN_ID = 2; 
    public static final int REAR_LEFT_CAN_ID = 3;
    public static final int REAR_RIGHT_CAN_ID = 4;
    public static final int INTAKE_CAN_ID = 4;
    public static final int FRONT_LEFT_CAN_ID = 5;
    public static final int RIGHT_ACTUATOR_CAN_ID = 5;
    public static final int FRONT_RIGHT_CAN_ID = 6;
    public static final int COLOR_WHEEL_CAN_ID = 6;
    public static final int CONVEYER_CAN_ID = 7;
    public static final int LEFT_ACTUATOR_CAN_ID = 8;
    
    public static final int DRIVE_JOYSTICK_USB_ID = 0;
    public static final int XBOX_CONTROLLER_USB_ID = 1;
    
    public static final int INTAKE_BUTTON = 2;
    public static final int INVERTED_INTAKE_BUTTON = 7;
    public static final int CONVEYER_BUTTON = XboxController.Button.kX.value; 
    public static final int INVERTED_CONVEYER_BUTTON = XboxController.Button.kA.value;

    public static final int COLOR_WHEEL_BUTTON = XboxController.Button.kB.value;
    public static final int SHOOTER_BUTTON = XboxController.Button.kY.value;
    public static final int INVERTED_SHOOTER_BUTTON = XboxController.Button.kStart.value;

    public static final int RIGHT_ACTUATOR_BUTTON = XboxController.Button.kBumperRight.value;
    public static final int LEFT_ACTUATOR_BUTTON = XboxController.Button.kBumperLeft.value;
    public static final int INVERTED_RIGHT_ACTUATOR_BUTTON = 9;
    public static final int INVERTED_LEFT_ACTUATOR_BUTTON = 10;
}
