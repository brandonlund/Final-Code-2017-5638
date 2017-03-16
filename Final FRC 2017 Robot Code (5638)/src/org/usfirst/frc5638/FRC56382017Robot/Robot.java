package org.usfirst.frc5638.FRC56382017Robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc5638.FRC56382017Robot.commands.*;
import org.usfirst.frc5638.FRC56382017Robot.subsystems.*;

public class Robot extends IterativeRobot {
	
    Command autonomousCommand;

    public static OI oi;
    public static driveTrain driveTrain;
    public static winch winch;
    public static pushGear pushGear;
    public static servoMotors servoMotors;

    SendableChooser<Object> autonomousModes;
    
    public void robotInit() {
    	RobotMap.init();
        driveTrain = new driveTrain();
        winch = new winch();
        pushGear = new pushGear();
        servoMotors = new servoMotors();
        oi = new OI();

        autonomousCommand = new doNothing();

        autonomousModes = new SendableChooser<Object>();
        
        autonomousModes.addObject("only vision--JUST A TEST", new visionCom());
        autonomousModes.addObject("Right Side Vision", new driveRightVision());
        autonomousModes.addObject("Left Side Vision", new driveLeftVision());
        autonomousModes.addObject("Baseline", new baseline());
        autonomousModes.addDefault("Nothing", new doNothing());
        
        SmartDashboard.putData("Auto Modes", autonomousModes);
        
        SmartDashboard.putNumber("Servo 1 Angle", RobotMap.servoMotorsservo1.getAngle());
        SmartDashboard.putNumber("Servo 2 Angle", RobotMap.servoMotorsservo2.getAngle());
    }

    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autonomousModes.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public Robot(){
    	CameraServer.getInstance().startAutomaticCapture();
    }
}