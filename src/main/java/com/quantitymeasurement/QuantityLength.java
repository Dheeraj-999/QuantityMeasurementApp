
package com.quantitymeasurement;

/**
 * Generic class representing length measurements.
 * Supports equality checking and conversion between units.
 */
public class QuantityLength {

    // Stores the measurement value
    private final double value;

    // Stores the measurement unit
    private final LengthUnit unit;

    // Constructor to initialize value and unit
    public QuantityLength(double value, LengthUnit unit) {

        // Validate that the value is finite
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Measurement value must be finite");
        }

        // Validate that the unit is not null
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    /**
     * Converts a measurement from one unit to another.
     *
     * @param value measurement value
     * @param source source unit
     * @param target target unit
     * @return converted measurement value
     * @throws IllegalArgumentException if input is invalid
     */
    public static double convert(
            double value, LengthUnit source, LengthUnit target) {

        // Validate measurement value
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Measurement value must be finite");
        }

        // Validate source and target units
        if (source == null || target == null) {
            throw new IllegalArgumentException(
                    "Source and target units cannot be null");
        }

        // Convert the value into the common base unit (feet)
        double valueInFeet = value * source.getConversionFactor();

        // Convert from feet into the target unit
        double convertedValue =
                valueInFeet / target.getConversionFactor();

        // Validate the converted result
        if (!Double.isFinite(convertedValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return convertedValue;
    }

    /**
     * Converts the current measurement into another unit.
     * Returns a new QuantityLength object.
     *
     * @param target target unit
     * @return new converted QuantityLength object
     */
    public QuantityLength convertTo(LengthUnit target) {

        double convertedValue = convert(value, unit, target);

        return new QuantityLength(convertedValue, target);
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

    // Returns a readable representation of the measurement
    @Override
    public String toString() {
        return "QuantityLength{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
