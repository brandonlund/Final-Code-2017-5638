package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class pushGearCom extends CommandGroup {

    public pushGearCom() {
    	addSequential(new pushGearOutCom());
    	Timer.delay(1);
    	addSequential(new pushGearInCom());
    }
}