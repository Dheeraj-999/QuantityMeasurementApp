## UC10 – Generic Quantity Class

### What I did
- Created a common `IMeasurable` interface for measurement units.
- Updated `LengthUnit` and `WeightUnit` to implement the interface.
- Created a generic `Quantity<U>` class to handle different measurement categories.
- Implemented generic equality, conversion, and addition.
- Refactored `QuantityLength` and `QuantityWeight` to use the generic class.
- Updated the application to demonstrate length and weight measurements using generics.
- Added 15 test cases for the generic quantity class.

### What it is used for
The generic quantity class avoids repeating the same measurement logic for different categories. It supports length and weight measurements through one reusable implementation.

### Testing
- Previous UC1–UC9 tests: 144
- New UC10 tests: 15
- Total: 159 tests
  144 project tests passed successfully**.