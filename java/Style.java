class Style
{
    public static void decorativePrint( String str, int num )
	{
		int size = str.length() + Utils.getLength( num );
		str = "\n | " + str + " |\n";

		System.out.print(" +");
		for(int i = 0; i < size; i++ )
		{
			System.out.print("-");
		}
		System.out.print("+");

		System.out.printf(str, num);

		System.out.print(" +");
		for(int i = 0; i < size; i++ )
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
    public static void decorativePrint( String str, double num )
	{
		int size = str.length() + Utils.getLength( num );
		str = "\n | " + str + " |\n";

        String newStr = "";
        for( int i = 0; i < str.length(); i++ )
        {
            if( str.charAt(i) == '%' && str.charAt(i+1) == 'f' )
            {
                newStr += num;
                i++;
            }
            else{
                newStr += str.charAt(i);
            }
        }
        str = newStr;

		System.out.print(" +");
		for(int i = 0; i < size; i++ )
		{
			System.out.print("-");
		}
		System.out.print("+");

		System.out.printf(str);

		System.out.print(" +");
		for(int i = 0; i < size; i++ )
		{
			System.out.print("-");
		}
		System.out.println("+");
	}

    public static void decorativePrint( String str )
	{
		int size = str.length() + 2;
		str = "\n | " + str + " |\n";

		System.out.print(" +");
		for(int i = 0; i < size; i++ )
		{
			System.out.print("-");
		}
		System.out.print("+");

		System.out.printf(str);

		System.out.print(" +");
		for(int i = 0; i < size; i++ )
		{
			System.out.print("-");
		}
		System.out.println("+");
	}

    public static void printHeader ( String header, int size, char decoration )
    {
        int realSize = size - header.length() - 2;
        for ( int i = 0; i < realSize/2; i++ )
        {
            System.out.print(decoration);
        }
        System.out.print(" " + header + " ");
        for ( int i = 0; i < realSize/2; i++ )
        {
            System.out.print(decoration);
        }
        System.out.println();
    }

    public static void printHeader ( String header, char decoration )
    {
        int size = header.length() + 10;
        int realSize = size - header.length() - 2;
        for ( int i = 0; i < realSize/2; i++ )
        {
            System.out.print(decoration);
        }
        System.out.print(" " + header + " ");
        for ( int i = 0; i < realSize/2; i++ )
        {
            System.out.print(decoration);
        }
        System.out.println();
    }
}
