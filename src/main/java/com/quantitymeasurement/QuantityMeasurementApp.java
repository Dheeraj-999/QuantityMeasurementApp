
package com.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class representing a measurement in feet
    public class Feet {

        // Private final field ensures encapsulation and immutability
        private final double value;

        // Constructor to initialize the feet measurement
        public Feet(double value) {
            this.value = value;
        }

        // Getter to access the measurement value
        public double getValue() {
            return value;
        }

        // Overriding equals() to compare two Feet objects by value
        @Override
        public boolean equals(Object obj) {

            // Check if both references point to the same object
            if (this == obj) {
                return true;
            }

            // Check for null or different object types
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Convert Object into Feet after type checking
            Feet other = (Feet) obj;

            // Compare double values accurately
            return Double.compare(this.value, other.value) == 0;
        }

        // Override hashCode() to maintain the equals-hashCode contract
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to demonstrate feet measurement equality
    public static void main(String[] args) {

        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Feet feet1 = app.new Feet(1.0);
        Feet feet2 = app.new Feet(1.0);

        System.out.println("Are measurements equal? " + feet1.equals(feet2));
    }
}
