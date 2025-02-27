package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class CarriageIOSim implements CarriageIO {
	private DCMotorSim carriageMotorSim;

	public CarriageIOSim() {
		carriageMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 0.02, 1), DCMotor.getNEO(1));
	}

	@Override
	public void processInputs(CarriageIOInputs inputs) {
		carriageMotorSim.update(0.02);

		inputs.carriagePercent = carriageMotorSim.getAngularVelocityRadPerSec() / DCMotor.getNEO(1).freeSpeedRadPerSec;
		inputs.carriageVoltage = Volts.of(carriageMotorSim.getInputVoltage());
		inputs.carriageCurrent = Amps.of(carriageMotorSim.getCurrentDrawAmps());
	}

	@Override
	public void setCarriagePercent(double percent) {
		carriageMotorSim.setInputVoltage(percent * RobotController.getInputVoltage());
	}

	@Override
	public double getProximity() {
		return 0;
	}
}