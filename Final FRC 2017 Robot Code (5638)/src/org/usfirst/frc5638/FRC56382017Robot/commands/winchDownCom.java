package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class winchDownCom extends Command {
    public winchDownCom() {
        requires(Robot.winch);
    }

    protected void initialize() {
    	Robot.winch.winchDown();
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