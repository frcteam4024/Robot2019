package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {

    private WPI_TalonSRX frontRight;
    private WPI_TalonSRX frontLeft;
    private WPI_TalonSRX backRight;
    private WPI_TalonSRX backLeft;

    private MecanumDrive driveTrain;


    @Override
    protected void initDefaultCommand() {
        
        /* The declaration numbers are to keep track of which motor controller is which.
         * Using the RobotMap class reduces the number of unexplained numbers (also called magic numbers)
         * in the code. This applies for all sorts of things besides motor controllers.
         */
        frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT);
        frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT);
        backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT);
        backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT); 

        
    	driveTrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    	
    }

    public void move(double yAxis, double xAxis, double zRotation) {
        driveTrain.driveCartesian(yAxis, xAxis, zRotation);
    }

    public void moveSideways(double rightDiagonal, double leftDiagonal) {
        frontRight.set(ControlMode.PercentOutput, rightDiagonal);
        backRight.set(ControlMode.PercentOutput, leftDiagonal);
        frontLeft.set(ControlMode.PercentOutput, leftDiagonal);
        backLeft.set(ControlMode.PercentOutput, rightDiagonal);
    }
}