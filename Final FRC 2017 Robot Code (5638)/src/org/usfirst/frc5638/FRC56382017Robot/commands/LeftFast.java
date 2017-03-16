package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LeftFast extends Command {

    public LeftFast() {
    	requires(Robot.driveTrain);
    	setTimeout(.5);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.turnLeftFast();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}