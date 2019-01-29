/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;


  //Robot Controlers
  public static int XBOX_CONTROLLER = 0;
  public static int BIG_JOYSTICK = 1;
  public static int BUTTON_BOARD = 2;

  //xBox Buttons
  public static int X_AXIS_LEFT = 0;
  public static int Y_AXIS_LEFT = 1;
  public static int X_AXIS_RIGHT = 4;
  public static int Y_AXIS_RIGHT = 5;

  //Motor Controllers
  public final static int FRONT_RIGHT = 4;
  public final static int FRONT_LEFT = 1;
  public final static int BACK_RIGHT = 3;
  public final static int BACK_LEFT = 2;
}
