
## UC11 – Volume Measurement

### What I did
- Created a new `VolumeUnit` enum implementing the `IMeasurable` interface.
- Added three volume units: Litre, Millilitre, and Gallon.
- Used Litre as the base unit for volume conversion.
- Implemented conversion between different volume units.
- Used the generic `Quantity<VolumeUnit>` class for equality, conversion, and addition.
- Added 28 test cases covering volume measurements and validations.

### What it is used for
This use case extends the application to support volume measurements. Users can compare, convert, and add quantities expressed in litres, millilitres, and gallons using the existing generic measurement system.

### Testing
- Previous UC1–UC10 tests: 159
- New UC11 tests: 28
- Total: 187 tests passed
