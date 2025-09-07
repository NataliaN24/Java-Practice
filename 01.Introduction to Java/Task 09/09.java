public class CheckerNumber {
public static boolean inRange(int a)
{
    return a >=13 && a <=19;
}

    public static boolean hasTeen(int a, int b, int c)
    {
        return inRange(a) ||inRange(b) ||inRange(c);
    }
    public static void main(String[] args) {
        // Testing hasTeen
        System.out.println(hasTeen(9, 99, 19));   // true
        System.out.println(hasTeen(23, 15, 42));  // true
        System.out.println(hasTeen(22, 23, 34));  // false
    }
}
