
package com.quantitymeasurement;

// Generic class supporting all measurement categories
public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    // Constructor
    public Quantity(double value, U unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // Convert into another unit of the same category
    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        // Round result to two decimal places

        return new Quantity<>(convertedValue, targetUnit);
    }

    // Addition: result in the first quantity's unit
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // Addition: result in the specified target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double firstBase = unit.convertToBaseUnit(value);
        double secondBase = other.unit.convertToBaseUnit(other.value);

        double sum = firstBase + secondBase;

        if (!Double.isFinite(sum)) {
            throw new IllegalArgumentException("Addition result is outside the supported range");
        }

        double result = targetUnit.convertFromBaseUnit(sum);

        return new Quantity<>(result, targetUnit);
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

        // Prevent comparison between different measurement categories
        if (unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
