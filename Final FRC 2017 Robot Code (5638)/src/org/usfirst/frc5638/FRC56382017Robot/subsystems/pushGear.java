package org.usfirst.frc5638.FRC56382017Robot.subsystems;

import org.usfirst.frc5638.FRC56382017Robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class pushGear extends Subsystem {
    private final DoubleSolenoid pushGearSol = RobotMap.pushGearpushGearSol;
    
    public void initDefaultCommand() {
    }
    
    public void pushGearOut(){
    	pushGearSol.set(DoubleSolenoid.Value.kForward);
    }
    
    public void pushGearIn(){
    	pushGearSol.set(DoubleSolenoid.Value.kReverse);
    }
}