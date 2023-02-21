import java.util.*;
class Main
{
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of liters to fill the tank");
        int liter=sc.nextInt();
        if(liter<=0)
             System.out.println(liter+" is an Invalid Input");
        else
        {
        System.out.println("Enter the distance covered");
            int distance=sc.nextInt();
        if(distance<=0)
                System.out.println(distance+" is an Invalid Input");
        else
        {
        float litres_km=((float)liter/distance)*100;
        
        double miles=(distance*0.6214);
        double gallons=(liter*0.2642);
        float miles_gallon=(float)(miles/gallons);
        
        System.out.printf("Liters/100KM\n%.2f\n",litres_km);
        System.out.printf("Miles/gallons\n%.2f",miles_gallon);
        }
        }
    }
}