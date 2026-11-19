
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

            // Feet objects are compared only with other Feet objects
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Feet other = (Feet) obj;

            // Delegate comparison to QuantityLength
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

            // Inches objects are compared only with other Inches objects
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Inches other = (Inches) obj;

            // Delegate comparison to QuantityLength
            return quantity.equals(other.quantity);
        }

        @Override
        public int hashCode() {
            return quantity.hashCode();
        }
    }

    // UC1: Static method to compare two feet measurements
    public static boolean areFeetEqual(double value1, double value2) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Feet feet1 = app.new Feet(value1);
        Feet feet2 = app.new Feet(value2);

        return feet1.equals(feet2);
    }

    // UC2: Static method to compare two inches measurements
    public static boolean areInchesEqual(double value1, double value2) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Inches inches1 = app.new Inches(value1);
        Inches inches2 = app.new Inches(value2);

        return inches1.equals(inches2);
    }

    // UC3: Compare two quantities with their respective units
    public static boolean areQuantitiesEqual(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        QuantityLength quantity1 = new QuantityLength(value1, unit1);
        QuantityLength quantity2 = new QuantityLength(value2, unit2);

        return quantity1.equals(quantity2);
    }

    // Main method to demonstrate UC1, UC2 and UC3
    public static void main(String[] args) {

        // UC1: Feet-to-feet comparison
        System.out.println(
                "Feet equality: " + areFeetEqual(1.0, 1.0)
        );

        // UC2: Inches-to-inches comparison
        System.out.println(
                "Inches equality: " + areInchesEqual(1.0, 1.0)
        );

        // UC3: Feet-to-inches comparison
        System.out.println(
                "Feet-to-inches equality: " +
                        areQuantitiesEqual(1.0, LengthUnit.FEET,
                                12.0, LengthUnit.INCHES)
        );
    }
}
