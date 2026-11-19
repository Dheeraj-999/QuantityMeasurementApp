
package com.quantitymeasurement;

// Represents a weight measurement.
// Weight and length are separate measurement categories.
public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    // Constructor
    public QuantityWeight(double value, WeightUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Weight value must be finite");
        }

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Weight unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // UC9: Convert weight from one unit to another
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        // Convert current weight into kilograms
        double valueInKilograms = unit.convertToBaseUnit(value);

        // Convert kilograms into the target unit
        double convertedValue =
                targetUnit.convertFromBaseUnit(valueInKilograms);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // UC9: Addition with result in the first operand's unit
    public static QuantityWeight add(
            QuantityWeight first,
            QuantityWeight second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Weight measurements cannot be null");
        }

        return add(first, second, first.unit);
    }

    // UC9: Addition with an explicitly specified target unit
    public static QuantityWeight add(
            QuantityWeight first,
            QuantityWeight second,
            WeightUnit targetUnit) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Weight measurements cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        // Convert both weights into kilograms
        double firstInKilograms =
                first.unit.convertToBaseUnit(first.value);

        double secondInKilograms =
                second.unit.convertToBaseUnit(second.value);

        // Add both measurements
        double sumInKilograms =
                firstInKilograms + secondInKilograms;

        if (!Double.isFinite(sumInKilograms)) {
            throw new IllegalArgumentException(
                    "Addition result is outside the supported range");
        }

        // Convert the result into the requested target unit
        double result =
                targetUnit.convertFromBaseUnit(sumInKilograms);

        return new QuantityWeight(result, targetUnit);
    }

    // Get measurement value
    public double getValue() {
        return value;
    }

    // Get measurement unit
    public WeightUnit getUnit() {
        return unit;
    }

    // Compare two weight measurements
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        QuantityWeight other = (QuantityWeight) obj;

        // Normalize both measurements into kilograms
        double thisInKilograms =
                unit.convertToBaseUnit(value);

        double otherInKilograms =
                other.unit.convertToBaseUnit(other.value);

        return Double.compare(
                thisInKilograms,
                otherInKilograms
        ) == 0;
    }

    // Generate hash code
    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }

    // Display measurement
    @Override
    public String toString() {
        return "QuantityWeight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
