import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdoptionRequest {

    /**
     * This Method reads a file of dog information: breed, name, chip number,etc and parses it into
     * a list of individual dogs. It then splits up the information for each dog and sends the information
     * into the Dog class and creates a new Dog object for each line of the file, filling in the needed
     * info, it then places that Dog object into a Hashmap as a value with the dogs chip number as the
     * value.
     *
     */
    public Map<String, Dog> loadDogData() {
        // Lines to get the file located and initialised
        String filepath = "./allDogs.txt";
        Path path = Path.of(filepath);

        // The hashmap for all the dog objects is created here
        Map<String, Dog> mapOfAllDogs = new HashMap<>();

        try {
            // Reading in the file
           List<String> dogsOnFile = Files.readAllLines(path);

           // Iterate through every line in the file.
           for (String nextDog : dogsOnFile) {
               // Split up all the info at the commas
               String[] dogInformation = nextDog.split(",");

               // Throw away the titles of each column
               if (dogInformation[0].equalsIgnoreCase("name")){ continue;}

               // Assigning all needed values
               String name = dogInformation[0];
               long chip = Long.parseLong(dogInformation[1]);
               String sex = dogInformation[2];
               boolean deSexed = dogInformation[3].equalsIgnoreCase("yes");
               int age = Integer.parseInt(dogInformation[4]);
               String breed = dogInformation[5];

               // Call the Dog constructor
               Dog dog = new Dog(name, chip, breed, sex, deSexed, age);

               // Send the pup to the map
               mapOfAllDogs.put(dogInformation[1], dog);
           }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        // Print the map to the standard output to make sure all went well.
//        System.out.println(mapOfAllDogs);
        return mapOfAllDogs;
    }

    /**
     * Asks user a series of questions regarding what type of dog they are looking to adopt
     * creates a dog object with those wants and returns that dog object
     */
    public Dog getUserInput() {

        // Welcome user
        JOptionPane.showMessageDialog(null, "Welcome to adopt a dog, dawg");

        // Ask for breed
        String breed = JOptionPane.showInputDialog("What breed are you looking for");
        if (breed == null) {exitOnNull();}

        // Ask for sex
        String sex = JOptionPane.showInputDialog("What sex are you looking for (male or female)");
        if (sex == null) {exitOnNull();}

        //Ask for deSexed
        boolean deSexed = false;
        String deSexedQuestion = JOptionPane.showInputDialog("Would you like the pup to be desexed or not (yes or no)");
        if (deSexedQuestion == null) {exitOnNull();}
        else if (deSexedQuestion.equalsIgnoreCase("yes")) {deSexed = true;}

        //Ask for age range
        int minAge =-1;

        while (minAge < 0 || minAge > 20){
            try {
                minAge = Integer.parseInt(JOptionPane.showInputDialog("What is the minimum age you would like"));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        int maxAge =-1;
        while (maxAge < minAge || maxAge > 20){
            try {
                maxAge = Integer.parseInt(JOptionPane.showInputDialog("What is the minimum age you would like"));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        return new Dog(breed, sex, deSexed, minAge, maxAge);
    }



    private static void exitOnNull(){
        JOptionPane.showMessageDialog(null,"Sorry, have a nice day");
        System.exit(0);
    }
}
