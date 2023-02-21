import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Flight flightObj = new Flight(1001, "Delhi", "Mumbai", 10, 2000);
        new FlightManagementSystem().addFlight(flightObj);
    }
}