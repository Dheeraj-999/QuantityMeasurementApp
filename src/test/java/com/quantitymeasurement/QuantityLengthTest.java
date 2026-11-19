
package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    // Test feet-to-feet equality
    @Test
    void testEquality_FeetToFeet_SameValue() {

        QuantityLength quantity1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength quantity2 =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(quantity1.equals(quantity2));
    }

    // Test inches-to-inches equality
    @Test
    void testEquality_InchToInch_SameValue() {

        QuantityLength quantity1 =
                new QuantityLength(1.0, LengthUnit.INCHES);

        QuantityLength quantity2 =
                new QuantityLength(1.0, LengthUnit.INCHES);

        assertTrue(quantity1.equals(quantity2));
    }

    // Test equivalent feet and inches
    @Test
    void testEquality_FeetToInches_EquivalentValue() {

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    // Test reverse inches-to-feet comparison
    @Test
    void testEquality_InchesToFeet_EquivalentValue() {

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(inches.equals(feet));
    }

    // Test different feet measurements
    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        QuantityLength quantity1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength quantity2 =
                new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(quantity1.equals(quantity2));
    }

    // Test different inches measurements
    @Test
    void testEquality_InchToInch_DifferentValue() {

        QuantityLength quantity1 =
                new QuantityLength(1.0, LengthUnit.INCHES);

        QuantityLength quantity2 =
                new QuantityLength(2.0, LengthUnit.INCHES);

        assertFalse(quantity1.equals(quantity2));
    }

    // Test comparison with null
    @Test
    void testEquality_NullComparison() {

        QuantityLength quantity =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(quantity.equals(null));
    }

    // Test comparison with a different object type
    @Test
    void testEquality_DifferentObjectType() {

        QuantityLength quantity =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(quantity.equals("1.0"));
    }

    // Test reflexive property
    @Test
    void testEquality_SameReference() {

        QuantityLength quantity =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(quantity.equals(quantity));
    }

    // Test that equivalent quantities have equal hash codes
    @Test
    void testEquality_EquivalentQuantitiesSameHashCode() {

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(feet.hashCode(), inches.hashCode());
    }

    // Test that null unit is rejected
    @Test
    void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }

    // Test symmetry of cross-unit equality
    @Test
    void testEquality_Symmetry() {

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(feet.equals(inches), inches.equals(feet));
    }
}
