package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CFRReader {
    private State[] state;
    private LinkedList<Race> raceList;
    private Race[] race;
    private static final String[] raceName = { "white", "black", "latinX",
        "asian", "other" };

    public CFRReader(String filename) {
        state = this.readStateFile(filename);
    }


    /**
     * read the file
     * 
     * @param filename
     *            the given file name
     * @return
     *         the state object
     */
    private State[] readStateFile(String filename) {
        state = new State[5];
        race = new Race[4];
        File file = new File(filename);

        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                String[] strings = string.split(",");
                int num = 0;
                raceList = new LinkedList<Race>();
                for (int i = 0; i < race.length; i++) {
                    race[i] = new Race(raceName[i]);
                    if (strings[i + 1].equals("NA")) {
                        race[i].setCases(-1);
                    }
                    else {
                        race[i].setCases(Integer.valueOf(strings[i + 1]));
                    }

                    if (strings[i + 6].equals("NA")) {
                        race[i].setDeathCase(-1);
                    }
                    else {
                        race[i].setDeathCase(Integer.valueOf(strings[i + 6]));
                    }
                    race[i].setCFR();
                    raceList.add(race[i]);
                }
                state[num] = new State(strings[0]);
                state[num].setRace(raceList);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("I got here");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
    public State[] getState()
    {
        return state;
    }
}
