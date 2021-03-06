package org.usfirst.frc.team1797.robot;

import java.util.HashMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// delay method
	private static final double DELAY_SECONDS = 0.0;

	public static void delay() {
		long startTime = System.currentTimeMillis();
		while (DELAY_SECONDS * 1000 + startTime >= System.currentTimeMillis()) {
		}
	}

	// Robot controls
	public static final int DRIVER_FORWARD_AXIS = 1;
	public static final int DRIVER_HORIZONTAL_AXIS = 4;

	public static final int DRIVER_CONTROLLER_PORT = 0;
	public static final int OPERATOR_CONTROLLER_PORT = 1;

	// Physical multiplier of motors
	public static final double DRIVETRAIN_SENSITIVITY = 1;
	public static final double INTAKE_MOTOR_SPEED = 1;

	// Distance between left and right wheels
	public static final double ROBOT_BASE_WIDTH = 0.63;
	public static final double ROBOT_WHEEL_WIDTH = 0.15;
	private static final double ROBOT_WHEEL_CIRCUMFERENCE = Math.PI * 6;
	private static final int ROBOT_ENCODER_PULSES = 256;
	public static final double ROBOT_ENCODER_DPP = ROBOT_WHEEL_CIRCUMFERENCE / ROBOT_ENCODER_PULSES;

	// Gyro
	// Test aonboard, all the different ports
	// I need to switch this to I2C. This was hell to figure out so contact Arman if
	// u want to change this.
	// AHRS docs on kuwawi labs site or something
	public static final AHRS gyro = new AHRS(I2C.Port.kMXP);

	// Add hardware ports here with an id and port number.
	// Ex. ROBOT_HARDWARE_PORTS.put(<port id>, port number);
	private static HashMap<String, Integer> ROBOT_HARDWARE_PORTS = new HashMap<>();
	static {

// MOTORS:
		// Drivetrain Motors
		ROBOT_HARDWARE_PORTS.put("left_motor_1", 0); // 0
		ROBOT_HARDWARE_PORTS.put("left_motor_2", 1); // 1
		ROBOT_HARDWARE_PORTS.put("right_motor_1", 3); // 2
		ROBOT_HARDWARE_PORTS.put("right_motor_2", 4); // 3

		// Intake Motors
		ROBOT_HARDWARE_PORTS.put("intake_motor_1", 5); // 4
		ROBOT_HARDWARE_PORTS.put("intake_motor_2", 6); // 5

		// Flipper Motor
		ROBOT_HARDWARE_PORTS.put("flipper_motor", 7); // 6

// PISTONS:
		// intake deploy pistons
		ROBOT_HARDWARE_PORTS.put("intake_deploy_piston_1", 0);
		ROBOT_HARDWARE_PORTS.put("intake_deploy_piston_2", 1);

// SENSORS:
		// Encoders
		ROBOT_HARDWARE_PORTS.put("left_encoder_1", 0);
		ROBOT_HARDWARE_PORTS.put("left_encoder_2", 1);
		ROBOT_HARDWARE_PORTS.put("right_encoder_1", 2);
		ROBOT_HARDWARE_PORTS.put("right_encoder_2", 3);

		// LIMIT SWITCHES
		ROBOT_HARDWARE_PORTS.put("flipper_switch_back", 4);
		ROBOT_HARDWARE_PORTS.put("flipper_switch_front", 5);

	}

	public static int getPort(String id) {
		return ROBOT_HARDWARE_PORTS.get(id);
	}

}
