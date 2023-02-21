public class Rectangle extends Shape
{
   private double length;
   private double width;
   
   public void setLength(double length)
   {
       this.length=length;
   }
   public double getLength()
   {
       return length;
   }
   
   public void setWidth(double width)
   {
       this.width=width;
   }
   public double getWidth()
   {
       return width;
   }
   
   public double area()
   {
       double area=length*width;
       return area;
   }
   public double volume()
   {
       return -1;
   }
}
