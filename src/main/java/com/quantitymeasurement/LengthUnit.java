
package com.quantitymeasurement;

// Enum defining supported length units
public enum LengthUnit {

    // Conversion factors relative to feet (base unit)
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.393701 / 12.0);

    // Stores the conversion factor
    private final double conversionFactor;

    // Constructor
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    public double getConversionFactor() {
        return conversionFactor;
    }

    // UC8: Converts the given unit value into the base unit (feet)
    public double convertToBaseUnit(double value) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Measurement value must be finite");
        }

        double baseValue = value * conversionFactor;

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return baseValue;
    }

    // UC8: Converts a base unit value (feet) into this unit
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
