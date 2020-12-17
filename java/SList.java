public class SList<T>
{
    private T[] t;

    public SList( Object... args )
    {
        t = (T[]) args;
    }

    public String toString()
    {
        if( t.length > 0 )
        {
            String s = "" + t[0];
            for( T i : t )
            {
                s += " " + i;
            }
            return s;
        }
        return "";
    }
}
