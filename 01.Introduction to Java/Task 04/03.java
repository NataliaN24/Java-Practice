public class MegaBytes {
    public static int getMegabytes(int kiloBytes)
    {
            return kiloBytes/1024;
    }

    public static void printMegaBytesAndKiloBytes (int kiloBytes)
    {
        if(kiloBytes <0)
        {
            System.out.println("ivalid value");
        }
        else{
            int MegaBytes=getMegabytes(kiloBytes);
            int remaining=kiloBytes % 1024;;
             System.out.println(kiloBytes+ "KB="+ MegaBytes +"MB and "+ remaining+ "KB");
        }
    }
     public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);   // 2500 KB = 2 MB and 452 KB
        printMegaBytesAndKiloBytes(-1024);  // Invalid Value
        printMegaBytesAndKiloBytes(5000);   // 5000 KB = 4 MB and 904 KB
    }
}
