package studentCoursesBackup.driver;

import java.io.FileNotFoundException;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {
	static String outputString;
	static int i;
	static int ind;
	static String[] tempArr = new String[100];
	static String[] delArr = new String[100];
	static String fw[] = new String[3];
	static int bnumber;
	static String course;
	static String delString;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				if (args.length == 5) {
					
					try {
						FileProcessor fp = new FileProcessor(args[0]);
						FileProcessor fileProcessor = new FileProcessor(args[0]);
					    FileProcessor delFile = new FileProcessor(args[1]);
						FileProcessor outFile1 = new FileProcessor(args[2]);
						FileProcessor outFile2 = new FileProcessor(args[3]);
						FileProcessor outFile3 = new FileProcessor(args[4]);
						TreeBuilder myBST = new TreeBuilder();
						Results res1 = new Results(outFile1);
						Results res2 = new Results(outFile2);
						Results res3 = new Results(outFile3);
						
						if (!fp.isEmpty()) {

							outputString = fileProcessor.readLine();
							delString = delFile.readLine();
														
							tempArr = outputString.split("\n");
							for(i=0; i<fileProcessor.line_count; i++)
							{
								tempArr[i]=tempArr[i].trim(); 
								fw = tempArr[i].split(":");
								bnumber = Integer.parseInt(fw[0]);
								course = fw[1];
								//System.out.println(course);
								if(course.equals("A") || course.equals("B") || course.equals("C") || course.equals("D") || course.equals("E") || course.equals("F") || course.equals("G") || course.equals("H") || course.equals("I") || course.equals("J") || course.equals("K"))
								myBST.insert(bnumber, course);	
							}
							
							// for deletion
	                        delArr = delString.split("\n");
	                        for(i=0; i<delFile.line_count; i++)
							{
								delArr[i] =delArr[i].trim();
								fw = delArr[i].split(":");
								bnumber = Integer.parseInt(fw[0]);
								course = fw[1];
								if(myBST.getRoot()!= null)
								myBST.delete(bnumber, course);
								
							}
	                        System.out.println("List after deletion");
	                        myBST.display(myBST.getRoot(), res1);
	                        
	                        System.out.println("\n Observer list 1:");
	                        
	                        if(myBST.getRoot()!= null)
	                        myBST.display(myBST.getRoot().observers.get(0), res2);
	                        System.out.println("\n Observer list 2:");
	                        
	                        if(myBST.getRoot()!= null)
	                        myBST.display(myBST.getRoot().observers.get(1), res3);
                            							
						}
						for (i = 0; i < res1.count; i++) {
							String temp;
							temp = res1.store[i];
							//System.out.println(temp);
							res1.writeToFile(temp);
						}
						
						for (i = 0; i < res2.count; i++) {
							String temp;
							temp = res2.store[i];
						//	System.out.println(temp);
							res2.writeToFile(temp);
						}
						
						for (i = 0; i < res3.count; i++) {
							String temp;
							temp = res3.store[i];
							//System.out.println(temp);
							res3.writeToFile(temp);
						}
					} catch (IllegalArgumentException ex) {
						System.err.println("Invalid number of arguments.");
						ex.printStackTrace();
						System.exit(1);
					} catch (FileNotFoundException ex) {
						System.err.println("Input file not Found.");
						ex.printStackTrace();
						System.exit(1);
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.err.println("Invalid debug value");
						ex.printStackTrace();
						System.exit(1);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						
					}
			}else {
					System.out.println("Invalid number of arguments");
				 }

}
}
