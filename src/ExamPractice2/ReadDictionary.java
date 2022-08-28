package ExamPractice2;

import java.io.File;
import java.util.Scanner;

public class ReadDictionary {

	/*
	 a) Created a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. 
	 Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception. 
	 b) Read each word and its possible meanings and print them out.
	 */
	
	static String path="data/DictionaryText.txt";
	static File f = new File(path); // Get the file
	
	public static void main(String[] args) {

		try {
			doesFileExist(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		printDictionary();
		
	}

	/*** Method doesFileExist will print if file exists or not***/
	public static void doesFileExist(String path) {

		// Check if the specified file exists or not
		try {
			if (f.exists()) {
				System.out.println("File Exists!");
				System.out.println();
			} else {
				System.out.println("File Does not Exist!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of doesFileExist method
	
	
	/*** This method will print words and their meanings***/
	public static void printDictionary() {
	
		try {
			Scanner sc = new Scanner(f);
			String line;
			int i = 1;

			while (sc.hasNextLine()) {
				line = sc.nextLine();

				String[] splitLine = line.split("-");
				String[] meaning = splitLine[1].split(",");
				System.out.println("Word" + i + ": " + splitLine[0].trim());
				i++;

				for (int j = 0; j < meaning.length; j++) {
					System.out.println("Meaning" + (j + 1) + ": " + meaning[j].trim());
				}

				System.out.println();
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}// end of print dictionary method

}
