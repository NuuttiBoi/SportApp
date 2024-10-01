package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsLogger {
    private List<String> activities;
    private List<Integer> durations;

    public SportsLogger() {
        activities = new ArrayList<>();
        durations = new ArrayList<>();
    }

    public void logActivity(String activityName, int duration) {
        activities.add(activityName);
        durations.add(duration);
        System.out.println("Activity logged: " + activityName + " for " + duration + " minutes.");
    }

    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged.");
        } else {
            System.out.println("Logged Activities:");
            for (int i = 0; i < activities.size(); i++) {
                System.out.println("- " + activities.get(i) + ": " + durations.get(i) + " minutes");
            }
        }
    }

    public int calculateTotalTime() {
        int totalTime = 0;
        for (int duration : durations) {
            totalTime += duration;
        }
        return totalTime;
    }

    // New method to handle the interactive part of the application
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Sports Activity Logger ---");
            System.out.println("1. Log Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Calculate Total Time Spent");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter activity name: ");
                    String activityName = scanner.nextLine();
                    System.out.print("Enter duration in minutes: ");
                    int duration = scanner.nextInt();
                    logActivity(activityName, duration);
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    int totalTime = calculateTotalTime();
                    System.out.println("Total time spent on sports this week: " + totalTime + " minutes");
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close(); // Close scanner when done
    }

    public static void main(String[] args) {
        SportsLogger logger = new SportsLogger();
        logger.run(); // Call the run method to start the interactive console
    }
}