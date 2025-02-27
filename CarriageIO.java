package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import org.littletonrobotics.junction.AutoLog;

import com.reduxrobotics.sensors.canandcolor.ColorData;

public interface CarriageIO {
    @AutoLog
    public class CarriageIOInputs {
        public double carriagePercent = 0;
        public Voltage carriageVoltage = Volts.zero();
        public Current carriageCurrent = Amps.zero();
        public Temperature carriageTemperature = Celsius.zero();

        public double sensorProximity = 0;
        public ColorData sensorColor = new ColorData(0,0,0);
    }

    public void processInputs(final CarriageIOInputs inputs);

    public void setCarriagePercent(double maxPercent);

    public double getProximity();
}