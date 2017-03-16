package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class winchUpCom extends Command {
    public winchUpCom() {
        requires(Robot.winch);
    }

    protected void initialize() {
    	Robot.winch.winchUp();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.winch.winchStop();
    }

    protected void interrupted() {
    	end();
    }
}