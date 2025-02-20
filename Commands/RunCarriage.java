// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Carriage.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Carriage.CarriageSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class RunCarriage extends Command {
  private CarriageSubsystem carriage;
  private double RPM;
  private boolean direction;

  /** Creates a new RunCarriage. */
  public RunCarriage(boolean direction, double RPM) {
    carriage = CarriageSubsystem.getInstance();
    this.RPM = RPM;
    this.direction = direction;
    addRequirements(carriage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (direction) {
      carriage.setRPM(RPM);
    } else {
      carriage.setRPM(-RPM);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    carriage.setToZero();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
