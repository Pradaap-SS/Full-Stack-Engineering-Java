import java.util.*;
public class Main
{
    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
        Shape[] sh = new Shape[5];
        String input;
        
        for(int i=0;i<5;i++){
            input=sc.next();
            if(input.equals("Triangle")){
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                sh[i]= new Triangle();
                ((Triangle)sh[i]).setBase(base);
                ((Triangle)sh[i]).setHeight(height);
                
            }
            else if(input.equals("Cube")){
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                double height = sc.nextDouble();
                sh[i]= new Cube();
                ((Cube)sh[i]).setLength(length);
                ((Cube)sh[i]).setHeight(height);
                ((Cube)sh[i]).setWidth(width);
                

            }
            else if(input.equals("Rectangle")){
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                sh[i]= new Rectangle();
                ((Rectangle)sh[i]).setLength(length);
                ((Rectangle)sh[i]).setWidth(width);
            }
            else if(input.equals("Sphere")){
                double radius = sc.nextDouble();
                sh[i]= new Sphere();
                ((Sphere)sh[i]).setRadius(radius);
                
            }
        }
        for(Shape s:sh){
            System.out.println("Area "+s.area());
            if(s instanceof Spatial){
                System.out.println("Volume "+s.volume());
            }
        }
    }
}