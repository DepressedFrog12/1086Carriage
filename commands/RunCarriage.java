package frc.robot.subsystems.carriage.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.carriage.Carriage;

public class RunCarriage extends Command {
    private Carriage carriage;
    private double percent;

    /**
     * Creates a new RunCarriage command.
     * It sets the percent output of the carriage and sets it back to 0 when the command is cancelled.
     * 
     * @param carriage The carriage subsystem to control.
     * @param percent The percent output to run at.
     */
    public RunCarriage(Carriage carriage, double percent) {
        this.carriage = carriage;
        this.percent = percent;

        addRequirements(carriage);
    }

    /**
     * Called when the command is initially scheduled.
     * 
     * It sets the speed of the carriage to the value passed through the constructor.
     */
    @Override
    public void initialize() {
        carriage.setPercent(percent);
    }

    /**
     * Called every time the scheduler runs while the command is scheduled.
     * 
     * Since the speed only needs to be set once, it doesn't do anything.
     */
    @Override
    public void execute() {}

    /**
     * Returns true when the command should end.
     * 
     * Since this command should run until it is cancelled, this function never returns true.
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * Called once the command ends or is interrupted.
     * 
     * No matter what, this sets the speed of the carriage to zero.
     */
    @Override
    public void end(boolean interrupted) {
        carriage.setPercent(0);
    }
}