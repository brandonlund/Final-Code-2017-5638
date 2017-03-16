package org.usfirst.frc5638.FRC56382017Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    public static Spark driveTrainfrontRight;
    public static Spark driveTrainfrontLeft;
    public static Spark driveTrainrearRight;
    public static Spark driveTrainrearLeft;
    public static RobotDrive driveTraindriveMotors;
    public static Spark winchwinchMotor;
    public static DoubleSolenoid pushGearpushGearSol;
    public static Servo servoMotorsservo1;
    public static Servo servoMotorsservo2;
    public static Ultrasonic ultraSubultraSonic;
    public static Spark winchwinchMotor2;
    public static void init() {
        driveTrainfrontRight = new Spark(0);
        LiveWindow.addActuator("driveTrain", "frontRight", (Spark) driveTrainfrontRight);
        driveTrainfrontRight.setInverted(true);
        
        driveTrainfrontLeft = new Spark(1);
        LiveWindow.addActuator("driveTrain", "frontLeft", (Spark) driveTrainfrontLeft);
        driveTrainfrontLeft.setInverted(false);
        
        driveTrainrearRight = new Spark(2);
        LiveWindow.addActuator("driveTrain", "rearRight", (Spark) driveTrainrearRight);
        driveTrainrearRight.setInverted(true);
        
        driveTrainrearLeft = new Spark(3);
        LiveWindow.addActuator("driveTrain", "rearLeft", (Spark) driveTrainrearLeft);
        driveTrainrearLeft.setInverted(false);
        
        driveTraindriveMotors = new RobotDrive(driveTrainfrontLeft, driveTrainrearLeft,
              driveTrainfrontRight, driveTrainrearRight);
        
        winchwinchMotor = new Spark(4);
        LiveWindow.addActuator("winch", "winchMotor", (Spark) winchwinchMotor);
        
        winchwinchMotor2 = new Spark(5);
        LiveWindow.addActuator("winch", "winchMotor2", (Spark) winchwinchMotor2);
        
        pushGearpushGearSol = new DoubleSolenoid(0, 1);
        LiveWindow.addActuator("pushGear", "pushGearSol", pushGearpushGearSol);
        
        servoMotorsservo1 = new Servo(6);
        LiveWindow.addActuator("servoMotors", "servo1", servoMotorsservo1);
        
        servoMotorsservo2 = new Servo(7);
        LiveWindow.addActuator("servoMotors", "servo2", servoMotorsservo2);
        
        ultraSubultraSonic = new Ultrasonic(0, 1);
        LiveWindow.addSensor("ultraSub", "ultraSonic", ultraSubultraSonic);
        
        driveTraindriveMotors.setSafetyEnabled(true);
        driveTraindriveMotors.setExpiration(0.1);
        driveTraindriveMotors.setSensitivity(0.5);
        driveTraindriveMotors.setMaxOutput(1.0);
    }
}
