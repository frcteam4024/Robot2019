/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class IncreaseDrivetrainSpeed extends InstantCommand {
  /**
   * Add your docs here.
   */
  public IncreaseDrivetrainSpeed() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    boolean executed = Robot.drivetrain.increaseSpeed();
    SendableChooser<InstantCommand> result = new SendableChooser<>();
    if (executed) {
      result.setDefaultOption("Speed is as low as possible.", new DecreaseDrivetrainSpeed());
      SmartDashboard.putData(result);
    } else {
      result.setDefaultOption("Speed was decreased.", new DecreaseDrivetrainSpeed());
      SmartDashboard.putData(result);
    }
  }

}
