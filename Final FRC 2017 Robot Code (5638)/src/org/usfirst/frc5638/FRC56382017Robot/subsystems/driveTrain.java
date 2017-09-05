package org.usfirst.frc5638.FRC56382017Robot.subsystems;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import org.usfirst.frc5638.FRC56382017Robot.RobotMap;
import org.usfirst.frc5638.FRC56382017Robot.commands.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class driveTrain extends Subsystem {
	public AHRS ahrs;
	
    private final SpeedController frontRight = RobotMap.driveTrainfrontRight;
    private final SpeedController frontLeft = RobotMap.driveTrainfrontLeft;
    private final SpeedController rearRight = RobotMap.driveTrainrearRight;
    private final SpeedController rearLeft = RobotMap.driveTrainrearLeft;
    private final RobotDrive driveMotors = RobotMap.driveTraindriveMotors;
    
    public void initDefaultCommand() {
        setDefaultCommand(new driveWithJoystick());
        
        try{
        	ahrs = new AHRS(SPI.Port.kMXP);
        }catch(RuntimeException ex){
        	DriverStation.reportError("ahrs problem: " + ex.getMessage(), true);
        }
    }
         
    public void drive(XboxController xbox){
		driveMotors.mecanumDrive_Cartesian(-xbox.getRawAxis(0), -xbox.getRawAxis(1), -xbox.getRawAxis(4), ahrs.getYaw());
		
	    if(Robot.oi.xbox.getRawButton(3) == true){
	    	ahrs.zeroYaw();
	    }
	    if(xbox.getBumper(GenericHID.Hand.kLeft)){
		    double speedRight = -xbox.getTriggerAxis(GenericHID.Hand.kRight);
		    double speedLeft = -xbox.getTriggerAxis(GenericHID.Hand.kLeft);
		    frontLeft.set(speedLeft);
		    rearLeft.set(speedLeft);
		    frontRight.set(-speedLeft/2);
		    
		    frontRight.set(speedRight);
		    rearRight.set(speedRight);
		    frontLeft.set(-speedRight/2);
	    }
	    //GOOD TANK DRIVE
	    /*
	    double forwardTrigger = xbox.getTriggerAxis(GenericHID.Hand.kRight);
	    double reverseTrigger = xbox.getTriggerAxis(GenericHID.Hand.kLeft);
	    double turnStick = xbox.getRawAxis(0);
	    
	    if(-0.15 < turnStick > 0.15){
	    	turnStick = 0;
	    }
	    if(forwardTrigger + reverseTrigger + turnStick > 1){
	    	leftMotor = 1;
	    }
	    if(forwardTrigger + reverseTrigger - turnStick < -1){
	    	rightMotor = -1;
	    }
	    system.out.println("Left Motor:	"+"leftMotor	Right Motor:	"+"rightMotor");
	    //leftMotor.set(forwardTrigger + reverseTrigger + turnStick);
	    //rightMotor.set(forwardTrigger + reverseTrigger - turnStick);
	    */
	    //END GOOD TANK DRIVE
	    SmartDashboard.putNumber("Gyro Yaw", ahrs.getYaw());
    }
    
    public void stop(){
    	frontLeft.set(0);
    	frontRight.set(0);
    	rearRight.set(0);
    	rearLeft.set(0);
    }
    
    public void driveForward(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-.3);
    	frontRight.set(-.3);
    	rearRight.set(-.3);
    	rearLeft.set(-.3);
    }
    
    public void driveForwardFast(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-.75);
    	frontRight.set(-.75);
    	rearRight.set(-.75);
    	rearLeft.set(-.75);
    }
    
    public void turnRightFast(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-.75);
    	frontRight.set(.75);
    	rearRight.set(.75);
    	rearLeft.set(-.75);
    }
    
    public void turnLeftFast(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-.75);
    	frontRight.set(.75);
    	rearRight.set(.75);
    	rearLeft.set(-.75);
    }
    
    public void driveBackward(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(.25);
    	frontRight.set(.25);
    	rearRight.set(.25);
    	rearLeft.set(.25);
    }
    
    public void turnLeft(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(.2);
    	frontRight.set(-.2);
    	rearRight.set(-.2);
    	rearLeft.set(.2);
    }
    
    public void turnRight(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-.2);
    	frontRight.set(.2);
    	rearRight.set(.2);
    	rearLeft.set(-.2);
    }
    
    public void strafeLeft(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(.25);
    	frontRight.set(-.25);
    	rearRight.set(.25);
    	rearLeft.set(-.25);
    }
    
    public void strafeRight(){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-.25);
    	frontRight.set(.25);
    	rearRight.set(-.25);
    	rearLeft.set(.25);
    }
}
