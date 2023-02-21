import java.util.*;
class IncrementCalculation
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the salary");
        double salary=sc.nextInt();
        System.out.println("Enter the Performance appraisal rating");
        double rating=sc.nextDouble();
        int incremented_salary=0,increment=0;
        
        if(salary<=0 || rating<1 || rating>5)
            System.out.println("Invalid Input");
        else
        {
            if(rating>=1 && rating<=3)
                increment=10;
            else if(rating>3 && rating<=4)
                increment=25;
            else if(rating>4 && rating<=5)
                increment=30;
            
            float a=(float)increment/100;
            int increase=(int)(a*salary);
            incremented_salary=(int)salary+increase; 
            System.out.println(incremented_salary);
        }
    }
}