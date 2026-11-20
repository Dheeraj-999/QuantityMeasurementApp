
package com.quantitymeasurement;

// Enum defining supported volume units
public enum VolumeUnit implements IMeasurable {

    // Conversion factors relative to litre (base unit)
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Convert the given value into litres
    @Override
    public double convertToBaseUnit(double value) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Volume value must be finite");
        }

        double baseValue = value * conversionFactor;

        if (!Double.isFinite(baseValue)) {
            throw new IllegalArgumentException(
                    "Converted value is outside the supported range");
        }

        return baseValue;
    }

    // Convert litres into the selected volume unit
    @Override
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

    @Override
    public String getUnitName() {
        return name();
    }
}
