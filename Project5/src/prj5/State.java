
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
        race.insertionSort(new compareCFR());
    }
    

}