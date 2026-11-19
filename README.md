### UC9: Weight Measurement Equality, Conversion, and Addition

**What I did:**
- Added support for Kilograms, Grams, and Pounds.
- Created `WeightUnit` to handle weight conversions using Kilograms as the base unit.
- Created `QuantityWeight` to compare, convert, and add weight measurements.
- Supported addition with both default and explicitly selected result units.
- Kept weight measurements independent of length measurements.

**What it is used for:**

Users can compare, convert, and add weights in different units without affecting the existing length measurement functionality.

**Testing:**
- Added UC9 test cases.
- All **144 project tests passed successfully**.