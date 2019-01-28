package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem {

    TalonSRX frontRight;
    TalonSRX frontLeft;
    TalonSRX backRight;
    TalonSRX backLeft;

    @Override
    protected void initDefaultCommand() {
        
        /* The declaration numbers are to keep track of which motor controller is which.
         * Using the RobotMap class reduces the number of unexplained numbers (also called magic numbers)
         * in the code. This applies for all sorts of things besides motor controllers.
         */
        frontRight = new TalonSRX(RobotMap.frontRightTalon);
        frontLeft = new TalonSRX(RobotMap.frontLeftTalon);
        backRight = new TalonSRX(RobotMap.backRightTalon);
        backLeft = new TalonSRX(RobotMap.backLeftTalon); 
    	
    	
    }

    public void move(double rightSide, double leftSide) {
        frontRight.set(ControlMode.PercentOutput, rightSide);
        backRight.set(ControlMode.PercentOutput, rightSide);
        frontLeft.set(ControlMode.PercentOutput, -leftSide);
        backLeft.set(ControlMode.PercentOutput, -leftSide);
    }

    public void moveSideways(double rightDiagonal, double leftDiagonal) {
        frontRight.set(ControlMode.PercentOutput, rightDiagonal);
        backRight.set(ControlMode.PercentOutput, leftDiagonal);
        frontLeft.set(ControlMode.PercentOutput, leftDiagonal);
        backLeft.set(ControlMode.PercentOutput, rightDiagonal);
    }
}