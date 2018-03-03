package org.usfirst.frc.team1797.robot.auto;

import org.usfirst.frc.team1797.robot.commands.FlipCommand;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.AutoDeliverBoxLToL;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.AutoDeliverBoxLToR;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.DelayCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAutoDeliverBox extends CommandGroup {

    public LeftAutoDeliverBox() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

    	addSequential(new DelayCommand(0));
    	
    	char ch = DriverStation.getInstance().getGameSpecificMessage().toLowerCase().charAt(0);
    	if(ch == 'l') {
    		addSequential(new AutoDeliverBoxLToL());
    	} else {
    		addSequential(new AutoDeliverBoxLToR());
    	}
    	// addSequential(new FlipCommand());
    }
}