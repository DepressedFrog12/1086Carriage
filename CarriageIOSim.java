package frc.robot.subsystems.carriage;

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
	public void processInputs(CarriageIOInputs inputs) {
		carriageMotorSim.update(0.02);

		inputs.carriageRPM = carriageMotorSim.getAngularVelocityRPM();
	}

	@Override
	public void setCarriagePercent(double maxPercent) {
		System.out.println(maxPercent);
		carriageMotorSim.setAngularVelocity(Units.rotationsPerMinuteToRadiansPerSecond(maxPercent));
	}

	@Override
	public void setToZero() {
		carriageMotorSim.setInput(0);
	}
}
