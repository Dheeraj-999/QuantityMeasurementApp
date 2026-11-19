
package com.quantitymeasurement;

/**
 * Generic class representing length measurements.
 * Supports equality checking, conversion and addition.
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
     */
    public static double convert(
            double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Measurement value must be finite");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException(
                    "Source and target units cannot be null");
        }

        // Convert the value into the common base unit (feet)
        double valueInFeet = value * source.getConversionFactor();

        // Convert from feet into the target unit
        double convertedValue =
                valueInFeet / target.getConversionFactor();

        if (!Double.isFinite(convertedValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return convertedValue;
    }

    /**
     * Converts the current measurement into another unit.
     * Returns a new QuantityLength object.
     */
    public QuantityLength convertTo(LengthUnit target) {

        double convertedValue = convert(value, unit, target);

        return new QuantityLength(convertedValue, target);
    }

    /**
     * UC6: Adds two QuantityLength objects.
     * The result is expressed in the first operand's unit.
     *
     * @param first first length measurement
     * @param second second length measurement
     * @return new QuantityLength object containing the sum
     */
    public static QuantityLength add(
            QuantityLength first, QuantityLength second) {

        // Validate both operands
        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Length measurements cannot be null");
        }

        // Convert both measurements into feet
        double firstInFeet = first.convertToFeet();
        double secondInFeet = second.convertToFeet();

        // Add both measurements
        double sumInFeet = firstInFeet + secondInFeet;

        // Validate addition result
        if (!Double.isFinite(sumInFeet)) {
            throw new IllegalArgumentException(
                    "Addition result is outside the supported range");
        }

        // Convert the result into the first operand's unit
        double result = convert(
                sumInFeet, LengthUnit.FEET, first.unit);

        // Return a new immutable object
        return new QuantityLength(result, first.unit);
    }

    /**
     * UC6: Adds two raw length measurements.
     * The result is expressed in the specified target unit.
     *
     * @param value1 first measurement value
     * @param unit1 first measurement unit
     * @param value2 second measurement value
     * @param unit2 second measurement unit
     * @param targetUnit unit of the result
     * @return new QuantityLength object containing the sum
     */
    public static QuantityLength add(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2,
            LengthUnit targetUnit) {

        // Validate input values
        if (!Double.isFinite(value1) || !Double.isFinite(value2)) {
            throw new IllegalArgumentException(
                    "Measurement values must be finite");
        }

        // Validate all units
        if (unit1 == null || unit2 == null || targetUnit == null) {
            throw new IllegalArgumentException(
                    "Units cannot be null");
        }

        // Convert both measurements into feet
        double firstInFeet = value1 * unit1.getConversionFactor();
        double secondInFeet = value2 * unit2.getConversionFactor();

        // Add both measurements
        double sumInFeet = firstInFeet + secondInFeet;

        if (!Double.isFinite(sumInFeet)) {
            throw new IllegalArgumentException(
                    "Addition result is outside the supported range");
        }

        // Convert the sum into the requested target unit
        double result = convert(
                sumInFeet, LengthUnit.FEET, targetUnit);

        return new QuantityLength(result, targetUnit);
    }

    // Converts the measurement into the common base unit (feet)
    private double convertToFeet() {
        return value * unit.getConversionFactor();
    }

    // Compares two QuantityLength objects
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        QuantityLength other = (QuantityLength) obj;

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
