package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnCommand extends Command {

	private Direction turnDirection;
	private double turnRate;
	private double turnAngle;

	private AHRS gyro;
	private double targetAngle;

	public TurnCommand(Direction d, double turnRate, double turnAngle) {
		requires(Robot.DRIVETRAIN);
		this.turnDirection = d;
		this.turnRate = turnRate;
		this.turnAngle = (d == Direction.LEFT) ? -turnAngle + 5 : turnAngle - 10;
		this.targetAngle = this.turnAngle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// System.out.println("Init turn command.");
		this.gyro = RobotMap.gyro;
		this.gyro.reset();
		this.gyro.resetDisplacement();
		// System.out.println("Target Angle: " + targetAngle);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("Command: " + gyro.getAngle());

		if (turnDirection == Direction.RIGHT) {
			Robot.DRIVETRAIN.tankDrive(turnRate, -turnRate);
			// Robot.DRIVE_TRAIN.errorConnectionTurn(turnRate, -turnRate);
		} else {
			Robot.DRIVETRAIN.tankDrive(-turnRate, turnRate);
			// Robot.DRIVE_TRAIN.errorConnectionTurn(-turnRate, turnRate);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (turnDirection == Direction.RIGHT) {
			return gyro.getAngle() >= targetAngle;
		} else {
			return gyro.getAngle() <= targetAngle;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.DRIVETRAIN.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
