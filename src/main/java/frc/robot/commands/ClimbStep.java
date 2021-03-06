/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ClimbStep extends InstantCommand {

  private Boolean wasEnabled = null;

  public ClimbStep() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.robotLift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.robotLift.podiumClimb();
  }

  // // Called repeatedly when this Command is scheduled to run
  // @Override
  // protected void execute() {
  //   if (wasEnabled == null && Robot.oi.buttonBoard.getRawButton(RobotMap.BIG_RED_BUTTON)) {
  //     Robot.robotLift.podiumClimb();
  //     wasEnabled = true;
  //   } else if (wasEnabled != null) {
  //     if (wasEnabled && Robot.oi.buttonBoard.getRawButton(RobotMap.BIG_RED_BUTTON)) {
  //       Robot.robotLift.retractCasterWheel();
  //       wasEnabled = false;
  //     } else if (!wasEnabled && Robot.oi.buttonBoard.getRawButton(RobotMap.BIG_RED_BUTTON)) {
  //       Robot.robotLift.retractRearWheels();
  //       wasEnabled = null;
  //     }
  //   }
    
  // }

  // // Make this return true when this Command no longer needs to run execute()
  // @Override
  // protected boolean isFinished() {
  //   return false;
  // }

  // // Called once after isFinished returns true
  // @Override
  // protected void end() {
    
  // }

  // // Called when another command which requires one or more of the same
  // // subsystems is scheduled to run
  // @Override
  // protected void interrupted() {
  // }
}
