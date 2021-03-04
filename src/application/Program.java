package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import entities.Register;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map  = new TreeMap<>();
		
		System.out.println("Enter file path: (C:\\temp\\in.csv)");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int vote = Integer.parseInt(fields[1]);
				
				Register r = new Register(name, vote);
				
				if(map.get(r.getName()) == null) {
					map.put(r.getName(), r.getVote());
				}
				else {
					map.put(r.getName(), r.getVote() + map.get(name));
				}
				
				line = br.readLine();
			}
			
			for(String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}
		
		}
		catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		sc.close();
	}
}


