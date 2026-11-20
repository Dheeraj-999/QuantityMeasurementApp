
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

    // Main method demonstrating generic measurements
    public static void main(String[] args) {

        // Length measurements
        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("=== LENGTH MEASUREMENTS ===");

        demonstrateEquality(length1, length2);

        demonstrateConversion(length1, LengthUnit.INCHES);

        demonstrateAddition(length1, length2);


        // Weight measurements
        Quantity<WeightUnit> weight1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(500.0, WeightUnit.GRAM);

        System.out.println("\n=== WEIGHT MEASUREMENTS ===");

        demonstrateEquality(weight1,
                new Quantity<>(1000.0, WeightUnit.GRAM));

        demonstrateConversion(weight1, WeightUnit.GRAM);

        demonstrateAddition(weight1, weight2);


        // Cross-category equality
        System.out.println("\n=== DIFFERENT CATEGORIES ===");

        demonstrateEquality(length1, weight1);
    }


    // Generic method to demonstrate measurement equality
    public static void demonstrateEquality(
            Quantity<? extends IMeasurable> first,
            Quantity<? extends IMeasurable> second) {

        System.out.println("Are measurements equal? " + first.equals(second));
    }

    // Generic method to demonstrate conversion
    public static <U extends IMeasurable> void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        Quantity<U> converted = quantity.convertTo(targetUnit);

        System.out.println("Original: " + quantity);
        System.out.println("Converted: " + converted);
    }

    // Generic method to demonstrate addition
    public static <U extends IMeasurable> void demonstrateAddition(
            Quantity<U> first,
            Quantity<U> second) {

        System.out.println("Addition result: " + first.add(second));
    }
}
