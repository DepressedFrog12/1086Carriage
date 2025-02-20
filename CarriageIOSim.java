package frc.robot.subsystems.Carriage;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class CarriageIOSim implements CarriageIO {
	private DCMotorSim carriageMotorSim;

	public CarriageIOSim() {
		carriageMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(0.02, 0.02), DCMotor.getNEO(1));

	}

	@Override
	public void processInputs(CarriageIOInputsAutoLogged inputs) {
		carriageMotorSim.update(0.02);

		inputs.carriageRPM = carriageMotorSim.getAngularVelocityRPM();
		inputs.carriagesVolts = carriageMotorSim.getInputVoltage();
	}

	@Override
	public void setCarriageRPM(double rpm) {
		System.out.println(rpm);
		carriageMotorSim.setAngularVelocity(Units.rotationsPerMinuteToRadiansPerSecond(rpm));
	}

	@Override
	public void setToZero() {
		carriageMotorSim.setInput(0);
	}
}
