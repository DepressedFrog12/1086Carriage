package frc.robot.subsystems.carriage;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Carriage extends SubsystemBase {
    private CarriageIO io;
    private CarriageIOInputsAutoLogged inputs = new CarriageIOInputsAutoLogged();

    /** Creates a new CarriageSubsystem. */
    public Carriage(CarriageIO carriageIO) {
        io = carriageIO;
    }

    public void setPercent(double percent) {
        io.setCarriagePercent(percent);
    }

    @Override
    public void periodic() {
        io.processInputs(inputs);

        Logger.processInputs("/RealOutputs/Subsystems/Carriage", inputs);
    }
}
