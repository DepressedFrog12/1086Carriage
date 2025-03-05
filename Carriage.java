package frc.robot.subsystems.carriage;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Carriage extends SubsystemBase {
    private CarriageIO io;
    private CarriageIOInputsAutoLogged inputs = new CarriageIOInputsAutoLogged();

    /**
     * Creates a new Carriage subsystem.
     * 
     * @param carriageIO The carriageIO to control.
     */
    public Carriage(CarriageIO carriageIO) {
        io = carriageIO;
    }

    /** Sets the percent output of the carriage. */
    public void setPercent(double percent) {
        io.setPercent(percent);
    }

    /**
     * Runs once every tick the subsystem is active.
     * 
     * It updates the inputs variable and logs it through AdvantageKit.
     */
    @Override
    public void periodic() {
        io.updateInputs(inputs);

        Logger.processInputs("/RealOutputs/Subsystems/Carriage", inputs);
    }
}