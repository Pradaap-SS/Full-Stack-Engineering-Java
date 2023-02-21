public class Cube extends Shape implements Spatial
{
   private double length;
   private double width;
   private double height;
   
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
    public void setHeight(double height)
   {
       this.height=height;
   }
   public double getHeight()
   {
       return height;
   }
   
   public double area()
   {
       double area=(2*length*width)+(2*length*height)+(2*width*height);
       return area;
   }
   public double volume()
   {
       return (length*width*height);
   }
}