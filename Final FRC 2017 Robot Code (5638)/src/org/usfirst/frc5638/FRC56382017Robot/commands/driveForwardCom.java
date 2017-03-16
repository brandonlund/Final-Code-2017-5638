package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class driveForwardCom extends Command {
    public driveForwardCom() {
    	requires(Robot.driveTrain);
    	setTimeout(2);
    }

    protected void initialize() {
    	Robot.driveTrain.driveForward();
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