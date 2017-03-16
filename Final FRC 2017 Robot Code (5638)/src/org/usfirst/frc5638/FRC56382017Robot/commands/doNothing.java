package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class doNothing extends Command {

    public doNothing() {
    	requires(Robot.driveTrain);
    	setTimeout(.5);
    }

    protected void initialize() {
    	Robot.driveTrain.stop();
    }

    protected void execute() {
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