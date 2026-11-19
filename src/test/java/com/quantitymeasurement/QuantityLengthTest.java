
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


    // UC4: Yard-to-yard equality

    @Test
    void testEquality_YardToYard_SameValue() {
        QuantityLength yard1 =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength yard2 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertTrue(yard1.equals(yard2));
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        QuantityLength yard1 =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength yard2 =
                new QuantityLength(2.0, LengthUnit.YARDS);

        assertFalse(yard1.equals(yard2));
    }

    // UC4: Yard-to-feet equality

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    // UC4: Yard-to-inches equality

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength inches =
                new QuantityLength(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        QuantityLength inches =
                new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertTrue(inches.equals(yard));
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet =
                new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(yard.equals(feet));
    }

    // UC4: Centimeter equality

    @Test
    void testEquality_CentimetersToCentimeters_SameValue() {
        QuantityLength cm1 =
                new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        QuantityLength cm2 =
                new QuantityLength(2.0, LengthUnit.CENTIMETERS);

        assertTrue(cm1.equals(cm2));
    }

    @Test
    void testEquality_CentimetersToCentimeters_DifferentValue() {
        QuantityLength cm1 =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength cm2 =
                new QuantityLength(2.0, LengthUnit.CENTIMETERS);

        assertFalse(cm1.equals(cm2));
    }

    // UC4: Centimeter-to-inches equality

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {
        QuantityLength cm =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength inches =
                new QuantityLength(0.393701, LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    // UC4: Centimeter-to-feet equality

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {
        QuantityLength cm =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(cm.equals(feet));
    }

    // UC4: Multi-unit transitive equality

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inches =
                new QuantityLength(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    // UC4: Null comparison and same-reference checks

    @Test
    void testEquality_YardSameReference() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertTrue(yard.equals(yard));
    }

    @Test
    void testEquality_YardNullComparison() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        assertFalse(yard.equals(null));
    }

    @Test
    void testEquality_CentimetersSameReference() {
        QuantityLength cm =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        assertTrue(cm.equals(cm));
    }

    @Test
    void testEquality_CentimetersNullComparison() {
        QuantityLength cm =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        assertFalse(cm.equals(null));
    }

    // UC4: Equivalent units must have the same hash code

    @Test
    void testEquality_YardAndFeetSameHashCode() {
        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        assertEquals(yard.hashCode(), feet.hashCode());
    }


    // UC5: Basic conversions

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                QuantityLength.convert(1.0,
                        LengthUnit.FEET, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                QuantityLength.convert(24.0,
                        LengthUnit.INCHES, LengthUnit.FEET),
                1e-6);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                QuantityLength.convert(1.0,
                        LengthUnit.YARDS, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_InchesToYards() {
        assertEquals(2.0,
                QuantityLength.convert(72.0,
                        LengthUnit.INCHES, LengthUnit.YARDS),
                1e-6);
    }

    @Test
    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                QuantityLength.convert(2.54,
                        LengthUnit.CENTIMETERS, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_FeetToYards() {
        assertEquals(2.0,
                QuantityLength.convert(6.0,
                        LengthUnit.FEET, LengthUnit.YARDS),
                1e-6);
    }

    // UC5: Same-unit conversion

    @Test
    void testConversion_SameUnit() {
        assertEquals(5.0,
                QuantityLength.convert(5.0,
                        LengthUnit.FEET, LengthUnit.FEET),
                1e-6);
    }

    // UC5: Zero and negative values

    @Test
    void testConversion_ZeroValue() {
        assertEquals(0.0,
                QuantityLength.convert(0.0,
                        LengthUnit.FEET, LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_NegativeValue() {
        assertEquals(-12.0,
                QuantityLength.convert(-1.0,
                        LengthUnit.FEET, LengthUnit.INCHES),
                1e-6);
    }

    // UC5: Round-trip conversion

    @Test
    void testConversion_RoundTrip_PreservesValue() {
        double original = 10.0;

        double inches = QuantityLength.convert(
                original, LengthUnit.FEET, LengthUnit.INCHES);

        double convertedBack = QuantityLength.convert(
                inches, LengthUnit.INCHES, LengthUnit.FEET);

        assertEquals(original, convertedBack, 1e-6);
    }

    // UC5: Invalid inputs

    @Test
    void testConversion_NullSourceUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        1.0, null, LengthUnit.FEET));
    }

    @Test
    void testConversion_NullTargetUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        1.0, LengthUnit.FEET, null));
    }

    @Test
    void testConversion_NaNValue() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.NaN,
                        LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    void testConversion_InfiniteValue() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.POSITIVE_INFINITY,
                        LengthUnit.FEET, LengthUnit.INCHES));
    }

    // UC5: Instance conversion

    @Test
    void testConversion_InstanceMethod() {
        QuantityLength original =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength converted =
                original.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, converted.getValue(), 1e-6);
        assertEquals(LengthUnit.INCHES, converted.getUnit());

        // Original object remains unchanged
        assertEquals(1.0, original.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, original.getUnit());
    }

    // UC5: String representation

    @Test
    void testConversion_ToString() {
        QuantityLength length =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertEquals(
                "QuantityLength{value=1.0, unit=FEET}",
                length.toString());
    }


    // ==========================================
    // UC6: Addition of Length Measurements
    // ==========================================

    // 1. Addition of two feet measurements
    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength first =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(2.0, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(3.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // 2. Addition of two inches measurements
    @Test
    void testAddition_SameUnit_InchPlusInch() {
        QuantityLength first =
                new QuantityLength(10.0, LengthUnit.INCHES);
        QuantityLength second =
                new QuantityLength(5.0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(15.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    // 3. Addition of feet and inches
    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength first =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // 4. Addition of inches and feet
    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength first =
                new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength second =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(24.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    // 5. Addition of yards and feet
    @Test
    void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength first =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength second =
                new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    // 6. Addition of centimeters and inches
    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength first =
                new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength second =
                new QuantityLength(1.0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(5.08, result.getValue(), 1e-5);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    // 7. Addition should be commutative
    @Test
    void testAddition_Commutativity() {
        QuantityLength first =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result1 = QuantityLength.add(first, second);
        QuantityLength result2 = QuantityLength.add(second, first);

        assertEquals(result1, result2);
    }

    // 8. Addition with zero
    @Test
    void testAddition_WithZero() {
        QuantityLength first =
                new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(5.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // 9. Addition with negative values
    @Test
    void testAddition_NegativeValues() {
        QuantityLength first =
                new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(3.0, result.getValue(), 1e-6);
    }

    // 10. Addition with null second operand
    @Test
    void testAddition_NullSecondOperand() {
        QuantityLength first =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.add(first, null)
        );
    }

    // 11. Addition with large values
    @Test
    void testAddition_LargeValues() {
        QuantityLength first =
                new QuantityLength(1e100, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(1e100, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(2e100, result.getValue(), 1e85);
    }

    // 12. Addition with small values
    @Test
    void testAddition_SmallValues() {
        QuantityLength first =
                new QuantityLength(1e-9, LengthUnit.FEET);
        QuantityLength second =
                new QuantityLength(2e-9, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(first, second);

        assertEquals(3e-9, result.getValue(), 1e-15);
    }

    // 13. Addition with null first operand
    @Test
    void testAddition_NullFirstOperand() {
        QuantityLength second =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.add(null, second)
        );
    }

    // 14. Addition using an explicitly specified target unit
    @Test
    void testAddition_ExplicitTargetUnit() {
        QuantityLength result = QuantityLength.add(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES,
                LengthUnit.INCHES
        );

        assertEquals(24.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }



}
