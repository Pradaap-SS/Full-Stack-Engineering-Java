import java.util.*;
class Placement
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of students placed in CSE:");
            int cse=sc.nextInt();
        System.out.println("Enter the no of students placed in ECE:");
            int ece=sc.nextInt();
        System.out.println("Enter the no of students placed in MECH:");
            int mech=sc.nextInt();
            
            String sub="";
            int flag=0;
        
        if(cse>=0 && ece>=0 && mech>=0)
        {
           if((cse==0 && ece==0 && mech==0)||(cse==ece && ece==mech))
            System.out.println("None of the department has got the highest placement");
           
           else if(cse>=ece && cse>=mech)
           {
               if(cse>ece && cse==mech)
               sub="CSE"+"\n"+"MECH";
               else if(cse==ece && cse>mech)
               sub="CSE"+"\n"+"ECE";
               else
               sub="CSE";
               
               System.out.println("Highest placement"+"\n"+sub);
           }
           else if(ece>=cse && ece>=mech)
           {
               if(ece>cse && ece==mech)
               sub="ECE"+"\n"+"MECH";
               else if(ece==cse && ece>mech)
               sub="CSE"+"\n"+"ECE";
               else
               sub="ECE";
               
               System.out.println("Highest placement"+"\n"+sub);
           }
           else if(mech>=cse && mech>=ece)
           {
               if(mech>ece && mech==cse)
               sub="CSE"+"\n"+"MECH";
               else if(mech==ece && mech>cse)
               sub="ECE"+"\n"+"MECH";
               else
               sub="MECH";
               
               System.out.println("Highest placement"+"\n"+sub);
           }
        }
        else
        System.out.println("Input is Invalid");
    }
}