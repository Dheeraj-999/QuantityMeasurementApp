
package com.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class representing a measurement in feet
    public class Feet {

        private final double value;

        // Constructor to initialize feet value
        public Feet(double value) {
            this.value = value;
        }

        // Getter to access feet value
        public double getValue() {
            return value;
        }

        // Compare two Feet objects based on their values
        @Override
        public boolean equals(Object obj) {

            // Check whether both references point to the same object
            if (this == obj) {
                return true;
            }

            // Check for null or different object types
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Typecast Object into Feet
            Feet other = (Feet) obj;

            // Compare measurement values
            return Double.compare(this.value, other.value) == 0;
        }

        // Maintain equals() and hashCode() contract
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // UC2: Inner class representing a measurement in inches
    public class Inches {

        private final double value;

        // Constructor to initialize inches value
        public Inches(double value) {
            this.value = value;
        }

        // Getter to access inches value
        public double getValue() {
            return value;
        }

        // Compare two Inches objects based on their values
        @Override
        public boolean equals(Object obj) {

            // Check whether both references point to the same object
            if (this == obj) {
                return true;
            }

            // Check for null or different object types
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Typecast Object into Inches
            Inches other = (Inches) obj;

            // Compare measurement values
            return Double.compare(this.value, other.value) == 0;
        }

        // Maintain equals() and hashCode() contract
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Static method to compare two feet measurements
    public static boolean areFeetEqual(double value1, double value2) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Feet feet1 = app.new Feet(value1);
        Feet feet2 = app.new Feet(value2);

        return feet1.equals(feet2);
    }

    // Static method to compare two inches measurements
    public static boolean areInchesEqual(double value1, double value2) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Inches inches1 = app.new Inches(value1);
        Inches inches2 = app.new Inches(value2);

        return inches1.equals(inches2);
    }

    // Main method to demonstrate UC1 and UC2 functionality
    public static void main(String[] args) {

        // UC1: Compare feet measurements
        System.out.println(
                "Are feet measurements equal? " +
                        areFeetEqual(1.0, 1.0)
        );

        // UC2: Compare inches measurements
        System.out.println(
                "Are inches measurements equal? " +
                        areInchesEqual(1.0, 1.0)
        );
    }
}
