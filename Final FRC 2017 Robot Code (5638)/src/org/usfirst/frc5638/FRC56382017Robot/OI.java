package org.usfirst.frc5638.FRC56382017Robot;

import org.usfirst.frc5638.FRC56382017Robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;;

public class OI {
	
    public JoystickButton winchUp;
    public JoystickButton winchDown;
    public JoystickButton servoButtonUp;
    public JoystickButton servoButtonDown;
    public JoystickButton placeGearButton;
    public JoystickButton cylinderIn;
    public JoystickButton cylinderOut;
    public XboxController xbox;
    
    public OI() {
    	xbox = new XboxController(0);
        //start deadzone
    	if(xbox.getRawAxis(1) < 0.2 || xbox.getRawAxis(1) > -0.2){
        	RobotMap.driveTrainfrontLeft.set(0);
        	RobotMap.driveTrainrearLeft.set(0);
        	RobotMap.driveTrainfrontRight.set(0);
        	RobotMap.driveTrainrearRight.set(0);
        }
    	
        if(xbox.getRawAxis(4) < 0.2 || xbox.getRawAxis(4) > -0.2){
        	RobotMap.driveTrainfrontLeft.set(0);
        	RobotMap.driveTrainrearLeft.set(0);
        	RobotMap.driveTrainfrontRight.set(0);
        	RobotMap.driveTrainrearRight.set(0);
        }
        
        if(xbox.getRawAxis(0) < 0.2 || xbox.getRawAxis(0) > -0.2){
        	RobotMap.driveTrainfrontLeft.set(0);
        	RobotMap.driveTrainrearLeft.set(0);
        	RobotMap.driveTrainfrontRight.set(0);
        	RobotMap.driveTrainrearRight.set(0);
        }
        //end deadzone
        //buttons
        servoButtonDown = new JoystickButton(xbox, 1);
        servoButtonDown.toggleWhenPressed(new servoComDown());
        while(RobotState.isEnabled()){
	        if(RobotMap.servoMotorsservo1.getAngle() == 0){
	        	SmartDashboard.putBoolean("servo down", true);
	        }else{
	        	SmartDashboard.putBoolean("servo down", false);
	        }
        }
        winchUp = new JoystickButton(xbox, 4);
        winchUp.whileHeld(new winchUpCom());
        cylinderIn = new JoystickButton(xbox, 2);
        cylinderIn.whenReleased(new pushGearInCom());
        cylinderOut = new JoystickButton(xbox, 2);
        cylinderOut.whenPressed(new pushGearOutCom());
        placeGearButton = new JoystickButton(xbox, 6);
        placeGearButton.whenPressed(new placeGear());

        //SmartDashboard Buttons
        SmartDashboard.putData("driveWithJoystick", new driveWithJoystick());
        SmartDashboard.putData("winchUpCom", new winchUpCom());
        SmartDashboard.putData("winchDownCom", new winchDownCom());
        SmartDashboard.putData("pushGearOutCom", new pushGearOutCom());
        SmartDashboard.putData("pushGearInCom", new pushGearInCom());
        SmartDashboard.putData("servoComUp", new servoComUp());
        SmartDashboard.putData("servoComDown", new servoComDown());
        SmartDashboard.putData("visionCom", new visionCom());
        SmartDashboard.putData("placeGear", new placeGear());
    }
    
    public XboxController xbox() {
    	return xbox;
    }
}