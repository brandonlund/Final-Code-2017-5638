package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import org.usfirst.frc5638.FRC56382017Robot.RobotMap;

public class visionCom extends Command {
	boolean z = false;
	
    public visionCom() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }
    
    protected void execute() {
        NetworkTable table;
      	table = NetworkTable.getTable("GRIP/myContoursReport");
      	double[] defaultValue = new double[0];
	    double[] x = table.getNumberArray("centerX", defaultValue);
        double[] a = table.getNumberArray("area", defaultValue);
        
	    RobotMap.driveTraindriveMotors.setSafetyEnabled(false);
	        if(a.length == 2 && x.length == 2){
	        	System.out.println("z: " + z);
	        	z = false;
		       	double centerX = (x[0] + x[1])/2;
		       	double totalArea = a[0] + a[1];
		       	System.out.println("Area: " + totalArea);
			       
		    if(centerX > 360 && x.length == 2){
			    System.out.println("TURNING RIGHT");
			    Robot.driveTrain.turnRight();
			    Timer.delay(.05);
			}else if(centerX < 280 && x.length == 2){
		        System.out.println("TURNING LEFT");
		        new turnLeftCom();
		        Robot.driveTrain.turnLeft();
		        Timer.delay(.05);    
			}else if(x.length < 2 || x.length > 2){
			    System.out.println("no x values or too many x values");
			   	Timer.delay(.05);
			}else if(totalArea > 0 && totalArea < 5500){
				System.out.println("DRIVING FORWARD");
			    new driveForwardCom();
		        Robot.driveTrain.driveForward();
		        Timer.delay(.05);
		    }else if(a.length != 2){
		    	System.out.println("area array has more than or less than 2 values");
			    Timer.delay(.05);
		    }else{
		    	System.out.println("robot stopped");
		    	new stopCom();
		    	Robot.driveTrain.stop();
			   	z = true;
			   	Timer.delay(.05);
		    }
			        
		    if(totalArea < 1 || totalArea > 5500){
		    	System.out.println("STOPPED");
			    new stopCom();
		        Robot.driveTrain.stop();
		        z = true;
		    }
		}		
	}
    
    protected boolean isFinished() {
    	System.out.println("z2: " + z);
    	return z;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}