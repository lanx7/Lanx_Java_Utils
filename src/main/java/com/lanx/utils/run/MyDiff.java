package com.lanx.utils.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MyDiff {

	public static void main(String[] args) {
		System.out.println("MyDiff");
		String inputFolderName1 = "D:/data/result_0415_v4/voc_160331_opensns";
		String inputFolderName2 = "D:/data/result_0415_v4/voc_160331_short_v4";
		String outputFolderName = "D:/data/result";

		File outputFolder = new File(outputFolderName);
		if(!outputFolder.exists()) {    //  .
			outputFolder.mkdirs();
		}

		File folder = new File(inputFolderName1);	
		List<String> files = listFilesForFolder(folder);

		FileWriter fw; 
        BufferedWriter bw = null;
		String outFileName = outputFolderName + "/" + "v4_diff.txt"; 

		try {
			fw = new FileWriter(outFileName);
			bw = new BufferedWriter(fw);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for(String file: files){
			
			 /* Pause() */ 
			 //   Scanner reader = new Scanner(System.in);
			 //   char c = reader.next().charAt(0);
			    
			String line1;
			String line2;

			String fName1 = inputFolderName1 + "/" + file;
			String fName2 = inputFolderName2 + "/" + file;
			
			InputStream fis1;
			InputStreamReader isr1;
			BufferedReader br1 = null; 

			InputStream fis2;
			InputStreamReader isr2;
			BufferedReader br2 = null; 

            
        	try {
				
				fis1 = new FileInputStream(fName1);
				isr1 = new InputStreamReader(fis1, Charset.forName("UTF-8"));
				br1 = new BufferedReader(isr1);
				
				fis2 = new FileInputStream(fName2);
				isr2 = new InputStreamReader(fis2, Charset.forName("UTF-8"));
				br2 = new BufferedReader(isr2);

				//System.out.println(file);
				bw.write(file);
				bw.newLine();
				while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
					if(line1.startsWith(";")){
						//System.out.println(line1);
						bw.write(line1);
						bw.newLine();
					}
					else{
						//System.out.println(line1);
						bw.write(line1);
						bw.newLine();
						//System.out.println(line2);
						bw.write(line2);
						bw.newLine();
					}
				}
				bw.newLine();
        	}catch (IOException e) {
				e.printStackTrace();
			}
        	
				
		} // end of files
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> listFilesForFolder(final File folder) {
		List<String> files = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            // System.out.println(fileEntry.getName());
	            files.add(fileEntry.getName());
	        }
	    }
	    return files;
	}

}
