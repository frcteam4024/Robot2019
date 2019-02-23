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

public class LiftDrive extends Command {
  public LiftDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.liftSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double liftSpeed = Robot.oi.bigJoystick.getRawAxis(RobotMap.BIGJOYSTICK_Y_AXIS);
    double armSpeed = Robot.oi.bigJoystick.getRawAxis(RobotMap.BIGJOYSTICK_X_AXIS);
    boolean rotateArm = Robot.oi.bigJoystick.getRawButton(RobotMap.FINGER_BUTTON);
    if (!(Math.abs(liftSpeed) > 0.3)) {
      liftSpeed = 0.0;
    }
    if(!(Math.abs(armSpeed) > 0.3)) {
      armSpeed = 0.0;
    }
    Robot.liftSystem.driveLift(liftSpeed, armSpeed, rotateArm);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.liftSystem.driveLift(0.0, 0.0, false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
