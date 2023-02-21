import java.util.*;
public class UserInterface {
    
   public static void main(String args[]) {
        
    // Fill the code here
    
    Scanner sc = new Scanner(System.in);
    
    double commision = 0.0;
    
    // Get the passengers count
    System.out.println("Enter the no of passengers");
    int n = sc.nextInt();
    sc.nextLine();
    
    Ticket[] objectArray = new Ticket[n];
    
    // based on the count get the ticket details like: pnrNo, passengerName, seatNo, classType and ticketFare of each passenger.
    for(int i=0;i<n;i++){
        System.out.println("Details of Passenger "+(i+1)+":");
        System.out.println("Enter the pnr no:");
        long pnrNo = sc.nextLong();
        sc.nextLine();
        
        System.out.println("Enter passenger name:");
        String passengerName = sc.nextLine();
        
        System.out.println("Enter seat no:");
        int seatNo = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter class type:");
        String classType = sc.nextLine();
        
        System.out.println("Enter ticket fare:");
        double ticketFare= sc.nextDouble();
        
        // Create the Ticket object as an array
        Ticket ticket = new Ticket();
        ticket.setPnrNo(pnrNo);
        ticket.setSeatNo(seatNo);
        ticket.setClassType(classType);
        ticket.setTicketFare(ticketFare);
        
        objectArray[i] = ticket;
        
        // Invoke the static method generateCommissionObtained(). 
        // It returns a CommissionInfo object.
        // Capture the CommissionInfo object in a reference variable
        CommissionInfo cObj = UserInterface.generateCommissionObtained();
    
        /* Using the reference of CommissionInfo, 
        invoke the calculateCommissionAmount by passing the Ticket object as a parameter 
        and capture the commission amount which is returned.
        */
        
        commision += cObj.calculateCommissionAmount(ticket);
    
    
        //System.out.println(classType);
        
    }
    
    
    
    
    
    // The output should be displayed as shown in the sample output.
    System.out.println("Commission Obtained");
    System.out.printf("Commission obtained per each person: Rs.%.2f",commision);
    }
    public static CommissionInfo generateCommissionObtained (){
        
        CommissionInfo cObj = (tObj) -> {
            double commission=0.0;
            String classType = tObj.getClassType();
            
            if(classType.equalsIgnoreCase("SL")) {
                commission += 60;
            }
            else if(classType.equalsIgnoreCase("2S")) {
                commission += 60;
            }
            else if(classType.equalsIgnoreCase("1A")){
                commission += 100;
            }
            else if(classType.equalsIgnoreCase("2A")) {
                commission += 100;
            }
            else if(classType.equalsIgnoreCase("3A")) {
                commission += 100;
            }
            else{
                commission +=0;
            }
            return commission;
        };
        
        return cObj;
    }
    
}