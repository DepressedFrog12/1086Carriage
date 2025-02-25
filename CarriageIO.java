package frc.robot.subsystems.carriage;

import org.littletonrobotics.junction.AutoLog;

public interface CarriageIO {

    @AutoLog
    public class CarriageIOInputs {
        public double carriageRPM = 0.0;
        public double carriageTemp = 0.0;
    }

    public void processInputs(final CarriageIOInputs inputs);

    public void setCarriagePercent(double maxPercent);

    public double getProximity();
}