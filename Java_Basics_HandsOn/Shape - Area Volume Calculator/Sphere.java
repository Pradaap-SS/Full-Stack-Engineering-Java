public class Sphere extends Shape implements Spatial
{
    private double radius;
    
    public void setRadius(double radius)
    {
        this.radius=radius;
    }
    public double getRadius()
    {
        return radius;
    }
    public double area()
    {
        double area=4*Math.PI*radius*radius;
        return area;
    }
    public double volume()
    {
        double volume=(double)(4*Math.PI*Math.pow(radius,3))/3;
        return volume;
    }
}