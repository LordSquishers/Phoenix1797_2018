package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 */

public class AutoDeliverBoxMToL extends CommandGroup {
    public AutoDeliverBoxMToL() {
    		// Here, the robot begins backwards and moves ~70 units backwards.
    		addSequential(new MoveStraight(0.7, 70));
    		// Turn right at an angle measure of approximately 90 degrees.
    		addSequential(new TurnCommand(Direction.LEFT, 0.5, 90));
    		// Move ~81 units forward after this.
    		addSequential(new MoveStraight(0.7, 81));
    		// Move right again, so then we can move backwards and hit the switch.
    		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
    		// Move backwards ~70 units.
    		addSequential(new MoveStraight(0.7, 70));
    }
}