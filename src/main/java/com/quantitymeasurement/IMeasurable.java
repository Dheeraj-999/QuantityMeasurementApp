package com.quantitymeasurement;

// Common interface for all measurement units
public interface IMeasurable {

    // Returns the conversion factor relative to the base unit
    double getConversionFactor();

    // Converts a value into the base unit
    double convertToBaseUnit(double value);

    // Converts a base unit value into this unit
    double convertFromBaseUnit(double baseValue);

    // Returns the readable unit name
    String getUnitName();
}