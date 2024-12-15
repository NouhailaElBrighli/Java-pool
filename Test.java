public class Test  {
    static int statvar = 13;
    
    {
        System.out.println("hey inilializer->" + statvar);
    }

    // static {
    //     statvar = 15;
    //     System.out.println("statvar->" + statvar);
    // }
    // ======>
    public static void main(String[] args) {
        String myStr1 = "Hello";
        String myStr2 = "Hello";
        System.out.println(myStr1.compareTo(myStr2));
    }
}