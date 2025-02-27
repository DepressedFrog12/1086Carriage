// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.carriage;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Carriage extends SubsystemBase {
    private CarriageIO io;
    private CarriageIOInputsAutoLogged inputs = new CarriageIOInputsAutoLogged();

    private static Carriage instance;

    public static Carriage getInstance() {
        if (instance == null) {
            instance = new Carriage(new CarriageIOSim());
        }

        return instance;
    }

    /** Creates a new CarriageSubsystem. */
    public Carriage(CarriageIO carriageIO) {
        io = carriageIO;
        instance = this;
    }

    public void setPercent(double maxPercent) {
        io.setCarriagePercent(maxPercent);
    }

    @Override
    public void periodic() {
        io.processInputs(inputs);

        Logger.processInputs("/RealOutputs/Subsystems/Carriage", inputs);
    }
}