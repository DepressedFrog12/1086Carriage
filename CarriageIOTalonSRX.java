package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.reduxrobotics.sensors.canandcolor.Canandcolor;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.Constants.RobotMap;

public class CarriageIOTalonSRX implements CarriageIO {
    private final TalonSRX carriage = new TalonSRX(RobotMap.CARRIAGE_MOTOR_ID);
    private final Canandcolor sensor = new Canandcolor(RobotMap.CARRIAGE_CANANDCOLOR_ID);

    public CarriageIOTalonSRX() {
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
    public void setCarriagePercent(double maxPercent) {
        carriage.set(ControlMode.PercentOutput, MathUtil.clamp(maxPercent / RobotController.getInputVoltage(), -1, 1));
    }
    
    @Override
    public double getProximity() {
        return sensor.getProximity();
    }
}