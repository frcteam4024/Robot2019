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
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

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
    masterLiftSpark = new CANSparkMax(RobotMap.LIFTARM_MASTER_SPARKMAX, MotorType.kBrushless);
    slaveLiftSpark = new CANSparkMax(RobotMap.LIFTARM_SLAVE_SPARKMAX, MotorType.kBrushless);
    rotateTalon = new WPI_TalonSRX(RobotMap.ROTATE_SCISSOR_ARM);
    scissorTalon = new WPI_TalonSRX(RobotMap.SCISSOR_ARM_TALON);
  
    slaveLiftSpark.follow(masterLiftSpark);
  }

  public void driveLift(double liftSpeed, double armSpeed, boolean rotation) {
    raiseLift(liftSpeed);
    if(rotation) {
      rotateScissorArm(armSpeed/3);
    } else {
      engageScissorArm(armSpeed);
    }
  }
 
  //Elevator Controlls
  
  public void raiseLift() {
    masterLiftSpark.set(1);
  }

  public void lowerLift() {
    masterLiftSpark.set(-1);
  }
  
  public void raiseLift(double speed) {
    masterLiftSpark.set(speed);
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

  public void lockArm() {
    rotateTalon.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftDrive());
  }

}
