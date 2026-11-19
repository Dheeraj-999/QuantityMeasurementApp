# QuantityMeasurementApp
## UC6: Addition of Length Measurements

**What I implemented:**
- Added functionality to add two length measurements.
- Supported addition between the same and different units.
- Added support for Feet, Inches, Yards and Centimeters.
- The result is returned in the first measurement's unit by default.
- Added an overloaded method to specify the result unit.
- Added validation for null values and invalid numeric inputs.
- Preserved the original measurements without modifying them.

**What it is used for:**
- Adds two length measurements accurately, even when they use different units.
- Example: 1 Foot + 12 Inches = 2 Feet.
- Example: 12 Inches + 1 Foot = 24 Inches.

**Testing:**
- Added 14 test cases covering same-unit addition, cross-unit addition, commutativity, zero, negative values, large and small values, null operands and explicit target units.
- All 77 project tests passed successfully.