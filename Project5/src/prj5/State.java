
package prj5;

import java.util.LinkedList;

/**
 * state class
 * @author ckell
 *
 */
public class State {
    private String name;
    private prj5.LinkedList<Race> race;

    public State(String name) {
        this.name = name;
        this.race = null;
    }


    public String getName() {
        return name;
    }


    public prj5.LinkedList<Race> getRace() {
        return race;
    }


    public void setRace(prj5.LinkedList<Race> raceList) {
        this.race = raceList;
    }
    
    public void sortAlpha() {
        race.insertionSort(new CompareAlphabetically());
    }
    
    public void sortCFR() {
        System.out.println("here homie");
        prj5.LinkedList<Race> placeholder = new prj5.LinkedList<Race>();
        for(int i = 0; i < 5; i++)
        {
            int index = 0;
            double max = 0;
            for (int j = 0; i < race.getLength(); i++)
            {
                if (race.get(j).getCFR() > max)
                {
                    index = j;
                    max = race.get(j).getCFR();
                }
               
            }
            placeholder.add(race.get(index));
            
            System.out.println(race.remove(index));
            
        }
        race = placeholder;
    }
    

}