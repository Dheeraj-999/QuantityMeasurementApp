package com.quantitymeasurement;

// Enum defining supported weight units
public enum WeightUnit implements IMeasurable {

    // Conversion factors relative to kilogram (base unit)
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Weight value must be finite");
        }

        double baseValue = value * conversionFactor;

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException("Converted value is outside the supported range");
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
            throw new IllegalArgumentException("Converted value is outside the supported range");
        }

        return convertedValue;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}