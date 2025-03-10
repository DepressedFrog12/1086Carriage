// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.carriage.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.carriage.Carriage;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class RunCarriage extends Command {
    private Carriage carriage;
    private double percent;

    /** Creates a new RunCarriage. */
    public RunCarriage(double percent) {
        carriage = Carriage.getInstance();
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