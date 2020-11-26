package console;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filecreator {
	Filecreator() throws IOException{
	File f = new File("D:\\one.txt");
	// convert files with paragraphs into lines
	Scanner sc = new Scanner(f);
	String z = "" ;
	while(sc.hasNextLine())
	{
		String Line = sc.nextLine();
		Line = Line.trim();
		char arr[] = Line.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			z= z+arr[i];
			if(arr[i]=='.')
			{
			 	z=z+"\n";
			}
		}
	}
	FileWriter writer = new FileWriter("D:\\new.txt");
	writer.write(z);
	writer.close();
}
}
