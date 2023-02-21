import java.util.*;
public class Main 
{
    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Ticket ob=new Ticket();
        
        System.out.println("Enter no of bookings:");
        int no=sc.nextInt();
        if(no<1)
        {
            System.out.println("Enter the avaiable tickets:");
                int avail_t=sc.nextInt();
                ob.setAvailableTickets(avail_t);
            while(no>0)
            {
               System.out.println("Available tickets:"+ob.getAvailableTickets());
                System.out.println("Enter the ticketid:");
                int tid=sc.nextInt();
               ob.setTicketid(tid);
                
                System.out.println("Enter the price:");
                int p=sc.nextInt();
               ob.setPrice(p);
               
               System.out.println("Enter the no of tickets:");
               int no_of_tickets=sc.nextInt();
               int amount=ob.calculateTicketCost(no_of_tickets);
               
               if(amount!=-1)
                    System.out.println("Total Amount="+amount);
                    
               System.out.println("Avialble ticket after booking:"+ob.getAvailableTickets());
               no--;
            }
        }
    }
}