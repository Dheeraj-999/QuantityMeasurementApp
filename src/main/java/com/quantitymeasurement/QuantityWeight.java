
package com.quantitymeasurement;

// Compatibility wrapper for weight measurements
public class QuantityWeight {

    private final Quantity<WeightUnit> quantity;

    // Constructor
    public QuantityWeight(double value, WeightUnit unit) {
        this.quantity = new Quantity<>(value, unit);
    }

    // UC9: Convert weight into another unit
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        Quantity<WeightUnit> converted =
                quantity.convertTo(targetUnit);

        return new QuantityWeight(
                converted.getValue(),
                converted.getUnit()
        );
    }

    // UC9: Addition in the first measurement's unit
    public static QuantityWeight add(
            QuantityWeight first,
            QuantityWeight second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Weight measurements cannot be null");
        }

        return add(first, second, first.getUnit());
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

        Quantity<WeightUnit> result =
                first.quantity.add(second.quantity, targetUnit);

        return new QuantityWeight(
                result.getValue(),
                result.getUnit()
        );
    }

    // Get measurement value
    public double getValue() {
        return quantity.getValue();
    }

    // Get measurement unit
    public WeightUnit getUnit() {
        return quantity.getUnit();
    }

    // Compare two weight measurements
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityWeight)) {
            return false;
        }

        QuantityWeight other = (QuantityWeight) obj;

        return quantity.equals(other.quantity);
    }

    // Generate hash code
    @Override
    public int hashCode() {
        return quantity.hashCode();
    }

    // Display measurement
    @Override
    public String toString() {
        return "QuantityWeight{" +
                "value=" + getValue() +
                ", unit=" + getUnit() +
                '}';
    }
}
