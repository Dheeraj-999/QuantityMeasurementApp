
package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    // UC9: Equality tests

    @Test
    void testEquality_KilogramToKilogram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_GramToGram() {
        assertEquals(
                new QuantityWeight(500.0, WeightUnit.GRAM),
                new QuantityWeight(500.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_PoundToPound() {
        assertEquals(
                new QuantityWeight(2.0, WeightUnit.POUND),
                new QuantityWeight(2.0, WeightUnit.POUND)
        );
    }

    @Test
    void testEquality_KilogramToGram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_GramToKilogram() {
        assertEquals(
                new QuantityWeight(1000.0, WeightUnit.GRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_PoundToGram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.POUND),
                new QuantityWeight(453.592, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_DifferentValues() {
        assertNotEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.0, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_NullComparison() {
        QuantityWeight weight =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(null, weight);
    }

    @Test
    void testEquality_SameReference() {
        QuantityWeight weight =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(weight, weight);
    }

    @Test
    void testEquality_WeightVsLengthIncompatible() {
        QuantityWeight weight =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityLength length =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertNotEquals(weight, length);
    }

    @Test
    void testEquality_ZeroValues() {
        assertEquals(
                new QuantityWeight(0.0, WeightUnit.KILOGRAM),
                new QuantityWeight(0.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_NegativeValues() {
        assertEquals(
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(-1000.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_HashCodeConsistency() {
        QuantityWeight first =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight second =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    // UC9: Constructor validation

    @Test
    void testConstructor_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null)
        );
    }

    @Test
    void testConstructor_NaNValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testConstructor_InfiniteValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(
                        Double.POSITIVE_INFINITY,
                        WeightUnit.KILOGRAM)
        );
    }

    // UC9: Conversion tests

    @Test
    void testConversion_KilogramToGram() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.000001);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    void testConversion_GramToKilogram() {
        QuantityWeight result =
                new QuantityWeight(1000.0, WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), 0.000001);
    }

    @Test
    void testConversion_PoundToKilogram() {
        QuantityWeight result =
                new QuantityWeight(2.0, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(0.907184, result.getValue(), 0.000001);
    }

    @Test
    void testConversion_KilogramToPound() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.getValue(), 0.0001);
    }

    @Test
    void testConversion_SameUnit() {
        QuantityWeight result =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(5.0, result.getValue(), 0.000001);
    }

    @Test
    void testConversion_ZeroValue() {
        QuantityWeight result =
                new QuantityWeight(0.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(0.0, result.getValue(), 0.000001);
    }

    @Test
    void testConversion_NegativeValue() {
        QuantityWeight result =
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(-1000.0, result.getValue(), 0.000001);
    }

    @Test
    void testConversion_RoundTrip() {
        QuantityWeight original =
                new QuantityWeight(1.5, WeightUnit.KILOGRAM);

        QuantityWeight result =
                original.convertTo(WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.5, result.getValue(), 0.000001);
        assertEquals(1.5, original.getValue(), 0.000001);
    }

    @Test
    void testConversion_NullTargetUnit() {
        QuantityWeight weight =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> weight.convertTo(null)
        );
    }

    // UC9: Addition tests

    @Test
    void testAddition_SameUnit() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.0, WeightUnit.KILOGRAM)
        );

        assertEquals(3.0, result.getValue(), 0.000001);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM)
        );

        assertEquals(2.0, result.getValue(), 0.000001);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM),
                WeightUnit.GRAM
        );

        assertEquals(2000.0, result.getValue(), 0.000001);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetPound() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                WeightUnit.POUND
        );

        assertEquals(4.40924, result.getValue(), 0.0001);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    @Test
    void testAddition_WithZero() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(5.0, WeightUnit.KILOGRAM),
                new QuantityWeight(0.0, WeightUnit.GRAM)
        );

        assertEquals(5.0, result.getValue(), 0.000001);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityWeight result = QuantityWeight.add(
                new QuantityWeight(5.0, WeightUnit.KILOGRAM),
                new QuantityWeight(-2000.0, WeightUnit.GRAM)
        );

        assertEquals(3.0, result.getValue(), 0.000001);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityWeight first = QuantityWeight.add(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(500.0, WeightUnit.GRAM),
                WeightUnit.KILOGRAM
        );

        QuantityWeight second = QuantityWeight.add(
                new QuantityWeight(500.0, WeightUnit.GRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                WeightUnit.KILOGRAM
        );

        assertEquals(first, second);
    }

    @Test
    void testAddition_NullFirstOperand() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityWeight.add(
                        null,
                        new QuantityWeight(1.0, WeightUnit.KILOGRAM))
        );
    }

    @Test
    void testAddition_NullSecondOperand() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityWeight.add(
                        new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                        null)
        );
    }

    @Test
    void testAddition_NullTargetUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityWeight.add(
                        new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                        new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                        null)
        );
    }
}
