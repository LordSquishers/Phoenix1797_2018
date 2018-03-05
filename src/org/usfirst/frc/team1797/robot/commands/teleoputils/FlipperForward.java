package org.usfirst.frc.team1797.robot.commands.teleoputils;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlipperForward extends Command {

	private long lastCall;
	
	public FlipperForward() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		lastCall = Long.MAX_VALUE;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		lastCall = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.FLIPPER.set(1.0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.FLIPPER.isForward() || (System.currentTimeMillis() - lastCall > 10000);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.FLIPPER.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
