package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsActivity {
    private String activityName;
    private int duration;
    private List<String> activities;
    private List<Integer> durations;

    public SportsActivity() {
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

    public static void main(String[] args) {
        SportsActivity logger = new SportsActivity();
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
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter activity name: ");
                    String activityName = scanner.nextLine();
                    System.out.print("Enter duration in minutes: ");
                    int duration = scanner.nextInt();
                    logger.logActivity(activityName, duration);
                    break;
                case 2:
                    logger.viewActivities();
                    break;
                case 3:
                    int totalTime = logger.calculateTotalTime();
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

        scanner.close();
    }
}