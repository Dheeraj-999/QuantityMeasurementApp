
package com.quantitymeasurement;

public class QuantityMeasurementApp {

    // UC1 compatibility wrapper for Feet measurements
    public class Feet {

        private final QuantityLength quantity;

        public Feet(double value) {
            quantity = new QuantityLength(value, LengthUnit.FEET);
        }

        public double getValue() {
            return quantity.getValue();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Feet other = (Feet) obj;
            return quantity.equals(other.quantity);
        }

        @Override
        public int hashCode() {
            return quantity.hashCode();
        }
    }

    // UC2 compatibility wrapper for Inches measurements
    public class Inches {

        private final QuantityLength quantity;

        public Inches(double value) {
            quantity = new QuantityLength(value, LengthUnit.INCHES);
        }

        public double getValue() {
            return quantity.getValue();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Inches other = (Inches) obj;
            return quantity.equals(other.quantity);
        }

        @Override
        public int hashCode() {
            return quantity.hashCode();
        }
    }

    // UC1: Compare two feet measurements
    public static boolean areFeetEqual(double value1, double value2) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Feet feet1 = app.new Feet(value1);
        Feet feet2 = app.new Feet(value2);

        return feet1.equals(feet2);
    }

    // UC2: Compare two inches measurements
    public static boolean areInchesEqual(double value1, double value2) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Inches inches1 = app.new Inches(value1);
        Inches inches2 = app.new Inches(value2);

        return inches1.equals(inches2);
    }

    // UC3: Compare two quantities with different units
    public static boolean areQuantitiesEqual(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        QuantityLength quantity1 = new QuantityLength(value1, unit1);
        QuantityLength quantity2 = new QuantityLength(value2, unit2);

        return quantity1.equals(quantity2);
    }

    // UC5: Demonstrate conversion using raw values
    public static void demonstrateLengthConversion(
            double value, LengthUnit source, LengthUnit target) {

        double result = QuantityLength.convert(value, source, target);

        System.out.println(
                value + " " + source + " = " + result + " " + target
        );
    }

    // UC5: Demonstrate conversion using an existing object
    public static void demonstrateLengthConversion(
            QuantityLength quantity, LengthUnit target) {

        QuantityLength converted = quantity.convertTo(target);

        System.out.println(quantity + " converted to " + converted);
    }

    // Demonstrate equality between two QuantityLength objects
    public static void demonstrateLengthEquality(
            QuantityLength quantity1, QuantityLength quantity2) {

        System.out.println(
                "Are measurements equal? " + quantity1.equals(quantity2)
        );
    }

    // Demonstrate comparison using raw values and units
    public static void demonstrateLengthComparison(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        QuantityLength quantity1 = new QuantityLength(value1, unit1);
        QuantityLength quantity2 = new QuantityLength(value2, unit2);

        demonstrateLengthEquality(quantity1, quantity2);
    }

    // Main method to demonstrate all implemented functionality
    public static void main(String[] args) {

        // UC1: Feet equality
        System.out.println("Feet equality: " +
                areFeetEqual(1.0, 1.0));

        // UC2: Inches equality
        System.out.println("Inches equality: " +
                areInchesEqual(1.0, 1.0));

        // UC3: Feet-to-inches equality
        System.out.println("Feet-to-inches equality: " +
                areQuantitiesEqual(
                        1.0, LengthUnit.FEET,
                        12.0, LengthUnit.INCHES));

        // UC5: Conversion using raw values
        demonstrateLengthConversion(
                1.0, LengthUnit.FEET, LengthUnit.INCHES);

        demonstrateLengthConversion(
                3.0, LengthUnit.YARDS, LengthUnit.FEET);

        demonstrateLengthConversion(
                36.0, LengthUnit.INCHES, LengthUnit.YARDS);

        // UC5: Conversion using an existing object
        QuantityLength length =
                new QuantityLength(1.0, LengthUnit.YARDS);

        demonstrateLengthConversion(length, LengthUnit.INCHES);

        // UC5: Demonstrate equality
        demonstrateLengthComparison(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES);
    }
}
