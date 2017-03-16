package org.usfirst.frc5638.FRC56382017Robot.subsystems;

import org.usfirst.frc5638.FRC56382017Robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class winch extends Subsystem {
    private final SpeedController winchMotor = RobotMap.winchwinchMotor;
    private final SpeedController winchMotor2 = RobotMap.winchwinchMotor2;

    public void initDefaultCommand() {
    }
    
    public void winchUp(){
    	winchMotor.set(.75);
    	winchMotor2.set(.75);
    }
    
    public void winchDown(){
    	winchMotor.set(-.5);
    	winchMotor2.set(-.5);
    }
    
    public void winchStop(){
    	winchMotor.set(0);
    	winchMotor2.set(0);
    }
}