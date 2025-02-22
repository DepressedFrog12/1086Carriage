// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.carriage;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import frc.robot.Constants;

/** Add your docs here. */
public class CarriageIOSparkMax implements CarriageIO {
    private final SparkMax carriage = new SparkMax(Constants.CarriageConstants.CARRIAGE_MOTOR_ID,
            SparkMax.MotorType.kBrushless);

    public CarriageIOSparkMax() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(true);
        config.idleMode(IdleMode.kBrake);

        carriage.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void processInputs(CarriageIOInputs inputs) {
        inputs.carriageRPM = carriage.getEncoder().getVelocity();
        inputs.carriageTemp = carriage.getMotorTemperature();
    }

    @Override
    public void setCarriagePercent(double maxPercent) {
        carriage.set(maxPercent);
    }

    @Override
    public void setToZero() {
        carriage.set(0);
    }

}
