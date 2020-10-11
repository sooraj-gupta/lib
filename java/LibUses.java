class LibUses
{
    public static void main(String[] args) {

        System.out.println("\n");

        Style.printHeader( "Style", 40, '-' );
        decorativePrint();

        Style.printHeader( "Dice", 40, '-' );
        dice();

        Style.printHeader( "Prompt", 40, '-' );
        prompt();
    }


    public static void decorativePrint()
    {
        System.out.println("\n");
        Style.decorativePrint( "Example Text");

        int exampleNum1 = 1234;
        Style.decorativePrint( "Example Number 1 is %d", exampleNum1 );

        int exampleNum2 = 1231234;
        Style.decorativePrint( "Example Number 2 is %d", exampleNum2 );

        System.out.println("\n\n");

    }

    public static void dice()
    {
        System.out.println("\n");
        Dice dice = new Dice();
        for (int i = 1; i < 5; i++ )
        {
            Style.decorativePrint( "Roll " + i +": %d", dice.roll() );
        }
        Style.decorativePrint( "Number of rolls: %d", dice.getRollCount() );
        System.out.println("\n\n");
    }

    public static void prompt()
    {
        System.out.println("\n");
        int int1 = Prompt.getInt( "Enter an Int" );
        int int2 = Prompt.getInt( "Enter an Int", 200, 5000 );
        double double1 = Prompt.getDouble( "Enter a double" );
        double double2 = Prompt.getDouble( "Enter a double", 203.4, 5823.45 );
        System.out.println();
        Style.decorativePrint( "Integer 1: %d", int1 );
        Style.decorativePrint( "Integer 2: %d", int2 );
        Style.decorativePrint( "Double 1: %f", double1 );
        Style.decorativePrint( "Double 2: %f", double2 );
    }

}
