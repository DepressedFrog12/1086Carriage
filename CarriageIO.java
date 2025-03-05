package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import org.littletonrobotics.junction.AutoLog;

public interface CarriageIO {
    @AutoLog
    public class CarriageIOInputs {
        public double carriagePercent = 0;
        public Voltage carriageVoltage = Volts.zero();
        public Current carriageCurrent = Amps.zero();
        public Temperature carriageTemperature = Celsius.zero();

        public double sensorProximity = 0;
        public String sensorColor = "";
    }

    /**
     * Updates the inputs parameter with current values.
     * 
     * @param inputs The inputs to update.
     */
    public void updateInputs(CarriageIOInputs inputs);

    /** Sets the percent output of the carriage. */
    public void setPercent(double percent);
}