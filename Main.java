import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class GenerateRandom {
    public static void main( String args[] ) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("How many teams? ");
        double numberOfTeams = reader.nextInt(); // Scans the next token of the input as an int.
        //once finished
        reader.close();

        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader("names.txt"));
        } catch (FileNotFoundException e1) {
            
            e1.printStackTrace();
        } 
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

        Collections.shuffle(listOfNames);

        int numberOfMembers = (int)Math.floor(listOfNames.size() / numberOfTeams);

        for (int i = 1; i < numberOfTeams + 1; i++)
        {
            System.out.println("Group " + i);
            for (int j = 0; j < numberOfMembers; j++)
            {
                System.out.println(listOfNames.get(0));
                listOfNames.remove(0);
            }
            System.out.println();
        }
    }
}