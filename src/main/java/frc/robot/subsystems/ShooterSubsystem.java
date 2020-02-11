/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkMax shooter = new CANSparkMax(Constants.SHOOTER_BUTTON, MotorType.kBrushless);

  /**
   * Creates a new ShooterSubsystem.
   */
  public ShooterSubsystem() {
  }
  public void shooter(boolean pew) {
    shooter.set(shooter ? 1 : 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
