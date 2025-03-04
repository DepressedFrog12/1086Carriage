package frc.robot.subsystems.carriage.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.carriage.Carriage;

public class RunCarriage extends Command {
    private Carriage carriage;
    private double percent;

    /** Creates a new RunCarriage. */
    public RunCarriage(Carriage carriage, double percent) {
        this.carriage = carriage;
        this.percent = percent;

        addRequirements(carriage);
    }

    /** Called when the command is initially scheduled. */
    @Override
    public void initialize() {}

    /** Called every time the scheduler runs while the command is scheduled. */
    @Override
    public void execute() {
        carriage.setPercent(percent);
    }

    /** Returns true when the command should end. */
    @Override
    public boolean isFinished() {
        return false;
    }

    /** Called once the command ends or is interrupted. */
    @Override
    public void end(boolean interrupted) {
        carriage.setPercent(0);
    }
}
