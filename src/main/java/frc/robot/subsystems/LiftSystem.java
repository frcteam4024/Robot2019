/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

/**
 * Add your docs here.
 */
public class LiftSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX liftTalon = null;
  private CANSparkMax masterLiftSpark = null;
  private CANSparkMax slaveLiftSpark = null;
  private WPI_TalonSRX rotateTalon = null;
  private WPI_TalonSRX scissorTalon = null;

  public LiftSystem() {
    liftTalon = new WPI_TalonSRX(RobotMap.LIFT_ARM_TALON);
    rotateTalon = new WPI_TalonSRX(RobotMap.ROTATE_SCISSOR_ARM);
    scissorTalon = new WPI_TalonSRX(RobotMap.SCISSOR_ARM_TALON);
  }

  public void driveLift(double liftSpeed, double armSpeed, boolean rotation) {
    raiseLift(liftSpeed);
    if(rotation) {
      rotateScissorArm(armSpeed);
    } else {
      engageScissorArm(armSpeed);
    }
  }
 
  //Elevator Controlls
  
  public void raiseLift() {
    liftTalon.set(ControlMode.PercentOutput, 1);
  }

  public void lowerLift() {
    liftTalon.set(ControlMode.PercentOutput, -1);
  }
  
  public void raiseLift(double speed) {
    liftTalon.set(ControlMode.PercentOutput, speed);
  }

  //Scissor Arm Controlls

  private void closeScissorArm() {
    scissorTalon.set(ControlMode.PercentOutput, 1);
  }

  private void openScissorArm() {
    scissorTalon.set(ControlMode.PercentOutput, -1);
  }

  private void engageScissorArm(double speed) {
    scissorTalon.set(ControlMode.PercentOutput, speed);
  }

  //Stow Arm Controls

  private void raiseScissorArm() {
    rotateTalon.set(ControlMode.PercentOutput, 1);
  }

  private void lowerScissorArm() {
    rotateTalon.set(ControlMode.PercentOutput, -1);
  }

  private void rotateScissorArm(double speed) {
    rotateTalon.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftDrive());
  }
}
