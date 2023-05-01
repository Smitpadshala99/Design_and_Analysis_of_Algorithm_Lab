
import java.util.*;

class City {
    String name;
    int x, y;
    
    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

class CityDatabase {
    ArrayList<City> cities;
    
    public CityDatabase() {
        cities = new ArrayList<>();
    }
    
    public void insert(String name, int x, int y) {
        cities.add(new City(name, x, y));
    }
    
    public void deleteByName(String name) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).name.equals(name)) {
                cities.remove(i);
                break;
            }
        }
    }
    
    public void deleteByCoordinates(int x, int y) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).x == x && cities.get(i).y == y) {
                cities.remove(i);
                break;
            }
        }
    }
    
    public void printByName(String a) {
        // cities.sort((c1, c2) -> c1.name.compareTo(c2.name));
        // String a = name;
        for (City city : cities) {
            if(a.equalsIgnoreCase(city.name)){
                System.out.println(city.name + " (" + city.x + ", " + city.y + ")");
        
            }
        }
    }
    
    public void printByCoordinates(int x, int y) {
        // cities.sort((c1, c2) -> {
        //     if (c1.x != c2.x) {
        //         return Integer.compare(c1.x, c2.x);
        //     } else {
        //         return Integer.compare(c1.y, c2.y);
        //     }
        // });
        for (City city : cities) {
            if(x == city.x && y == city.y){
            System.out.println(city.name + " (" + city.x + ", " + city.y + ")");
            }
        }
    }
    
    public void printWithinDistance(int x, int y, double distance) {
        for (City city : cities) {
            double d = Math.sqrt(Math.pow(city.x - x, 2) + Math.pow(city.y - y, 2));
            if (d <= distance) {
                System.out.println(city.name + " (" + city.x + ", " + city.y + ")");
            }
        }
    }
}

class citifactory{
    CityDatabase db = new CityDatabase();
    Scanner sc = new Scanner(System.in);
    public void citifactory(int i){
        switch (i){
            case 1:
            System.out.println("Please enter the name the x and y cordinates of the city");
            db.insert(sc.nextLine(), sc.nextInt(), sc.nextInt());
            break;
            case 2:
            System.out.println("Enter the name of the city you want to find");
            db.printByName(sc.next());
            break;
            case 3:
            System.out.println("Enter the x and y cordinates of the city");
            db.printByCoordinates(sc.nextInt(),sc.nextInt());
            break;
            case 4:
            System.out.println("Enter the x and y cordinates of the point from which where you want to search");
            System.out.println("Enter the distance");
            db.printWithinDistance(sc.nextInt(), sc.nextInt(), sc.nextDouble());
            break;
            case 5:
            System.out.println("Enter the name of the city you want to delete");
            db.deleteByName(sc.next());
            break;
            case 6:
            System.out.println("Enter the cordinates of the city you want to delete");
            db.deleteByCoordinates(sc.nextInt(), sc.nextInt());
            break;
            case 7:
            break;
            default:
            System.out.println("Please enter a valid case");
        }
    }
}
//number of lines
public class citidatabasemain2 {
    public static void main(String[] args) {
        citifactory cf = new citifactory();
        Scanner sc = new Scanner(System.in);
        
        // insert records
        int choice;
        while(true){ 
            System.out.println("Enter 1 to insert a city, 2 to print by name, 3 to print by cordinates, 4 to print within distance, 5 to delete by name, 6 to delete by cordinates and 7 to exit");
            choice = sc.nextInt();
            if(choice==7) return;
             cf.citifactory(choice);
        }
    }
}
