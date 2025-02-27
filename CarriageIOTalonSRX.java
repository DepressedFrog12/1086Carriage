package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.reduxrobotics.sensors.canandcolor.Canandcolor;

public class CarriageIOTalonSRX implements CarriageIO {
    private TalonSRX carriage;
    private Canandcolor sensor;

    public CarriageIOTalonSRX(int motorId, int sensorId) {
        carriage = new TalonSRX(motorId);
        sensor = new Canandcolor(sensorId);

        carriage.configFactoryDefault();
        carriage.setInverted(true);
    }

    @Override
    public void processInputs(CarriageIOInputs inputs) {
        inputs.carriagePercent = carriage.getMotorOutputPercent();
        inputs.carriageVoltage = Volts.of(carriage.getMotorOutputVoltage());
        inputs.carriageCurrent = Amps.of(carriage.getStatorCurrent());
        inputs.carriageTemperature = Celsius.of(carriage.getTemperature());

        inputs.sensorProximity = sensor.getProximity();
        inputs.sensorColor = sensor.getColor();
    }

    @Override
    public void setCarriagePercent(double percent) {
        carriage.set(ControlMode.PercentOutput, percent);
    }
}