// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.carriage;

import static edu.wpi.first.units.Units.*;

import com.reduxrobotics.sensors.canandcolor.Canandcolor;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import frc.robot.Constants.RobotMap;

/** Add your docs here. */
public class CarriageIOSparkMax implements CarriageIO {
    private final SparkMax carriage = new SparkMax(RobotMap.CARRIAGE_MOTOR_ID, SparkMax.MotorType.kBrushless);
    private final Canandcolor sensor = new Canandcolor(RobotMap.CARRIAGE_CANANDCOLOR_ID);

    public CarriageIOSparkMax() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(true);
        config.idleMode(IdleMode.kBrake);

        carriage.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void processInputs(CarriageIOInputs inputs) {
        inputs.carriagePercent = carriage.getAppliedOutput();
        inputs.carriageVoltage = Volts.of(carriage.getAppliedOutput() * carriage.getBusVoltage());
        inputs.carriageCurrent = Amps.of(carriage.getOutputCurrent());
        inputs.carriageTemperature = Celsius.of(carriage.getMotorTemperature());

        inputs.sensorProximity = sensor.getProximity();
        inputs.sensorColor = sensor.getColor();
    }

    @Override
    public void setCarriagePercent(double percent) {
        carriage.set(percent);
    }
}