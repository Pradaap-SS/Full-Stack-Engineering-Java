import java.util.*;
public class Hosteller extends Student
{
    private String hostelName;
    private int roomNumber;
    
    Scanner sc=new Scanner(System.in);
    
    public void setHostelName(String hs)
    {
        this.hostelName=hs;
    }
    public String getHostelName()
    {
        return hostelName;
    }
    
    public void setRoomNumber(int rm)
    {
        this.roomNumber=rm;
    }
    public int getRoomNumber()
    {
        return roomNumber;
    }
}