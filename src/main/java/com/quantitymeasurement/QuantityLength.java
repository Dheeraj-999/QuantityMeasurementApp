
package com.quantitymeasurement;

// Compatibility wrapper for length measurements
public class QuantityLength {

    private final Quantity<LengthUnit> quantity;

    // Constructor
    public QuantityLength(double value, LengthUnit unit) {
        this.quantity = new Quantity<>(value, unit);
    }

    // UC5: Static conversion
    public static double convert(
            double value,
            LengthUnit source,
            LengthUnit target) {

        return new Quantity<>(value, source)
                .convertTo(target)
                .getValue();
    }

    // UC5: Instance conversion
    public QuantityLength convertTo(LengthUnit target) {
        Quantity<LengthUnit> converted = quantity.convertTo(target);

        return new QuantityLength(
                converted.getValue(),
                converted.getUnit()
        );
    }

    // UC6: Addition in the first measurement's unit
    public static QuantityLength add(
            QuantityLength first,
            QuantityLength second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Length measurements cannot be null");
        }

        return add(first, second, first.getUnit());
    }

    // UC7: Addition with an explicitly specified target unit
    public static QuantityLength add(
            QuantityLength first,
            QuantityLength second,
            LengthUnit targetUnit) {

        if (first == null || second == null) {
            throw new IllegalArgumentException(
                    "Length measurements cannot be null");
        }

        Quantity<LengthUnit> result =
                first.quantity.add(second.quantity, targetUnit);

        return new QuantityLength(
                result.getValue(),
                result.getUnit()
        );
    }

    // UC6: Addition using raw values
    public static QuantityLength add(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2,
            LengthUnit targetUnit) {

        Quantity<LengthUnit> first =
                new Quantity<>(value1, unit1);

        Quantity<LengthUnit> second =
                new Quantity<>(value2, unit2);

        Quantity<LengthUnit> result =
                first.add(second, targetUnit);

        return new QuantityLength(
                result.getValue(),
                result.getUnit()
        );
    }

    public double getValue() {
        return quantity.getValue();
    }

    public LengthUnit getUnit() {
        return quantity.getUnit();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityLength)) {
            return false;
        }

        QuantityLength other = (QuantityLength) obj;

        return quantity.equals(other.quantity);
    }

    @Override
    public int hashCode() {
        return quantity.hashCode();
    }

    @Override
    public String toString() {
        return "QuantityLength{" +
                "value=" + getValue() +
                ", unit=" + getUnit() +
                '}';
    }
}
