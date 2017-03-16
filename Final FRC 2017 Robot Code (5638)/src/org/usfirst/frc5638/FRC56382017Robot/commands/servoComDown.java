package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class servoComDown extends Command {
    public servoComDown() {
        requires(Robot.servoMotors);
    }

    protected void initialize() {
    	Robot.servoMotors.servoDown();
    	setTimeout(.5);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	if(isTimedOut()){
    		return true;
    	}else{
    		return false;
    	}
    }

    protected void end() {
    	Robot.servoMotors.servoStop();
    }

    protected void interrupted() {
    	end();
    }
}