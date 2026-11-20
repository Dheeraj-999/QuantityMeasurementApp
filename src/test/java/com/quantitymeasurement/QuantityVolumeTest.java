
package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityVolumeTest {

    // Equality tests

    @Test
    void testSameUnitEquality() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        assertEquals(q1, q2);
    }

    @Test
    void testLitreAndMillilitreEquality() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(q1, q2);
    }

    @Test
    void testGallonAndLitreEquality() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertEquals(q1, q2);
    }

    @Test
    void testDifferentVolumeValuesAreNotEqual() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        assertNotEquals(q1, q2);
    }

    @Test
    void testNullEquality() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertNotEquals(q1, null);
    }

    @Test
    void testCrossCategoryEquality() {
        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertNotEquals(volume, length);
    }

    // Conversion tests

    @Test
    void testLitreToMillilitre() {
        Quantity<VolumeUnit> q =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.000001);
    }

    @Test
    void testMillilitreToLitre() {
        Quantity<VolumeUnit> q =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.LITRE);

        assertEquals(1.0, result.getValue(), 0.000001);
    }

    @Test
    void testGallonToLitre() {
        Quantity<VolumeUnit> q =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result.getValue(), 0.000001);
    }

    @Test
    void testLitreToGallon() {
        Quantity<VolumeUnit> q =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.GALLON);

        assertEquals(1.0, result.getValue(), 0.000001);
    }

    @Test
    void testZeroConversion() {
        Quantity<VolumeUnit> q =
                new Quantity<>(0.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(0.0, result.getValue());
    }

    @Test
    void testNegativeConversion() {
        Quantity<VolumeUnit> q =
                new Quantity<>(-2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(-2000.0, result.getValue(), 0.000001);
    }

    @Test
    void testConvertToNullUnit() {
        Quantity<VolumeUnit> q =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class,
                () -> q.convertTo(null));
    }

    // Addition tests

    @Test
    void testAdditionSameUnit() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(3.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q1.add(q2);

        assertEquals(5.0, result.getValue(), 0.000001);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAdditionDifferentUnits() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.add(q2);

        assertEquals(1.5, result.getValue(), 0.000001);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAdditionWithTargetUnit() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q1.add(q2, VolumeUnit.MILLILITRE);

        assertEquals(2000.0, result.getValue(), 0.000001);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testAdditionWithGallons() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q1.add(q2);

        assertEquals(2.0, result.getValue(), 0.000001);
    }

    @Test
    void testAdditionWithNullQuantity() {
        Quantity<VolumeUnit> q =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class,
                () -> q.add(null));
    }

    @Test
    void testAdditionWithNullTargetUnit() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class,
                () -> q1.add(q2, null));
    }

    // Hash code tests

    @Test
    void testEqualQuantitiesHaveSameHashCode() {
        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(q1.hashCode(), q2.hashCode());
    }

    // Constructor validation tests

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testNaNValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, VolumeUnit.LITRE));
    }

    @Test
    void testInfiniteValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.POSITIVE_INFINITY,
                        VolumeUnit.LITRE));
    }

    // VolumeUnit enum tests

    @Test
    void testConversionFactors() {
        assertEquals(1.0, VolumeUnit.LITRE.getConversionFactor());
        assertEquals(0.001, VolumeUnit.MILLILITRE.getConversionFactor());
        assertEquals(3.78541, VolumeUnit.GALLON.getConversionFactor());
    }

    @Test
    void testConvertToBaseUnit() {
        assertEquals(1.0,
                VolumeUnit.LITRE.convertToBaseUnit(1.0));
        assertEquals(1.0,
                VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0));
        assertEquals(3.78541,
                VolumeUnit.GALLON.convertToBaseUnit(1.0));
    }

    @Test
    void testConvertFromBaseUnit() {
        assertEquals(1000.0,
                VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0));
        assertEquals(1.0,
                VolumeUnit.GALLON.convertFromBaseUnit(3.78541));
    }

    @Test
    void testGetUnitName() {
        assertEquals("LITRE", VolumeUnit.LITRE.getUnitName());
        assertEquals("MILLILITRE", VolumeUnit.MILLILITRE.getUnitName());
        assertEquals("GALLON", VolumeUnit.GALLON.getUnitName());
    }

    @Test
    void testInvalidBaseConversion() {
        assertThrows(IllegalArgumentException.class,
                () -> VolumeUnit.LITRE.convertToBaseUnit(Double.NaN));

        assertThrows(IllegalArgumentException.class,
                () -> VolumeUnit.LITRE.convertFromBaseUnit(Double.POSITIVE_INFINITY));
    }
}
