package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCartesian;

public class Drivetrain extends Subsystem {

    private WPI_TalonSRX frontRight = null;
    private WPI_TalonSRX frontLeft = null;
    private WPI_TalonSRX backRight = null;
    private WPI_TalonSRX backLeft = null;

    private MecanumDrive driveTrain = null;

    private int dIndex = 0;
    private int[] dividers = {1, 2, 4};

    public Drivetrain() {
        /*
         * The declaration numbers are to keep track of which motor controller is which.
         * Using the RobotMap class reduces the number of unexplained numbers (also
         * called magic numbers) in the code. This applies for all sorts of things
         * besides motor controllers.
         */
        frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT);
        frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT);
        backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT);
        backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT);

        driveTrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveCartesian());
    }

    public void move(double yAxis, double xAxis, double zRotation) {
        driveTrain.driveCartesian(yAxis/dividers[dIndex], xAxis/dividers[dIndex], zRotation/dividers[dIndex]);
    }

    public boolean decreaseSpeed() {
        if (dIndex < 2) {
            dIndex++;
            return true;
        } else {
            return false;
        }
    }

    public boolean increaseSpeed() {
        if (dIndex > 0) {
            dIndex--;
            return true;
        } else {
            return false;
        }
    }
}