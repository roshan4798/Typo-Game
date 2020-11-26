package console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class TextExtracter {
		String line,result;
		TextExtracter() throws FileNotFoundException{
		File f = new File("D:\\new.txt");
		Scanner sc = new Scanner(f);
		Random rand = new Random();
		int n =rand.nextInt(100);
	    for(int i=0;i<n;i++)
	    {
	    	line = sc.nextLine();
	    }
	    result = line;         
	    }
		public String getText()
		{
			return result;
		}
	

	}





// create a logic to add random text and conveert it into lines so that it can be used here
//admin page for full control
//make it of full size
//siz should not change
//as person writes the content new line should pop up
