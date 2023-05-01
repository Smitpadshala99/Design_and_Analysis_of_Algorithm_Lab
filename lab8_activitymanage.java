import java.util.Scanner;
import java.util.*;

class Activity {
    public int st;
    public int et;
    public String Activity_Name;

    public Activity() {
        this.Activity_Name = Activity_Name;
        this.st = st;
        this.et = et;
    }

    @Override
    public String toString() {
        return "[ Activity_Name: " + Activity_Name +", Start: " + st + ", End: " + et + "]";
    }

}

public class lab8_activitymanage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfActivity = 0;
        System.out.println("Enter The Number of Activity");
        numberOfActivity = sc.nextInt();

        ArrayList<Activity> Schedule = new ArrayList<Activity>();

        for (int i = 0; i < numberOfActivity; i++) {
            Activity a = new Activity();

            System.out.println("Enter the Activity Name : ");
            sc.nextLine();
            a.Activity_Name = sc.nextLine();

            System.out.println("Enter the Start Time : ");
            a.st = sc.nextInt();

            System.out.println("Enter the End Time : ");
            a.et = sc.nextInt();
            if (a.et < a.st) {
                System.out.println("Enter correct number!!! ");
                return;
            }
            Schedule.add(a);
        }

        Schedule.sort(new Comparator<Activity>() {
            // compares Activity
            public int compare(Activity a1, Activity a2) {
                return a1.et - a2.et;
            }
        });

        ArrayList<Activity> TimeTable = new ArrayList<Activity>();
        int lastActivity = 0;
        for (Activity a : Schedule) {
            if (lastActivity <= a.st) {
                TimeTable.add(a);
                lastActivity = a.et;
            }
        }

        System.out.println("Maximum number of activity can arrange is "+TimeTable.size());
        for (Activity a : TimeTable) {
            System.out.println(a);
        }
    }
}