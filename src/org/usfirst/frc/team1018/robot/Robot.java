
package org.usfirst.frc.team1018.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
//    final String defaultAuto = "Default";
//    final String customAuto = "My Auto";
//    String autoSelected;
//    SendableChooser chooser;
	
	RobotDrive myRobot;
	Joystick rightStick,
		leftStick;
	SpeedController leftMotorOne,
			leftMotorTwo,
			rightMotorOne,
			rightMotorTwo;
	int autoLoopCounter;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
//        chooser = new SendableChooser();
//        chooser.addDefault("Default Auto", defaultAuto);
//        chooser.addObject("My Auto", customAuto);
//        SmartDashboard.putData("Auto choices", chooser);
    	
    	// Initialize the motors
    	leftMotorOne = new Jaguar(1);
		leftMotorTwo = new Jaguar(3);
		rightMotorOne = new Victor(0);
		rightMotorTwo = new Victor(2);
    	
    	// Invert the motors
    	leftMotorOne.setInverted(true);
    	leftMotorTwo.setInverted(true);
    	rightMotorOne.setInverted(true);
    	rightMotorTwo.setInverted(true);
    	
    	
    	myRobot = new RobotDrive(leftMotorOne,leftMotorTwo,rightMotorOne,rightMotorTwo);
    	
    	rightStick = new Joystick(1);
    	leftStick = new Joystick(0);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
//    	Provided Code
//    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto); // Keep this line commented
//		System.out.println("Auto selected: " + autoSelected);
    	
//    	Old code
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
//    	Provided Code
//    	switch(autoSelected) {
//    	case customAuto:
//        //Put custom auto code here   
//            break;
//    	case defaultAuto:
//    	default:
//    	//Put default auto code here
//            break;
//    	}
    	
//    	Old code that has worked before
    	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
			} else {
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	// Tank Drive
    	myRobot.tankDrive(leftStick, rightStick);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
