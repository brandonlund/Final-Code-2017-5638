package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ForwardFast extends Command {

    public ForwardFast() {
    	requires(Robot.driveTrain);
    	setTimeout(.6);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.driveForwardFast();
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