
package com.quantitymeasurement;

// Generic class representing any length measurement
public class QuantityLength {

    // Stores the measurement value
    private final double value;

    // Stores the measurement unit
    private final LengthUnit unit;

    // Constructor to initialize value and unit
    public QuantityLength(double value, LengthUnit unit) {

        // Validate that the unit is not null
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // Converts the measurement into the common base unit (feet)
    private double convertToFeet() {
        return value * unit.getConversionFactor();
    }

    // Compares two QuantityLength objects
    @Override
    public boolean equals(Object obj) {

        // Check whether both references point to the same object
        if (this == obj) {
            return true;
        }

        // Check for null or different object types
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Convert Object into QuantityLength
        QuantityLength other = (QuantityLength) obj;

        // Compare both measurements after converting to feet
        return Double.compare(
                this.convertToFeet(),
                other.convertToFeet()
        ) == 0;
    }

    // Generate hash code using the converted measurement
    @Override
    public int hashCode() {
        return Double.hashCode(convertToFeet());
    }

    // Getter for measurement value
    public double getValue() {
        return value;
    }

    // Getter for measurement unit
    public LengthUnit getUnit() {
        return unit;
    }
}
