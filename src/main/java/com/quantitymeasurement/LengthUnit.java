
package com.quantitymeasurement;

// Enum defining supported length units
public enum LengthUnit {

    // Conversion factors relative to feet (base unit)
    FEET(1.0),
    INCHES(1.0 / 12.0);

    // Stores the conversion factor
    private final double conversionFactor;

    // Constructor to initialize the conversion factor
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    public double getConversionFactor() {
        return conversionFactor;
    }
}
