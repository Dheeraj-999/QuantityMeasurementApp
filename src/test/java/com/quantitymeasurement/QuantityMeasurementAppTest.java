
package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // Create application instance for inner Feet class
    private final QuantityMeasurementApp app = new QuantityMeasurementApp();

    // Test equality when both measurements have the same value
    @Test
    void testEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(1.0);

        assertTrue(feet1.equals(feet2));
    }

    // Test inequality when measurements have different values
    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(2.0);

        assertFalse(feet1.equals(feet2));
    }

    // Test comparison with null
    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = app.new Feet(1.0);

        assertFalse(feet.equals(null));
    }

    // Test comparison with an object of a different type
    @Test
    void testEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet = app.new Feet(1.0);

        assertFalse(feet.equals("1.0"));
    }

    // Test reflexive property: an object must equal itself
    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = app.new Feet(1.0);

        assertTrue(feet.equals(feet));
    }

    // Test symmetric property of equals()
    @Test
    void testEquality_Symmetric() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(1.0);

        assertEquals(feet1.equals(feet2), feet2.equals(feet1));
    }

    // Test that equal objects have equal hash codes
    @Test
    void testEquality_SameHashCode() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(1.0);

        assertEquals(feet1.hashCode(), feet2.hashCode());
    }
}
