package org.example.Test;

import org.example.Person;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person p1;
    private Person p2;

    @BeforeAll
    public static void init() {
        System.out.println("Initializing before all tests");
    }

    @AfterAll
    public static void clean() {
        System.out.println("Cleaning up after all tests");
    }

    @BeforeEach
    public void createObjects() {
        p1 = new Person("Raghad", 27, "Riyadh Safa");
        p2 = new Person("Nora", 23, "Riyadh");
        System.out.println("Creating objects before each test");
    }

    @Test
    public void testSetAgeValid() {
        p1.setAge(30);
        assertEquals(30, p1.getAge());
    }

    @Test
    public void testSetAgeInvalidTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> p1.setAge(151));
    }

    @Test
    public void testSetAgeInvalidTooLow() {
        assertThrows(IllegalArgumentException.class, () -> p1.setAge(-1));
    }

    @Test
    public void testSetAgeBoundaryValues() {
        assertDoesNotThrow(() -> p1.setAge(0));
        assertEquals(0, p1.getAge());

        assertDoesNotThrow(() -> p1.setAge(150));
        assertEquals(150, p1.getAge());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Name: Raghad -Age: 27 -Address: Riyadh Safa";
        assertEquals(expectedDetails, p1.getDetails());
    }

    @RepeatedTest(3)
    public void testSetAgeMultipleTimes(RepetitionInfo repInfo) {
        System.out.println("Running repetition " + repInfo.getCurrentRepetition());
        int newAge = 27 + repInfo.getCurrentRepetition();
        assertDoesNotThrow(() -> p1.setAge(newAge));
        assertEquals(newAge, p1.getAge());
    }
}