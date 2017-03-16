package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class driveRightVision extends CommandGroup {
	//RIGHT SIDE VISION
    public driveRightVision() {
    	addSequential(new ForwardFast());
    	addSequential(new LeftFast());
        addSequential(new visionCom());
        addSequential(new driveForwardCom());
        addSequential(new placeGear());
        addSequential(new driveBackCom());
        addSequential(new stopCom());
    } 
}