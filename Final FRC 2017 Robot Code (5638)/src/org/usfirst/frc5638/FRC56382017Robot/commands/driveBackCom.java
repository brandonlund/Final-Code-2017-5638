package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class driveBackCom extends Command {
    public driveBackCom() {
    	requires(Robot.driveTrain);
    	setTimeout(1);
    }

    protected void initialize() {
    	Robot.driveTrain.driveBackward();
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