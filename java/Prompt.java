/**
 *	Prompt.java - Uses BufferedReader.
 *	Provides utilities for user input.  This enhances the BufferedReader
 *	class so our programs can recover from "bad" input, and also provides
 *	a way to limit numerical input to a range of values.
 *
 *	The advantages of BufferedReader are speed, synchronization, and piping
 *	data in Linux.
 *
 *	@author	Sooraj Gupta
 *	@since	Date
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Prompt
{
	/**  Variables for reading in the information from the keyboard.   */
    private static InputStreamReader iStream = new InputStreamReader( System.in );
    private static BufferedReader bufReader = new BufferedReader( iStream );
	
	
	/**
	 *	Prompts user for string of characters and returns the string.
	 *	@param ask  The prompt line
	 *	@return  The string input
	 */
	public static String getString (String ask)
	{
        String input = "";
        System.out.print( ask + ": ");
        try
        {
            input = bufReader.readLine();
        }
        catch( IOException e ) 
        {
            System.out.println("ERROR: Improper text input");
        }
		return input;
	}
	
	/**
	 *  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The int entered by the user.
	 */
	public static int getInt ( String ask )
	{
		boolean badInput = false;
        String input = "";
        int value = 0;
        do 
        {
            badInput = false;    
            input = getString(ask);
            try
            {
                value = Integer.parseInt( input );
            }
            catch( NumberFormatException e )
            {
                badInput = true;
            }
        }
        while( badInput );
        return value;
	}
	
	/**
	 *  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.  Also checks
	 *  for input within a given range, and reprompts if outside
	 *  that range.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @param min       The minimum integer value to be allowed as input.
	 *  @param max       The maximum integer value to be allowed as input.
	 *  @return          The int entered by the user.
	 */
	public static int getInt (String ask, int min, int max)
	{
        int value = 0;
        do
        {
            value = getInt( ask + " ( from " + min + " to " + max + " ) ");
        }
        while ( value < min || value > max );
		return value;
	}
	
	
	/**
	 *  Prompts the user and picks up a double.  Checks for
	 *  "bad" input and reprompts if not a double.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The double entered by the user.
	 */
	public static double getDouble (String ask)
	{
        boolean badInput = false;
        String input = "";
        double value = 0.0;
        do 
        {
            badInput = false;    
            input = getString(ask);
            try
            {
                value = Double.parseDouble( input );
            }
            catch( NumberFormatException e )
            {
                badInput = true;
            }
        }
        while( badInput );
        return value;
    }
	
	/**
	 *  Prompts the user and picks up a double.  Checks for
	 *  "bad" input and reprompts if not a double.  Also checks
	 *  for input within a given range, and reprompts if outside
	 *  that range.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @param min       The minimum double value to be allowed as input.
	 *  @param max       The maximum double value to be allowed as input.
	 *  @return          The double entered by the user.
	 */
	public static double getDouble (String ask, double min, double max)
	{
		double value = 0.0;
        do
        {
            value = getDouble( ask + " ( from " + min + " to " + max + " ) ");
        }
        while ( value < min || value > max );
		return value;
	}
	
	/**
	 *  Prompts the user and picks up a char.  Checks for
	 *  "bad" input and reprompts if not a single char.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The char entered by the user.
	 */
	public static char getChar (String ask)
	{
		char c = ' ';
        boolean badInput = false;
        String input = "";
        
        do 
        {
            badInput = false;    
            input = getString(ask);
            
            if( input.length() == 1 )
                c = input.charAt( 0 );
            else
                badInput = true;
            
            if( c == ' ')
            {
                badInput = true;
            }
            
            
            
        }
        while( badInput );
        return c;
    }
	
	/**
	 *  Prompts the user and picks up a char.  Checks for
	 *  "bad" input and reprompts if not a char.  Also checks
	 *  for input from a given array of char, and reprompts if
	 *  input does not belong to this array of possible inputs.
	 *  @param ask         The String prompt to be displayed to the user.
	 *  @param possible    The array containing the list of valid inputs.
	 *  @return            The char entered by the user.
	 */
	public static char getChar (String ask, char [] possible)
	{
        char c = ' ';
        boolean badInput = false;
        do
        {
            c = getChar( ask );
            badInput = !validChar( c, possible );
        }
        while( badInput );
        return c;
	}
	
	/**
	 *  Checks to see if the char value is a member of the char []
	 *  possible.  Returns true if value exists in the array,
	 *  false otherwise.
	 *  @param value       The char to be checked.
	 *  @param possible    The array of char that represents the list of possible "good" input.
	 *  @return            True if good input, false if bad input.
	 */
	private static boolean validChar(char value, char [] possible)
	{
        for ( int i = 0; i < possible.length; i++ )
        {
            if( value == possible[i] )
                return true;
        }
		return false;
	}
}