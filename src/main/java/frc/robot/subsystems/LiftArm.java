/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.RaiseLift;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 

/**
 * Add your docs here.
 */
public class LiftArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX liftTalon = null;

  public LiftArm() {
    liftTalon = new WPI_TalonSRX(RobotMap.LIFT_ARM_TALON);
  }
 
  public void raiseArm() {
    liftTalon.set(ControlMode.PercentOutput, 0.5);
  }
  
  public void raiseArm(double speed) {
    liftTalon.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RaiseLift());
  }
}
