import java.util.*;

// Define a City class with a name, x-coordinate, and y-coordinate
class City {
    String name;
    int x, y;

    // Constructor for the City class
    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

public class CityDatabase_array {
    // ArrayList to store the cities
    ArrayList<City> cities;

    // Constructor for the CityDatabase_array class
    public CityDatabase_array() {
        cities = new ArrayList<>();
    }

    // Method to insert a city into the database
    public void insertCity(String name, int x, int y) {
        // Create a new City object with the given name and coordinates
        City city = new City(name, x, y);
        cities.add(city);  // Add the city to the ArrayList
        System.out.println("City " + name + " inserted into the database.");
    }

    // Method to delete a city by name from the database
    public void deleteCityByName(String name) {
        Iterator<City> iterator = cities.iterator();  // Create an iterator to traverse the ArrayList
        // Loop through the ArrayList
        while (iterator.hasNext()) {
            City city = iterator.next();  // Get the next city in the ArrayList
            if (city.name.equals(name)) {
                iterator.remove();  // Remove the city from the ArrayList
                System.out.println("City " + name + " deleted from the database.");
                return;
            }
        }
        System.out.println("City " + name + " not found in the database.");
    }

    // Method to delete a city by coordinate from the database
    public void deleteCityByCoordinate(int x, int y) {
        Iterator<City> iterator = cities.iterator();  // Create an iterator to traverse the ArrayList
        while (iterator.hasNext()) {
            City city = iterator.next();
            // If the city's coordinates match the given coordinates, remove it from the list and return
            if (city.x == x && city.y == y) {
                iterator.remove();  // Remove the city from the ArrayList
                System.out.println("City at coordinate (" + x + "," + y + ") deleted from the database.");
                return;
            }
        }
        System.out.println("City at coordinate (" + x + "," + y + ") not found in the database.");
    }

    // Method to Search a city by name from the database
    public void searchCityByName(String name) {
        for (City city : cities) {        // Loop through each city in the list
            if (city.name.equals(name)) {
                System.out.println("City " + name + " found at coordinate (" + city.x + "," + city.y + ").");
                return;
            }
        }
        System.out.println("City " + name + " not found in the database.");
    }

    // Method to search a city by coordinate from the database
    public void searchCityByCoordinate(int x, int y) {
        for (City city : cities) {       // Loop through each city in the list
            if (city.x == x && city.y == y) {
                System.out.println("City at coordinate (" + x + "," + y + ") is " + city.name + ".");
                return;
            }
        }
        System.out.println("City at coordinate (" + x + "," + y + ") not found in the database.");
    }

    // Method to Print cities details by coordinates and distance from the database
    public void printCitiesWithinDistance(int x, int y, int distance) {
        for (City city : cities) {
            // Calculate the distance between the given point and the current city
            int dx = city.x - x;
            int dy = city.y - y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist <= distance) {
                System.out.println(city.name + " at (" + city.x + "," + city.y + "), distance = " + dist + ".");
            }
        }
    }

    public void printall(){
        for (City city : cities) {
            System.out.println(city.name + " at (" + city.x + "," + city.y + ")");
        }
    }
    public static void main(String[] args) {
        CityDatabase_array database = new CityDatabase_array();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean t=true;
        while (t) {
            System.out.println("Enter your choice:");
            System.out.println("1. Insert a city");
            System.out.println("2. Delete a city by name");
            System.out.println("3. Delete a city by coordinate");
            System.out.println("4. Search a city by name");
            System.out.println("5. Search a city by coordinate");
            System.out.println("6. Print all cities within a given distance of a point");
            System.out.println("7. Print all records");
            System.out.println("8. Quit");
    
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the city:");
                    String name = sc.nextLine();
                    System.out.println("Enter the x-coordinate of the city:");
                    int x = sc.nextInt();
                    System.out.println("Enter the y-coordinate of the city:");
                    int y = sc.nextInt();
                    sc.nextLine();
                    database.insertCity(name, x, y);
                    break;
                case 2:
                    System.out.println("Enter the name of the city to be deleted:");
                    name = sc.nextLine();
                    database.deleteCityByName(name);
                    break;
                case 3:
                    System.out.println("Enter the x-coordinate of the city to be deleted:");
                    x = sc.nextInt();
                    System.out.println("Enter the y-coordinate of the city to be deleted:");
                    y = sc.nextInt();
                    sc.nextLine();
                    database.deleteCityByCoordinate(x, y);
                    break;
                case 4:
                    System.out.println("Enter the name of the city to be searched:");
                    name = sc.nextLine();
                    database.searchCityByName(name);
                    break;
                case 5:
                    System.out.println("Enter the x-coordinate of the city to be searched:");
                    x = sc.nextInt();
                    System.out.println("Enter the y-coordinate of the city to be searched:");
                    y = sc.nextInt();
                    sc.nextLine();
                    database.searchCityByCoordinate(x, y);
                    break;
                case 6:
                    System.out.println("Enter the x-coordinate of the point:");
                    x = sc.nextInt();
                    System.out.println("Enter the y-coordinate of the point:");
                    y = sc.nextInt();
                    System.out.println("Enter the maximum distance:");
                    int distance = sc.nextInt();
                    sc.nextLine();
                    database.printCitiesWithinDistance(x, y, distance);
                    break;
                case 7:
                    database.printall();
                    break;
                case 8:
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
