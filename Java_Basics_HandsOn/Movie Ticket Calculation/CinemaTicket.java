import java.util.*;
class CinemaTicket
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of ticket:");
            int ticket_no=sc.nextInt();
            
        if(ticket_no<5 || ticket_no>40)
        System.out.println("Minimum of 5 and Maximum of 40 Tickets");
        else
        {
        System.out.println("Do you want refreshment:");
            char refreshment=sc.next().charAt(0);
        System.out.println("Do you have coupon code:");
            char coupon=sc.next().charAt(0);
        System.out.println("Enter the circle:");
            char circle=sc.next().charAt(0);
        
        float price=0;
        
        if(circle=='k' || circle=='q')
        {
            switch(circle)
            {
                case 'k':
                    price=75;
                    break;
                case 'q':
                    price=150;
                    break;
            }
            
            //System.out.println(price); 
            
            float cost=(float)ticket_no*price;
            
            float refreshment_price=0,ticket_discount=0,coupon_discount=0;
            
            if(refreshment=='y')
                refreshment_price=(float)50*ticket_no;
            //System.out.println(refreshment_price);
            
            if(ticket_no>=20){
                ticket_discount=(float)10/100*cost;
                cost-=ticket_discount;
            }
            //System.out.println(ticket_discount);
            
            if(coupon=='y')
            {
                coupon_discount=(float)2/100*cost; 
                cost-=coupon_discount;
            }
            //System.out.println(coupon_discount);
            
            float total_cost= cost+refreshment_price;
            System.out.printf("Ticket cost: %.2f",total_cost);
        }
        else
            System.out.println("Invalid Input");
        }
    }
}