// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants;
import frc.robot.subsystems.Carriage.CarriageIO;
import frc.robot.subsystems.Carriage.CarriageIOInputsAutoLogged;

/** Add your docs here. */
public class CarriageIOSparkMax implements CarriageIO{
    private final SparkMax carriage = new SparkMax(Constants.CarriageConstants.CARRIAGE_MOTOR_ID, SparkMax.MotorType.kBrushless);
    private final SparkClosedLoopController controller = carriage.getClosedLoopController();

    public CarriageIOSparkMax() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(true);
        config.idleMode(IdleMode.kBrake);

        carriage.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }
    @Override
    public void processInputs(CarriageIOInputsAutoLogged inputs) {
        inputs.carriageRPM = carriage.getEncoder().getVelocity();
        inputs.carriageAmps = carriage.getOutputCurrent();
        inputs.carriagesVolts = carriage.getAppliedOutput() * carriage.getBusVoltage();
        inputs.carriageTemp = carriage.getMotorTemperature();
    }

    @Override
    public void setCarriageVolts(double volts) {
        carriage.setVoltage(MathUtil.clamp(volts, -12.0, 12.0));
    }

    @Override
    public void setCarriageRPM(double rPM) {
        carriage.set(rPM);
    }

    @Override
    public void settoZero() {
        carriage.set(0);
    }

    @Override
    public void setCarriagePID(double kP, double kI, double kD) {
        
    }

}
