class Utils{
    public static int getLength( int n )
	{
		return (int)( Math.log10( n ) + 1 );
	}
    public static int getLength( double n )
	{
		return Double.toString( n ).length();
	}
}
