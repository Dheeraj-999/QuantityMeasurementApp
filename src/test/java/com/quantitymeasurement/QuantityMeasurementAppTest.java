
package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // Create application instance for inner classes
    private final QuantityMeasurementApp app = new QuantityMeasurementApp();

    // ==================== UC1: FEET TEST CASES ====================

    @Test
    void testEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(1.0);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(2.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = app.new Feet(1.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet = app.new Feet(1.0);

        assertFalse(feet.equals("1.0"));
    }

    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = app.new Feet(1.0);

        assertTrue(feet.equals(feet));
    }

    @Test
    void testEquality_Symmetric() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(1.0);

        assertEquals(feet1.equals(feet2), feet2.equals(feet1));
    }

    @Test
    void testEquality_SameHashCode() {
        QuantityMeasurementApp.Feet feet1 = app.new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = app.new Feet(1.0);

        assertEquals(feet1.hashCode(), feet2.hashCode());
    }

    // ==================== UC2: INCHES TEST CASES ====================

    @Test
    void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inches1 = app.new Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = app.new Inches(1.0);

        assertTrue(inches1.equals(inches2));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches inches1 = app.new Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = app.new Inches(2.0);

        assertFalse(inches1.equals(inches2));
    }

    @Test
    void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inches = app.new Inches(1.0);

        assertFalse(inches.equals(null));
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inches = app.new Inches(1.0);

        assertFalse(inches.equals("1.0"));
    }

    @Test
    void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inches = app.new Inches(1.0);

        assertTrue(inches.equals(inches));
    }

    @Test
    void testInchesEquality_Symmetric() {
        QuantityMeasurementApp.Inches inches1 = app.new Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = app.new Inches(1.0);

        assertEquals(inches1.equals(inches2), inches2.equals(inches1));
    }

    @Test
    void testInchesEquality_SameHashCode() {
        QuantityMeasurementApp.Inches inches1 = app.new Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = app.new Inches(1.0);

        assertEquals(inches1.hashCode(), inches2.hashCode());
    }

    // ==================== UC2: STATIC METHOD TESTS ====================

    @Test
    void testAreFeetEqual() {
        assertTrue(QuantityMeasurementApp.areFeetEqual(1.0, 1.0));
    }

    @Test
    void testAreFeetNotEqual() {
        assertFalse(QuantityMeasurementApp.areFeetEqual(1.0, 2.0));
    }

    @Test
    void testAreInchesEqual() {
        assertTrue(QuantityMeasurementApp.areInchesEqual(1.0, 1.0));
    }

    @Test
    void testAreInchesNotEqual() {
        assertFalse(QuantityMeasurementApp.areInchesEqual(1.0, 2.0));
    }
}
