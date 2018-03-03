package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 */

public class AutoDeliverBoxLToL extends CommandGroup {
    public AutoDeliverBoxLToL() {
    		// Move forward ~168 units.
    		addSequential(new MoveStraight(0.7, 168));
    		// Turn left at an angle of 90 degrees.
    		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
    		// Move backwards ~85.25 (also try 15.625) units, to hit the fence and back into the wall.
    		addSequential(new MoveStraight(0.7, 18.625));
    }
}