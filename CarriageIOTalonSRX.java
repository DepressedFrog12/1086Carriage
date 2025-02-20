package frc.robot.subsystems.Carriage;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.Constants;

public class CarriageIOTalonSRX implements CarriageIO {
    private final TalonSRX carriage = new TalonSRX(Constants.CarriageConstants.CARRIAGE_MOTOR_ID);

    public CarriageIOTalonSRX() {
        carriage.configFactoryDefault();

        carriage.setInverted(true);
    }

    @Override
    public void processInputs(CarriageIOInputsAutoLogged inputs) {

        inputs.carriageRPM = carriage.getSelectedSensorVelocity();
        inputs.carriagesVolts = carriage.getMotorOutputVoltage();
        inputs.carriageAmps = carriage.getSupplyCurrent();
        inputs.carriageTemp = carriage.getTemperature();

    }

    @Override
    public void setCarriageRPM(double maxPercent) {
        carriage.set(ControlMode.PercentOutput, MathUtil.clamp(maxPercent / RobotController.getInputVoltage(), -1, 1));
    }

    @Override
    public void setToZero() {
        carriage.set(ControlMode.PercentOutput, 0);
    }

}
