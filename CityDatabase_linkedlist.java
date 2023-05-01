import java.util.Scanner;

// City class represents each city with a name and its x and y coordinates
class City {
    String name;
    int x, y;
    City next; // reference to the next city in the linked list
    
    // Constructor to create a new city object
    
    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.next = null;
    }
    
    public void print() {
        System.out.println("City name: " + name + ", x: " + x + ", y: " + y);
    }
}

class CityDatabase {
    City head; // reference to the first city in the linked list
    
    // Constructor to create an empty database
    public CityDatabase() {
        head = null;
    }
    
    // Function to insert a new city into the database
    public void insert(String name, int x, int y) {
        City newCity = new City(name, x, y);
        if (head == null) {
            head = newCity;
        } else {
            City current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newCity;
        }
        System.out.println(name + " has been added to the database.");
    }
    
    // Function to delete a city from the database by name
    public void delete(String key) {
        if (head == null) {
            System.out.println("Database is empty.");
            return;
        }
        if (head.name.equals(key)) {
            head = head.next;
            System.out.println(key + " has been deleted from the database.");
            return;
        }
        City current = head;
        while (current.next != null) {
            if (current.next.name.equals(key)) {
                current.next = current.next.next;
                System.out.println(key + " has been deleted from the database.");
                return;
            }
            current = current.next;
        }
        System.out.println(key + " not found in the database.");
    }
    
     // Function to delete a city from the database by coordinates
    public void delete(int x, int y) {
        if (head == null) {
            System.out.println("Database is empty.");
            return;
        }
        if (head.x == x && head.y == y) {
            head = head.next;
            System.out.println("City at (" + x + ", " + y + ") has been deleted from the database.");
            return;
        }
        City current = head;
        while (current.next != null) {
            if (current.next.x == x && current.next.y == y) {
                current.next = current.next.next;
                System.out.println("City at (" + x + ", " + y + ") has been deleted from the database.");
                return;
            }
            current = current.next;
        }
        System.out.println("City at (" + x + ", " + y + ") not found in the database.");
    }

    // Function to search for a city by name
    public void search(String key) {
        if (head == null) {
            System.out.println("Database is empty.");
            return;
        }
        City current = head;
        while (current != null) {
            if (current.name.equals(key)) {
                System.out.println("City found:");
                current.print();
                return;
            }
            current = current.next;
        }
        System.out.println(key + " not found in the database.");
    }
    
    // Function to search a city from the database by coordinates
    public void search(int x, int y) {
        if (head == null) {
            System.out.println("Database is empty.");
            return;
        }
        City current = head;
        while (current != null) {
            if (current.x == x && current.y == y) {
                System.out.println("City found:");
                current.print();
                return;
            }
            current = current.next;
        }
        System.out.println("City at (" + x + ", " + y + ") not found in the database.");
    }
    
    public void printWithinDistance(int x, int y, int distance) {
        if (head == null) {
            System.out.println("Database is empty.");
            return;
        }
        System.out.println("Cities within a distance of " + distance + " from (" + x + ", " + y + "):");
        City current = head;
        while (current != null) {
                int dx = current.x - x;
                int dy = current.y - y;
                double dist = Math.sqrt(dx*dx + dy*dy);
            if (dist <= distance) {
                current.print();
            }
            current = current.next;
        }
    }
    
    public void printAll() {
        if (head == null) {
            System.out.println("Database is empty.");
            return;
        }
        System.out.println("All cities in the database:");
        City current = head;
        while (current != null) {
            current.print();
            current = current.next;
        }
    }
}


public class CityDatabase_linkedlist {
    public static void main(String[] args) {
    CityDatabase database = new CityDatabase();
    Scanner sc = new Scanner(System.in);
    String choice;
    boolean t=true;
    while (t){
        System.out.println("Enter your choice:");
        System.out.println("1. Insert a record");
        System.out.println("2. Delete a record by name");
        System.out.println("3. Delete a record by coordinate");
        System.out.println("4. Search a record by name");
        System.out.println("5. Search a record by coordinate");
        System.out.println("6. Print all records within a given distance of a specified point");
        System.out.println("7. Print all records");
        System.out.println("8. Quit");
        choice = sc.nextLine();
        switch (choice) {
            case "1":
            System.out.println("Enter city name:");
            String name = sc.nextLine();
            System.out.println("Enter x coordinate:");
            int x = sc.nextInt();
            System.out.println("Enter y coordinate:");
            int y = sc.nextInt();
            sc.nextLine(); // consume extra newline
            database.insert(name, x, y);
            break;
            case "2":
            System.out.println("Enter city name to delete:");
            name = sc.nextLine();
            database.delete(name);
            break;
            case "3":
            System.out.println("Enter x coordinate to delete:");
            x = sc.nextInt();
            System.out.println("Enter y coordinate to delete:");
            y = sc.nextInt();
            sc.nextLine(); // consume extra newline
            database.delete(x, y);
            break;
            case "4":
            System.out.println("Enter city name to search:");
            name = sc.nextLine();
            database.search(name);
            break;
            case "5":
            System.out.println("Enter x coordinate to search:");
            x = sc.nextInt();
            System.out.println("Enter y coordinate to search:");
            y = sc.nextInt();
            sc.nextLine(); // consume extra newline
            database.search(x, y);
            break;
            case "6":
            System.out.println("Enter x coordinate:");
            x = sc.nextInt();
            System.out.println("Enter y coordinate:");
            y = sc.nextInt();
            System.out.println("Enter distance:");
            int distance = sc.nextInt();
            sc.nextLine(); // consume extra newline
            database.printWithinDistance(x, y, distance);
            break;
            case "7":
            database.printAll();
            break;
            case "8":
            System.out.println("Goodbye!");
            t=false;
            break;
            default:
            System.out.println("Invalid choice.");
            break;
        }
    } 
    }
}
    