
package com.quantitymeasurement;

// Enum defining supported length units
public enum LengthUnit implements IMeasurable {

    // Conversion factors relative to feet (base unit)
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.393701 / 12.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Length value must be finite");
        }

        double baseValue = value * conversionFactor;

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return baseValue;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException("Base unit value must be finite");
        }

        double convertedValue = baseValue / conversionFactor;

        if (!Double.isFinite(convertedValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return convertedValue;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}
