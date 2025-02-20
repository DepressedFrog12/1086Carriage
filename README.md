# 1086 StringRay Carriage Subsystem

This is a carriage subsystem coded for StringRay, the 2025 Reefscape robot from FRC team 1086 Blue Cheese.

This has AdvantageKit logging, and is functional with designs that have 1 TalonSRX or SparkMax motor that needs to be spun at a set rate, with 2 buttons for forward and backwards.

To make this subsystem function properly,

1. Create a `public static final CarriageConstants` class in your Constants.java (or separately if you so wish). Update the import in the CarriageIOTalonSRX.java and CarriageIOSparkMax.java, and change the initialization of the motor at line 11 and 15 respectively for the files.
2. Create a `public static final int` variable named `CARRIAGE_MOTOR_ID` and set it equal to the ID of your motor. Create another `public static final double` variable named `maxPercent` and set it to the desired speed of the motor in terms of the percentage of the maximum RPM of a given motor. Should be between 0 and 1, exclusive.
3. Add the following lines to your CarriageConstants file:
```
    public static enum Motor {SPARKMAX, TALONSRX};
    public static Motor motor = Motor.SPARKMAX;
```
This will create an enum for configuring between motors. When using a SparkMax, ensure the bottom line says `Motor.SPARKMAX`. When using a TalonSRX, ensure the line says `Motor.TALONSRX`
4. In your RobotContainer.java file, create a new CarriageSubystem with arguments: CarriageIOSim if the mode is sim, or either CarriageIOTalonSRX or CarriageIOSparkMax. An example statement is defined below. Import as necessary.
```
    if (RobotBase.isSimulation()) {
      new CarriageSubsystem(new CarriageIOSim());
    } else if (Constants.CarriageConstants.motor == Constants.CarriageConstants.Motor.SPARKMAX) {
      new CarriageSubsystem(new CarriageIOSparkMax());
    } else {
      new CarriageSubsystem(new CarriageIOTalonSRX());
    }
```
5. In your RobotContainer.java file's `configureBindings()` method, write lines similar to:
```
    driverController.b().whileTrue(new RunCarriage(true, CarriageConstants.maxPercent));
    driverController.y().whileTrue(new RunCarriage(false, CarriageConstants.maxPercent));
```
with `driverController` replaced with your controller variable, and `.b()` or `.y()` replaced with your choice of bindings. Change true and false for whichever direction it needs to go. This can be configured for both directions as shown. Import `CarriageConstants` when required.
