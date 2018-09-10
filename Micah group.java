package org.usfirst.frc.team5109.robot;

//Latest code as of 4/11/18

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DriverStation;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	TalonSRX leftMotor1 =  new TalonSRX(8);
	TalonSRX leftMotor2 =  new TalonSRX(9);
	TalonSRX rightMotor1 =  new TalonSRX(7);//10
	TalonSRX rightMotor2 =  new TalonSRX(5);//10
	TalonSRX scalar = new TalonSRX(0);
	Compressor compressor;
	boolean lowgear = false;
	Encoder rightEncoder = new Encoder(0, 1, true); 
	Encoder leftEncoder = new Encoder(8, 9, false); 
	double leftCount = leftEncoder.get();
	double rightCount = rightEncoder.get(); 
	

 

	


	
	
	@Override
	public void robotInit() {
	    compressor = new Compressor(0);
		leftEncoder.setDistancePerPulse(1);
		rightEncoder.setDistancePerPulse(1);		
	}

	
	@Override
	public void autonomousInit() {
			
		//encoder conversion rate is 1564.5 to 1 foot
		
				leftMotor1.set(ControlMode.PercentOutput, -0.3);
				leftMotor2.set(ControlMode.PercentOutput, -0.3);
				rightMotor1.set(ControlMode.PercentOutput, 0.5);
				rightMotor2.set(ControlMode.PercentOutput, 0.5);
				
				Timer.delay(5);
				leftMotor1.set(ControlMode.PercentOutput, 0);
				leftMotor2.set(ControlMode.PercentOutput, 0);
				rightMotor1.set(ControlMode.PercentOutput, 0);
				rightMotor2.set(ControlMode.PercentOutput, 0);
				
				leftCount = -leftEncoder.get();
				rightCount = -rightEncoder.get(); 
				
				System.out.println("Right: " +leftCount);
				System.out.println("Left: " +rightCount);	
				
				
}
	public void encoderDriveStraight(double feet) {
		
		/*double tickDistance = feet; //* ticks in a meter
		
		while (rightCount < tickDistance && leftCount < tickDistance) {
			
			leftCount = leftEncoder.get();
			rightCount = rightEncoder.get(); 
			
			double speed = 0.35;
			
			if( rightEncoder == leftEncoder ) {
				leftMotor1.set(ControlMode.PercentOutput, -1*speed);
				leftMotor2.set(ControlMode.PercentOutput, -1*speed);
				rightMotor1.set(ControlMode.PercentOutput, speed);
				rightMotor2.set(ControlMode.PercentOutput, speed);
			}
			if ( rightCount < leftCount ) {
				if ( rightCount < leftCount *.9 ) {}
				leftMotor1.set(ControlMode.PercentOutput, -speed);
				leftMotor2.set(ControlMode.PercentOutput, -speed);
				rightMotor1.set(ControlMode.PercentOutput, speed);
				rightMotor2.set(ControlMode.PercentOutput, speed);
			}
			if ( leftCount > rightCount ) {
				leftMotor1.set(ControlMode.PercentOutput, -speed);
				leftMotor2.set(ControlMode.PercentOutput, -speed);
				rightMotor1.set(ControlMode.PercentOutput, speed);
				rightMotor2.set(ControlMode.PercentOutput, speed);
			}
			
			
			
		} */
		
		
	}
	public void autonomousPeriodic() {
		
		
	}
       
	
	@Override
	public void teleopInit() {
			}	

	public void teleopPeriodic() {
		}

				

	
	@Override
	public void testInit() {	
	}


	public void testPeriodic() {
		
	}
}
