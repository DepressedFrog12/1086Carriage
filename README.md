# 1086 StringRay Carriage Subsystem

This is a carriage subsystem coded for StringRay, the 2025 Reefscape robot from FRC team 1086 Blue Cheese.

This has AdvantageKit logging, and is functional with designs that has 1 talonSRX motor that needs to be spun at a set rate, with 2 buttons for forward and backwards.

To make this subsystem function properly,

1. Create a `public static final CarriageConstants` class in your Constants.java (or separately if you so wish). Update the import in the CarriageIOTalonSRX.java, and change the initialization of the TalonSRX motor at line 10.
2. Create a `public static final int` variable named `CARRIAGE_MOTOR_ID` and set it equal to the ID of your TalonSRX motor. Create another `public static final double` variable named `maxPercent` and set it to the desired speed of the motor in terms of the percentage of the maximum RPM of a given motor. Should be between 0 and 1, exclusive. 
3. In your RobotContainer.java file, create a new CarriageSubystem with arguments: CarriageIOSim if the mode is sim, or CarriageIOSparkMax if the mode is real. Import as necessary
4. In your RobotContainer.java file's `configureBindings()` method, write lines similar to:
```
    driverController.b().whileTrue(new RunIntake(CarriageConstants.maxPercent));
    driverController.y().whileTrue(new RunOuttake(CarriageConstants.maxPercent));
```
with `driverController` replaced with your controller variable, and `.b()` or `.y()` replaced with your choice of bindings. Import `CarriageConstants` when required.
