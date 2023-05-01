
import java.util.*;

public class timetable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of activities: ");
        int numActivities = sc.nextInt();
        
        List<Activity> activities = new ArrayList<>();
        
        for (int i = 1; i <= numActivities; i++) {
            System.out.println("Activity " + i + ":");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Start time (in hours in 24 hours format): ");
            int startTime = sc.nextInt();
            System.out.print("End time (in hours in 24 hours format): ");
            int endTime = sc.nextInt();
            if(startTime > 24 || endTime > 24 || startTime <0 || endTime < 0 || startTime > endTime){
                System.out.println("please enter valid start and end times");
                return;
            
            }
            
            activities.add(new Activity(name, startTime, endTime));
        }
        
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                return a1.endTime - a2.endTime;
            }
        });
        
        int maxActivities = 0;
        int currEndTime = 0;
        for (Activity activity : activities) {
            if (activity.startTime < currEndTime) {
                maxActivities++;
                currEndTime = activity.endTime;
                System.out.println(activity.name);
                System.out.println("Start time: " + activity.startTime + " end time " + activity.endTime);
            }
        }
        
        System.out.println("The maximum number of activities that can be done in a day is " + maxActivities);
    }
}

class Activity {
    public String name;
    public int startTime;
    public int endTime;
    
    public Activity(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        
    }
}