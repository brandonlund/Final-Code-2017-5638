package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class placeGear extends CommandGroup {
    public placeGear() {
    	addSequential(new servoComDown());
    	Timer.delay(.5);
    	addSequential(new pushGearOutCom());
    	Timer.delay(.5);
   		addSequential(new pushGearInCom());
   		Timer.delay(.5);
   		addSequential(new servoComUp());
    }
}