
### UC8: Unit Enum Refactoring

**What I did:**
- Kept LengthUnit as a separate enum.
- Added methods to convert measurements into feet (base unit).
- Added methods to convert feet into other supported units.
- Moved conversion responsibility into LengthUnit.
- Simplified QuantityLength by delegating conversion calculations.
- Preserved all previous use case functionality.

**What it is used for:**

Keeps unit conversion logic in one place, making the application easier to maintain and extend.

**Supported Units:**
- Feet
- Inches
- Yards
- Centimeters

**Testing:**
- Added 18 UC8 test cases.
- All 109 project tests passed successfully.
