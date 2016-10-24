import java.util.*;
import java.io.*;
public class Writingdata extends FileWriter
{
	private Map<Character,Character> dictionary=new HashMap<Character,Character>();
	Writingdata(String st) throws Exception
	{
		super(st);
	}
	public void write(String st)
	{
		try{
		int i=0;
		dic();
		while(i<st.length())
		{
			super.write(dictionary.get(st.charAt(i)));
			++i;
		}
		}
		catch(Exception e){}
	}
	private void dic()
	{
			dictionary.put('a', 'm');
			dictionary.put('b', 'y');
			dictionary.put('y', 'b');
			dictionary.put('c', 'o');
			dictionary.put('o', 'c');
			dictionary.put('d', 'n');
			dictionary.put('n','d');
			dictionary.put('e', 'x');
			dictionary.put('x', 'e');
			dictionary.put('f', 'k');
			dictionary.put('k', 'f');
			dictionary.put('g', 't');
			dictionary.put('t', 'g');
			dictionary.put('h', 'i');
			dictionary.put('i', 'h');
			dictionary.put('j', 's');
			dictionary.put('s', 'j');
			dictionary.put('l', 'z');
			dictionary.put('z', 'l');
			dictionary.put('p', 'u');
			dictionary.put('u', 'p');
			dictionary.put('q', 'r');
			dictionary.put('r', 'q');
			dictionary.put('v', 'w');
			dictionary.put('w', 'v');
			dictionary.put('m', 'a');
			
			dictionary.put('A', 'M');
			dictionary.put('B', 'Y');
			dictionary.put('Y', 'B');
			dictionary.put('C', 'O');
			dictionary.put('O', 'C');
			dictionary.put('D', 'N');
			dictionary.put('N', 'D');
			dictionary.put('E', 'X');
			dictionary.put('X', 'E');
			dictionary.put('F', 'K');
			dictionary.put('K', 'F');
			dictionary.put('G', 'T');
			dictionary.put('T', 'G');
			dictionary.put('H', 'I');
			dictionary.put('I', 'H');
			dictionary.put('J', 'S');
			dictionary.put('S', 'J');
			dictionary.put('L', 'Z');
			dictionary.put('Z', 'L');
			dictionary.put('P', 'U');
			dictionary.put('U', 'P');
			dictionary.put('Q', 'R');
			dictionary.put('R', 'Q');
			dictionary.put('V', 'W');
			dictionary.put('W', 'V');
			dictionary.put('M', 'A');
			
			dictionary.put('1', '#');
			dictionary.put('2', '@');
			dictionary.put('3', '&');
			dictionary.put('4', '!');
			dictionary.put('5', '^');
			dictionary.put('6', '$');
			dictionary.put('7', '(');
			dictionary.put('8', '?');
			dictionary.put('9', '|');
			dictionary.put('0', '*');
			
			dictionary.put('#', '1');
			dictionary.put('@', '2');
			dictionary.put('&', '3');
			dictionary.put('!', '4');
			dictionary.put('^', '5');
			dictionary.put('$', '6');
			dictionary.put('(', '7');
			dictionary.put('?', '8');
			dictionary.put('|', '9');
			dictionary.put('*', '0');
			
			dictionary.put(',', '~');
			dictionary.put('~', ',');
			
			dictionary.put(' ', '+');
			dictionary.put('+', ' ');
			
			dictionary.put('.', '_');
			dictionary.put('_', '.');
			dictionary.put(':', '`');
			dictionary.put('`', ':');
			
			dictionary.put('\n', ')');
			dictionary.put(')', '\n');
	}
}
