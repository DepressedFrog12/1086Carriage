package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.reduxrobotics.sensors.canandcolor.Canandcolor;

public class CarriageIOTalonSRX implements CarriageIO {
    private TalonSRX carriage;
    private Canandcolor sensor;

    /**
     * Creates a new carriage using TalonSRX motors.
     * 
     * @param motorId The CAN if of the TalonSRX motor driving the system.
     * @param sensorId The CAN id of the CANandColor sensor to read.
     */
    public CarriageIOTalonSRX(int motorId, int sensorId) {
        carriage = new TalonSRX(motorId);
        sensor = new Canandcolor(sensorId);

        carriage.configFactoryDefault();
        carriage.setInverted(true);
    }

    @Override
    public void updateInputs(CarriageIOInputs inputs) {
        inputs.carriagePercent = carriage.getMotorOutputPercent();
        inputs.carriageVoltage = Volts.of(carriage.getMotorOutputVoltage());
        inputs.carriageCurrent = Amps.of(carriage.getStatorCurrent());
        inputs.carriageTemperature = Celsius.of(carriage.getTemperature());

        inputs.sensorProximity = sensor.getProximity();
        inputs.sensorColor = String.format("#%x%x%x", (int) (sensor.getRed() * 255), (int) (sensor.getGreen() * 255), (int) (sensor.getBlue() * 255));
    }

    @Override
    public void setPercent(double percent) {
        carriage.set(ControlMode.PercentOutput, percent);
    }
}