/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbStep;;

/**
 * Add your docs here.
 */
public class PodiumLift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static DoubleSolenoid wheelLift = null;
  private static DoubleSolenoid frontLift = null;

  public PodiumLift() {
    wheelLift = new DoubleSolenoid(RobotMap.BACK_DOWN_CHANNEL, RobotMap.BACK_UP_CHANNEL);
    frontLift = new DoubleSolenoid(RobotMap.FRONT_DOWN_CHANNEL, RobotMap.FRONT_UP_CHANNEL);
    //wheelLift.set(Value.kOff);
    //frontLift.set(Value.kOff);
  }

  public void podiumClimb() {
    wheelLift.set(Value.kForward);
    frontLift.set(Value.kForward);
  }

  public void retractWheels() {
    wheelLift.set(Value.kReverse);
    frontLift.set(Value.kReverse);
  }

  public void retractCasterWheel() {
    frontLift.set(Value.kReverse);
  }

  public void retractRearWheels() {
    wheelLift.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ClimbStep());
  }
}
