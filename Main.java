// IS405 Project 1: Group Maker
// By Justin Ellis, YunChen Lee, Cadde Jorgensen, William Paxton

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class GenerateRandom {
    public static void main( String args[] ) {

        // Get input from the user and put in double
        Scanner reader = new Scanner(System.in);
        System.out.println("How many teams? ");
        double numberOfTeams = reader.nextInt();
        
        reader.close();

        // Try to get names from the names.txt, throw exeception if it cannot
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader("names.txt"));
        } catch (FileNotFoundException e1) {
            
            e1.printStackTrace();
        } 

        // Put the names in an ArrayList
        ArrayList<String> listOfNames = new ArrayList<>(); 
        String line = null;
        try {
            line = bufReader.readLine();
        } catch (IOException e) {
            
            e.printStackTrace();
        } 
        while (line != null) 
        { 
            listOfNames.add(line); 
            try {
                line = bufReader.readLine();
            } catch (IOException e) {
                
                e.printStackTrace();
            } 
        } 
        try {
            bufReader.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        // Shuffle the names in the ArrayList
        Collections.shuffle(listOfNames);

        // Calculate how members in each team and find remainder
        int numberOfMembers = (int)Math.floor(listOfNames.size() / numberOfTeams); 

        double remaining = listOfNames.size() % numberOfTeams;

        System.out.println();

        // Loop through list of names and print them out in groups
        for (int i = 1; i < numberOfTeams + 1; i++) 
        {

            System.out.println("Group: " + i);


            for (int j = 0; j < numberOfMembers; j++)
            {
                System.out.println(listOfNames.get(0));
                listOfNames.remove(0);

            }

            if (remaining > 0)
            {
                System.out.println(listOfNames.get(0));
                listOfNames.remove(0);
                remaining = remaining - 1; 
            }

            System.out.println();
        }
    }
}