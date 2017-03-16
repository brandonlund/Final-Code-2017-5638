package org.usfirst.frc5638.FRC56382017Robot.subsystems;

import org.usfirst.frc5638.FRC56382017Robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class servoMotors extends Subsystem {
    private final Servo servo1 = RobotMap.servoMotorsservo1;
    private final Servo servo2 = RobotMap.servoMotorsservo2;

    public void initDefaultCommand() {
    }
    
    public void servoUp(){
    	servo1.set(.5);
    	servo1.setAngle(180);
    	servo2.set(-.5);
    	servo2.setAngle(0);
    }
    
    public void servoDown(){
    	servo1.set(-.5);
    	servo1.setAngle(0);
    	servo2.set(.5);
    	servo2.setAngle(180);
    }
    
    public void servoStop(){
    	servo1.set(180);
    	servo2.set(0);
    }
}