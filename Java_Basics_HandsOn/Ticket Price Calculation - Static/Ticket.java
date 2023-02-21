import java.util.*;
public class Ticket 
{
    private int ticketid;
    private int price;
    private static int availableTickets=0;
    
    public void setTicketid(int tid)
    {
        this.ticketid=tid;
    }
    
    public int getTicketid()
    {
        return ticketid; 
    }
    
    public void setPrice(int p)
    {
       this.price=p;
    }
    
    public int getPrice()
    {
        return price; 
    }
    
    public static void setAvailableTickets(int availableTicket)
    {
        if(availableTicket>0)
        availableTickets=availableTicket;
    }
    
    public static int getAvailableTickets()
    {
        return availableTickets; 
    }
    
    public int calculateTicketCost(int nooftickets)
    {
        if(availableTickets>=nooftickets)
        {
            availableTickets-=nooftickets;
            return (price*nooftickets);
        }
        else
            return -1;
    }
}