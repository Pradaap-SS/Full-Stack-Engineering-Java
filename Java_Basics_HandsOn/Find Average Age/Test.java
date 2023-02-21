import java.util.*;
class Test
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total no.of employees:");
        int n=sc.nextInt();
        
        if(n<2)
        System.out.println("Please enter a valid employee count:");
        
        else
        {
        System.out.println("Enter the age for "+n+" employees:");
          int age[]=new int[n];
          int flag=0,j=0;
           while(sc.hasNextInt())
           {
               int a=sc.nextInt();

                if(a<28 || a>40)
                {
                    System.out.println("Invalid age encountered!");
                    flag=1;
                    break;
                }
               else
                {
                   age[j]=a;
                   j++;
                }
            }
            if(flag==0)
            {
            float average_age=calculateAverage(age);
            System.out.printf("The average age is %.2f",average_age);
            }
        }
    }
    
    public static float calculateAverage(int[] age)
    {
        float avg=0,sum=0;
        int no=age.length;
        for(int i=0;i<no;i++)
            sum+=age[i];

        avg=(float)sum/no;
        return avg;
    }
}