import java.util.Scanner;
import java.util.*;

// define the Activity class
class Activity {
    public int st;
    public int et;
    public String Activity_Name;

    // constructor for Activity class
    public Activity(String Activity_Name, int st, int et) {
        this.Activity_Name = Activity_Name;
        this.st = st;
        this.et = et;
    }

    @Override
    public String toString() {
        return "Activity_Name: " + Activity_Name +" \tStart: " + st + "\tEnd: " + et + " \tduration: " + (st-et);
    }

}

public class activitymanage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // define the number of activities variable and initialize with 0
        int numberOfActivity = 0;
        System.out.println("Enter the number of activities:");
        numberOfActivity = sc.nextInt();
        
        // create an ArrayList to store the activities schedule
        ArrayList<Activity> Schedule = new ArrayList<Activity>();

         // loop to get activity details from user
        for (int i = 0; i < numberOfActivity; i++) {
            System.out.println("Enter the activity name:");
            sc.nextLine();
            String activityName = sc.nextLine(); // read activity name from user

            System.out.println("Enter the start time:");
            int st = sc.nextInt(); // read start time from user
            if(st>24){
                System.out.println("Start time should be less then 24hr. \nRun Again!");
                return;
            }

            System.out.println("Enter the end time:");
            int et = sc.nextInt(); // read end time from user
            if(et>24){
                System.out.println("End time should be less then 24hr. \nRun Again!");
                return;
            }

            // check if end time is less than start time, then it is invalid input
            if (et < st) {
                System.out.println("Invalid input. End time should be greater than or equal to start time.");
                return;
            }

            // create an activity object and add it to the Schedule list
            Activity a = new Activity(activityName, st, et);
            Schedule.add(a);
        }

        // sort the activities based on end time
        Schedule.sort(new Comparator<Activity>() {
            // compares Activity
            public int compare(Activity a1, Activity a2) {
                return a1.et - a2.et;
            }
        });

        // create an ArrayList to store the final timetable
        ArrayList<Activity> TimeTable = new ArrayList<Activity>();
        int lastActivity = 0; // initialize last activity with 0
        for (Activity a : Schedule) { // loop through the activities schedule to create timetable
            if (lastActivity <= a.st) { // check if the current activity can be scheduled after the last activity
                TimeTable.add(a);
                lastActivity = a.et; // update the last activity with the current activity
            }
        }

        System.out.println("Maximum number of activity can arrange is "+TimeTable.size());
        // print the details of the activities in the timetable
        for (Activity a : TimeTable) {
            System.out.println(a);
        }
    }
}


