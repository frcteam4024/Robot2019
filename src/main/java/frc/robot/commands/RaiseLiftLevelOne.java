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

/**
 * Add your docs here.
 */
public class RaiseLiftLevelOne extends InstantCommand {

  private boolean isUp;
  /**
   * Add your docs here.
   */
  public RaiseLiftLevelOne() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.liftSystem);
  }

  public RaiseLiftLevelOne(boolean liftLevel) {
    super();
    isUp = liftLevel;
    requires(Robot.liftSystem);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    setTimeout(RobotMap.TIME_TO_LEVEL1); 
    while(!isTimedOut()) {
      if (isUp) {
        Robot.liftSystem.lowerLift();
      } else {
        Robot.liftSystem.raiseLift();
      }
    }
  }

}
