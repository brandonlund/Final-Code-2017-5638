package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class baseline extends CommandGroup {

    public baseline() {
        addSequential(new ForwardFast());
        addSequential(new ForwardFast());
        addSequential(new ForwardFast());
    }
}