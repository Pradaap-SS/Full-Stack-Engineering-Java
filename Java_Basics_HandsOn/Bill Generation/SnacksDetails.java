import java.util.*;
class SnacksDetails
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of pizzas bought:");
        int pizza=sc.nextInt();
        System.out.println("Enter the no of puffs bought:");
        int puff=sc.nextInt();
        System.out.println("Enter the no of cool drinks bought:");
        int drinks=sc.nextInt();
        
        int cost_pizza=pizza*100;
        int cost_puff=puff*20;
        int cost_drinks=drinks*10;
        int total_price=cost_pizza+cost_puff+cost_drinks;
        
        //int total_price=(pizza*100)+(puff*20)+(drinks*10);
        
        
        System.out.println("Bill details");
         System.out.println("No of pizzas:"+pizza);
          System.out.println("No of puffs:"+puff);
           System.out.println("No of cooldrinks:"+drinks);
            System.out.println("Total price="+total_price);
             System.out.println("ENJOY THE SHOW");
    }
}