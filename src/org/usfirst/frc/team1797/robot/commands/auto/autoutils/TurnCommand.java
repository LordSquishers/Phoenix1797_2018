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
        this.turnDirection = d;
        this.turnRate = turnRate;
        this.turnAngle = d == Direction.LEFT ? -turnAngle : turnAngle;
        this.gyro.reset();
        this.gyro.resetDisplacement();
        this.gyro = RobotMap.gyro;
        
        this.targetAngle = gyro.getAngle() + this.turnAngle;
        
        if(targetAngle >= 360) {
        		targetAngle -= 360;
        }
        
    		requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(turnDirection == Direction.RIGHT) {
    			Robot.DRIVE_TRAIN.tankDrive(turnRate, -turnRate);
    		} else {
    			Robot.DRIVE_TRAIN.tankDrive(-turnRate, turnRate);
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(turnDirection == Direction.RIGHT) {
        		return gyro.getAngle() >= targetAngle;
        } else {
        		return gyro.getAngle() <= targetAngle;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.DRIVE_TRAIN.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
