
package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    // 1. Test equality between length measurements
    @Test
    void testLengthEquality() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    // 2. Test equality between weight measurements
    @Test
    void testWeightEquality() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(kg, grams);
    }

    // 3. Test inequality
    @Test
    void testDifferentValuesNotEqual() {
        Quantity<LengthUnit> first =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertNotEquals(first, second);
    }

    // 4. Test length conversion
    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, inches.getValue(), 0.0001);
        assertEquals(LengthUnit.INCHES, inches.getUnit());
    }

    // 5. Test weight conversion
    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, grams.getValue(), 0.0001);
    }

    // 6. Test addition with the first unit as result
    @Test
    void testAdditionDefaultUnit() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches);

        assertEquals(2.0, result.getValue(), 0.0001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // 7. Test addition with an explicit target unit
    @Test
    void testAdditionExplicitTargetUnit() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.0001);
    }

    // 8. Test weight addition
    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(500.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = kg.add(grams);

        assertEquals(1.5, result.getValue(), 0.0001);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    // 9. Different categories should not be equal
    @Test
    void testLengthAndWeightNotEqual() {
        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    // 10. Test hashCode consistency
    @Test
    void testHashCodeConsistency() {
        Quantity<LengthUnit> first =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> second =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(first.hashCode(), second.hashCode());
    }

    // 11. Test null unit validation
    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<LengthUnit>(1.0, null));
    }

    // 12. Test invalid measurement value
    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    // 13. Test null conversion target
    @Test
    void testNullConversionTarget() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> feet.convertTo(null));
    }

    // 14. Test null addition
    @Test
    void testNullAddition() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> feet.add(null));
    }

    // 15. Test zero value
    @Test
    void testZeroValue() {
        Quantity<WeightUnit> zero =
                new Quantity<>(0.0, WeightUnit.KILOGRAM);

        assertEquals(0.0, zero.getValue());
    }
}
