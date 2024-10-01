package org.example;
import org.example.SportsLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportsLoggerTest {

    private SportsLogger logger;

    @BeforeEach
    public void setUp() {
        logger = new SportsLogger();
    }

    @Test
    public void testLogActivity() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        logger.logActivity("Running", 30);
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Activity logged: Running for 30 minutes."));
    }

    @Test
    public void testViewActivities() {
        logger.logActivity("Running", 30);
        logger.logActivity("Swimming", 20);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        logger.viewActivities();
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Logged Activities:"));
        assertTrue(output.contains("- Running: 30 minutes"));
        assertTrue(output.contains("- Swimming: 20 minutes"));
    }

    @Test
    public void testViewActivitiesWhenNoneLogged() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        logger.viewActivities();
        String output = outputStream.toString().trim();
        assertEquals("No activities logged.", output);
    }

    @Test
    public void testCalculateTotalTime() {
        logger.logActivity("Running", 30);
        logger.logActivity("Swimming", 20);
        logger.logActivity("Cycling", 40);
        int totalTime = logger.calculateTotalTime();
        assertEquals(90, totalTime);
    }

    @Test
    public void testCalculateTotalTimeWhenNoneLogged() {
        int totalTime = logger.calculateTotalTime();
        assertEquals(0, totalTime);
    }
}