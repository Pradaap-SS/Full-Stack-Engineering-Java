import java.util.*;
class Authority
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Inmate's name:");
        String name=sc.nextLine();
        System.out.println("Inmate's father's name:");
        String father_name= sc.nextLine();
        
        int v1=validate(name);
        int v2=validate(father_name);
        
        if(v1==0 && v2==0)
        {
            name=name.toUpperCase();
            father_name=father_name.toUpperCase();
            name=name.concat(" ");
            name=name.concat(father_name);
            System.out.println(name);
        }
        else
        System.out.println("Invalid name");
        
    }
    public static int validate(String s)
    {
        int flag=0;
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            char ch=s.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || ch==' ')
               flag=0;
            else{
                flag=1;
                break;
            }
        }
        return flag;
    }
}