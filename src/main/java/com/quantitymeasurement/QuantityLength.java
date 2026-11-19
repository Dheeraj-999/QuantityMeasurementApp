
package com.quantitymeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    // Constructor
    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Measurement value must be finite");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // UC5: Convert a value from one unit to another
    public static double convert(
            double value,
            LengthUnit source,
            LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Measurement value must be finite");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException(
                    "Source and target units cannot be null");
        }

        // Convert source value into feet
        double valueInFeet = value * source.getConversionFactor();

        // Convert feet into target unit
        double convertedValue =
                valueInFeet / target.getConversionFactor();

        if (!Double.isFinite(convertedValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return convertedValue;
    }

    // UC5: Instance method for conversion
    public QuantityLength convertTo(LengthUnit target) {

        double convertedValue = convert(value, unit, target);

        return new QuantityLength(convertedValue, target);
    }

    // UC6: Addition with result in the first operand's unit
    public static QuantityLength add(
            QuantityLength first,
            QuantityLength second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Length measurements cannot be null");
        }

        // Default result unit is the first operand's unit
        return add(first, second, first.unit);
    }

    // UC7: Addition with explicitly specified target unit
    public static QuantityLength add(
            QuantityLength first,
            QuantityLength second,
            LengthUnit targetUnit) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Length measurements cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        // Reuse the existing addition method
        return add(
                first.value,
                first.unit,
                second.value,
                second.unit,
                targetUnit
        );
    }

    // UC6: Addition using raw values with a specified target unit
    public static QuantityLength add(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2,
            LengthUnit targetUnit) {

        if (!Double.isFinite(value1) || !Double.isFinite(value2)) {
            throw new IllegalArgumentException(
                    "Measurement values must be finite");
        }

        if (unit1 == null || unit2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        // Convert both values into feet
        double firstInFeet =
                value1 * unit1.getConversionFactor();

        double secondInFeet =
                value2 * unit2.getConversionFactor();

        // Add both measurements
        double sumInFeet = firstInFeet + secondInFeet;

        if (!Double.isFinite(sumInFeet)) {
            throw new IllegalArgumentException(
                    "Addition result is outside the supported range");
        }

        // Convert the result into the requested target unit
        double result = convert(
                sumInFeet,
                LengthUnit.FEET,
                targetUnit
        );

        return new QuantityLength(result, targetUnit);
    }

    // Convert the current measurement into feet
    private double convertToFeet() {
        return value * unit.getConversionFactor();
    }

    // Get measurement value
    public double getValue() {
        return value;
    }

    // Get measurement unit
    public LengthUnit getUnit() {
        return unit;
    }

    // Compare two measurements
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

    // Generate hash code
    @Override
    public int hashCode() {
        return Double.hashCode(convertToFeet());
    }

    // Display measurement
    @Override
    public String toString() {
        return "QuantityLength{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
