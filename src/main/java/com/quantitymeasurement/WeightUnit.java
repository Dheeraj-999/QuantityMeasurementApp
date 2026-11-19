
package com.quantitymeasurement;

// Enum defining supported weight units
public enum WeightUnit {

    // Conversion factors relative to kilogram (base unit)
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    // Stores the conversion factor
    private final double conversionFactor;

    // Constructor
    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Converts the given weight into kilograms
    public double convertToBaseUnit(double value) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Weight value must be finite");
        }

        double baseValue = value * conversionFactor;

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return baseValue;
    }

    // Converts kilograms into this weight unit
    public double convertFromBaseUnit(double baseValue) {

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException(
                    "Base unit value must be finite");
        }

        double convertedValue = baseValue / conversionFactor;

        if (!Double.isFinite(convertedValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return convertedValue;
    }
}
