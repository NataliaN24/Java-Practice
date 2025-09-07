public class checkNumber {
    
    public static void checkNum(int number)
    {
        if(number > 0)
        {
            System.out.println("positive"); 
        }
        else if(number <0)
        {
            System.out.println("negative"); 
        }
        else
        {
            System.out.println("zero"); 
        }
    }
    public static void main(String[]args)
    {
        checkNum(10);
        checkNum(-5);
        checkNum(0);
    }
}
