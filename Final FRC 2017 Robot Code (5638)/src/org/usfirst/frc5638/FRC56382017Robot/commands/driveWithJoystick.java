package org.usfirst.frc5638.FRC56382017Robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class driveWithJoystick extends Command {
    public driveWithJoystick() {
        requires(Robot.driveTrain);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	Robot.driveTrain.drive(Robot.oi.xbox);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}