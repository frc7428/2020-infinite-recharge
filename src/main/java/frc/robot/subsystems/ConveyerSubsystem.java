/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyerSubsystem extends SubsystemBase {
  private final WPI_VictorSPX conveyer = new WPI_VictorSPX(Constants.VICTOR_SPX_CAN.MAIN_CONVEYER_CAN_ID);
  private final WPI_VictorSPX auxConveyer = new WPI_VictorSPX(Constants.VICTOR_SPX_CAN.AUXILIARY_CONVEYER_CAN_ID);
  /**
   * Creates a new ConveyerSubsystem.
   */
  public ConveyerSubsystem() {
  }

  public void convey(boolean on, boolean up) {
    if (on) {
      // What to do when the conveyer is ON?
      if (up) {
        conveyer.set(1);
          } else {
            conveyer.set(-1);
          }
    } else {
      // What to do when the conveyer is OFF?
      conveyer.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
