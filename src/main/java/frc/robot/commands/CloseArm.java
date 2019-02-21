/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CloseArm extends Command {
  public CloseArm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.scissorArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speedX = Robot.oi.bigJoystick.getRawAxis(RobotMap.BIGJOYSTICK_X_AXIS);
    double speedY = Robot.oi.bigJoystick.getRawAxis(RobotMap.BIGJOYSTICK_Y_AXIS);
    Robot.oi.bigJoystick.getRawAxis(RobotMap.FINGER_BUTTON);
    if (Math.abs(speedX) > 0.3 && Math.abs(speedX) > Math.abs(speedY)) {
      Robot.scissorArm.clamp(speedX);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
