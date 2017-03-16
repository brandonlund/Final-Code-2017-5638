package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class midGear extends CommandGroup {
    public midGear() {
    	addSequential(new doNothing());
    	addSequential(new visionCom());
    	addSequential(new driveForwardCom());
    	addSequential(new placeGear());
    	addSequential(new driveBackCom());
    }
}