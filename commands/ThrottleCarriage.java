package frc.robot.subsystems.carriage.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.carriage.Carriage;

public class ThrottleCarriage extends Command {
    private Carriage carriage;
    private Supplier<Double> percentSupplier;

    /**
     * Creates a new TrottleCarriage command.
     * It sets the percent output of the carriage and sets it back to 0 when the command is cancelled.
     * 
     * @param carriage The carriage subsystem to control.
     * @param percentSupplier The supplier of percent output to run at.
     */
    public ThrottleCarriage(Carriage carriage, Supplier<Double> percentSupplier) {
        this.carriage = carriage;
        this.percentSupplier = percentSupplier;

        addRequirements(carriage);
    }

    /** Called when the command is initially scheduled. */
    @Override
    public void initialize() {}

    /**
     * Called every time the scheduler runs while the command is scheduled.
     * 
     * It sets the percent output of the carriage to the value recieved from the supplier.
     */
    @Override
    public void execute() {
        carriage.setPercent(percentSupplier.get());
    }

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