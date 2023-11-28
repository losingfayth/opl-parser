package edu.bloomu;

/**
 * Implements a parser with the following syntax:
 * 
 * 	set -> { list }
 * 	list -> head tail | ε
 * 	head -> number | set
 * 	tail -> , head tail | ε
 * 
 * Assumes input has whitespace removed, numbers replaced with 'n'
 * 
 * @author fayth quinn
 */

public class Parser
{

	private String in;

	public Parser() { this.in = new String(); }

	/**
	 * Checks validity of the given input
	 * 
	 * @param s The tokenized string
	 * @return True if the input is valid, False if otherwise
	 */
	public boolean parse(String s)
	{
		this.in = s;
		return (endin(set(0)));
	}

	/**
	 * Checks whether the input has ended
	 * 
	 * @param i The current String index
	 * @return True if the string has terminated, False otherwise
	 */
	private boolean endin(int i) { return !(this.in.length() > i); }

	/**
	 * THIS FUNCTION IS UNUSED
	 * 
	 * Checks validity of a token
	 * 
	 * "token" defined as:
	 * 	',' - Comma
	 * 	'{' - Opening Brace
	 * 	'}' - Closing Brace
	 * 	'n' - Integer
	 * 
	 * @param c The token to be checked
	 * @return True if valid token, False if otherwise
	 */
	private boolean token(char c)
	{
		switch(c)
		{
			case ',':
			case '{':
			case '}':
			case 'n':
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * Checks validity of a set
	 * 
	 * "set" defined as:
	 * 	set -> { list }
	 * 
	 * @param i The current String index
	 * @return The new String index, post processing
	 */
	private int set(int i)
	{
		if (!endin(i))
		{
			if (this.in.charAt(i) == '{')
			{
				int li = list(++i);
				if (!endin(li) && this.in.charAt(list(li)) == '}') return ++li;
			}
		}

		return i;
	}

	/**
	 * Checks validity of a list
	 * 
	 * "list" defined as:
	 * 	list -> head tail | ε
	 * 
	 * @param i The current String index
	 * @return The new String index, post processing
	 */
	private int list(int i)
	{
		if (!endin(i)) return tail(head(i));
		return i;
	}

	/**
	 * Checks validity of a head
	 * 
	 * "head" is defined as:
	 * 	head -> number | set
	 * 
	 * @param i The current String index
	 * @return The new String index, post processing
	 */
	private int head(int i)
	{
		if (!endin(i))
		{
			if (this.in.charAt(i) == 'n') return ++i;
			return set(i);
		}

		return i;
	}

	/**
	 * Checks validity of a tail
	 * 
	 * "tail" is defined as:
	 * 	tail -> , head tail | ε
	 * 
	 * @param i The current String index
	 * @return The new String index, post processing
	 */
	private int tail(int i)
	{
		if (!endin(i))
		{
			if (this.in.charAt(i) == ',') return tail(head(++i));
		}

		return i;
	}

}