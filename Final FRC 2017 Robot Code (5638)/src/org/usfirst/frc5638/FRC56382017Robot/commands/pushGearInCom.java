package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class pushGearInCom extends Command {
    public pushGearInCom() {
        requires(Robot.pushGear);
    }

    protected void initialize() {
    	Robot.pushGear.pushGearIn();
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
    }

    protected void interrupted() {
    	end();
    }
}