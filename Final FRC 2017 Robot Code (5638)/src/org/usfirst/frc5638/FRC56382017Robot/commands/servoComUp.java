package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class servoComUp extends Command {
    public servoComUp() {
        requires(Robot.servoMotors);
    }

    protected void initialize() {
    	Robot.servoMotors.servoUp();
    	setTimeout(.6);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return true;
    }

    protected void end() {
    	Robot.servoMotors.servoStop();
    }

    protected void interrupted() {
    	end();
    }
}