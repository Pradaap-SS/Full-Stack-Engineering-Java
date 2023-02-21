import java.util.*;
class AsciValue{
    public static void main(String args[]){
    
    Scanner sc=new Scanner(System.in);
    int n[]=new int[4];
    char a[]=new char[4];
    System.out.println("Enter the digits:");
    for(int i=0;i<4;i++)
    n[i]=sc.nextInt();
    
    for(int i=0;i<4;i++)
    {
    //if((n[i]>=65 && n[i]<=90) || (n[i]>=97 && n[i]<=122))
    a[i]=(char)n[i];
    }
    for(int i=0;i<4;i++)
    System.out.println(n[i]+"-"+a[i]);
}
}