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
    public static final class VICTOR_SPX_CAN {
        public static final int INTAKE_CAN_ID = 4;
        public static final int RIGHT_ACTUATOR_CAN_ID = 5; 
        public static final int COLOR_WHEEL_CAN_ID = 6; 
        public static final int CONVEYER_CAN_ID = 7; 
        public static final int LEFT_ACTUATOR_CAN_ID = 8;
    }
    public static final class SPARK_MAX_CAN {
        public static final int PEW_LEFT = 1;
        public static final int PEW_RIGHT = 2;
        public static final int REAR_LEFT = 3;
        public static final int REAR_RIGHT = 4;
        public static final int FRONT_LEFT = 5;
        public static final int FRONT_RIGHT = 6;
    }

    public static final class DRIVE_JOYSTICK_BUTTONS {
        public static final int INTAKE = 2;
        public static final int INVERTED_INTAKE = 7;
        public static final int INVERTED_RIGHT_ACTUATOR = 9;
        public static final int INVERTED_LEFT_ACTUATOR = 10;
    }

    public static final class MECHANISM_XBOX_BUTTONS {
        public static final int CONVEYER = XboxController.Button.kX.value; 
        public static final int SHOOTER = XboxController.Button.kY.value; 
        public static final int RIGHT_ACTUATOR = XboxController.Button.kBumperRight.value;
        public static final int LEFT_ACTUATOR = XboxController.Button.kBumperLeft.value;
        public static final int INVERTED_CONVEYER = XboxController.Button.kA.value; 
        public static final int INVERTED_SHOOTER = XboxController.Button.kX.value;
        
        public static final int STAGE_ONE_POV = 0;
        public static final int STAGE_TWO_POV = 90;
        public static final int STOP_COLOR_WHEEL_POV = 180; 
    }

    public static final class COMPUTER_USB_PORTS {
        public static final int DRIVE_JOYSTICK = 0;
        public static final int XBOX_CONTROLLER = 1;
    }

    public static final class PCM {
        public static final int COLOR_WHEEL_UP = 1;
        public static final int COLOR_WHEEL_DOWN = 0;
    }
}
