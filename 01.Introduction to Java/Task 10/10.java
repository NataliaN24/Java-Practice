public class AreaCalc {
    public static final double PI=3.14;

    public static double area(double radius)
    {
        if(radius <0)
        {
            return -1;
        }
        return PI *radius*radius;
    }
    public static double rectangleArea(double x,double y)
    {
        if(x<0 || y<0)
        {
            return -1;
        }
        return x*z;
    }
     public static void main(String[] args) {
        System.out.println("Circle area (radius 5): " + area(5));       // 78.5
        System.out.println("Rectangle area (5, 6): " + rectangleArea(5,6)); // 30
    }
}
