# 1086 StringRay Carriage Subsystem

This is a carriage subsystem coded for StringRay, the 2025 Reefscape robot from FRC team 1086 Blue Cheese.

This has AdvantageKit logging, and is functional with designs that has 1 talonSRX motor that needs to be spun at a set rate, with 2 buttons for forward and backwards.

To make this subsystem function properly,

1. In your RobotContainer.java file, create a new Carriage object with arguments: CarriageIOSim if the mode is sim, and your preferred implementation otherwise.  An example statement is defined below.
```
    if (RobotBase.isSimulation()) {
      new Carriage(new CarriageIOSim());
    } else {
      new Carriage(new CarriageIOTalonSRX(motorId, sensorId));
    }
```
2. Pass in the correct CAN ids to the constructors.
3. In your RobotContainer.java file's `configureBindings()` method, bind buttons to the RunCarriage command like so:
```
    driverController.b().whileTrue(new RunCarriage(speed));
    driverController.y().whileTrue(new RunCarriage(-speed));
```
with `driverController` replaced with your controller variable, `speed` replaced with a double from 0-1, and `.b()` or `.y()` replaced with your choice of bindings.
