package seminars.second.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VehicleTest {
    @Test
    void testCarIsInstanceOfVehicle() {
        Car car = new Car("Lada", "Vesta", 2020);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testCatHasFourWheels() {
        Car car = new Car("Lada", "Kalina", 2010);
        assertEquals(car.getNumWheels(), 4);
    }

    @Test
    void testMotorcycleHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Fat Boy", 2015);
        assertEquals(motorcycle.getNumWheels(), 2);
    }

    @Test
    void testCarDriveSpeed() {
        Car car = new Car("Lada", "Largus", 2021);
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    @Test
    void testMotorcycleDriveSpeed() {
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Street 7501", 2022);
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }

    @Test
    void testCarPark() {
        Car car = new Car("Lada", "Granta", 2022);
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    void testMotorcyclePark() {
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Breakout", 2018);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }
}