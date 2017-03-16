package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class driveLeftVision extends CommandGroup {
	//LEFT SIDE VISION
    public driveLeftVision() {
    	addSequential(new ForwardFast());
    	addSequential(new RightFast());
    	addSequential(new doNothing());
        addSequential(new visionCom());
        addSequential(new driveForwardCom());
        addSequential(new placeGear());
        addSequential(new driveBackCom());
        addSequential(new stopCom());
    }
}