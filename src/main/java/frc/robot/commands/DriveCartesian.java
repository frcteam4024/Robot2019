/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCartesian extends Command {
  public DriveCartesian() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double ySpeed = Robot.oi.xboxController.getRawAxis(RobotMap.Y_AXIS_LEFT);
    double xSpeed = Robot.oi.xboxController.getRawAxis(RobotMap.X_AXIS_LEFT);
    double zRotation = Robot.oi.xboxController.getRawAxis(RobotMap.X_AXIS_RIGHT);
    if (!(ySpeed > 0.3)) {
      ySpeed = 0;
    }
    if (!(xSpeed > 0.3)) {
      xSpeed = 0;
    }
    if (!(zRotation > 0.3)) {
      zRotation = 0;
    }
    Robot.drivetrain.move(ySpeed, xSpeed, zRotation);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.move(0.0, 0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
