package ColorMapofUS;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Main {
	

	public static void main(String[] args) throws Exception {
		ArrayList<String> listofcolors = new ArrayList<>();
		ArrayList<Node> listofstates = new ArrayList<>();
		ArrayList<Node> listofadjacentstates = new ArrayList<>();
		ArrayList<Node> listoffirststates = new ArrayList<>();
		ArrayList<Node> listofsecondstates = new ArrayList<>();
		HashMap <String, ArrayList<Node>> map = new HashMap<String, ArrayList<Node>>();
	
		
		
		File file = new File("/Users/amania/eclipse-workspace/amania_assignment1Comp560/src/usTestFile.txt");
		
		Scanner scanner = new Scanner(file);
		
		int numberofcolors = 0;
		int numberofstates = 0;
		
		
		while (scanner.hasNext()) { //read in list of colors (first section)
			String colors = "[A-Z]+[a-z]+";
			String text = scanner.nextLine();
			
			boolean matches = Pattern.matches(colors, text);
			if (matches) {
				listofcolors.add(text);
				
			}	
			
			String state = "[A-Z]+"; //read in list of states (second section)
			boolean matches2 = Pattern.matches(state, text);
        		if (matches2) {
        			numberofstates++;
				listofstates.add(new Node(text, null));
				
			}
        		
        		
        		String adjstates = "[A-Z]+\\s[A-Z]+"; //read in adjacent states (third section)
        		boolean matches3 = Pattern.matches(adjstates, text);
        		if (matches3) {
        			listofadjacentstates.add(new Node(text, null));
        		}
		}
		
		
			for (int i = 0; i<listofadjacentstates.size(); i++) { //separate the third section of input file into first column and second column
				String firststate = listofadjacentstates.get(i).state;
				String rest = listofadjacentstates.get(i).state;
				int a = firststate.indexOf(" ");
				if (firststate.contains(" ") && rest.contains(" ")) {
					firststate = firststate.substring(0, a);
					rest = rest.substring(3, 5);			
				}
				
				listoffirststates.add(new Node(firststate, null)); //add the first column of third section of input file into a list
				listofsecondstates.add(new Node(rest, null)); //add the second column of third section of input file into a list
				
				

				for (int j = 0; j<listofstates.size();j++) {	//populate the hashmap with each state being the key
					map.put(listofstates.get(j).state, new ArrayList<Node>());			   	
					}
			}	
			
			
			
			for (int k = 0; k<listoffirststates.size();k++) { //populate hashmap that has each state as key and list of adjacent states as values
				if (map.containsKey(listoffirststates.get(k).state) && map.containsKey(listofsecondstates.get(k).state)) {
						map.get(listoffirststates.get(k).state).add(listofsecondstates.get(k)); //puts adjacent state as values 
						map.get(listofsecondstates.get(k).state).add(listoffirststates.get(k)); //puts adjacent state as values
						
						Node n1 = listoffirststates.get(k);
						Node n2 = listofsecondstates.get(k);
						
						
							
							if (map.get(n1.state).contains(n2) &&   //attempt at backtracking search          
									map.get(n2.state).contains(n1)) {
								for (int m = 0; m<listofcolors.size(); m++) {
									for (int p = 0; p<listofcolors.size(); p++) {
										if (listofcolors.get(m) != listofcolors.get(p)) {
											n1 = new Node(listoffirststates.get(k).state, listofcolors.get(m));
											n2 = new Node(listofsecondstates.get(k).state, listofcolors.get(p));
											map.get(n1.state).add(n2);
											map.get(n2.state).add(n1);
										}	
									}
									}
								
								
						}
			for (int m = 0; m<listofcolors.size(); m++) { //attempt at local search
				for (int p = 0; p<listofcolors.size();p++) {
					if (listofcolors.get(m) != listofcolors.get(p)) {
						n1 = new Node(listoffirststates.get(k).state, listofcolors.get(m));
						n2 = new Node(listofsecondstates.get(k).state, listofcolors.get(p));
						map.get(n1.state).add(n2);
						map.get(n2.state).add(n1);
					}
				}
			}
				}				
			
			System.out.print(map);
			
}
	}
}




		
		
	


	
	


