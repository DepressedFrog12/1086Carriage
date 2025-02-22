package frc.robot.subsystems.carriage;

import org.littletonrobotics.junction.AutoLog;

public interface CarriageIO {

    @AutoLog
    public class CarriageIOInputs {
        public double carriageRPM = 0.0;
        public double carriageTemp = 0.0;

    }

    public abstract void processInputs(final CarriageIOInputs inputs);

    public abstract void setCarriagePercent(double maxPercent);

    public abstract void setToZero();
}
