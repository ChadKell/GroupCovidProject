package prj5;

import java.util.Comparator;

public class CompareAlphabetically implements Comparator<Race> {
    /**
     * 
     * @param state1 first state
     * @param state2 second state
     * @return negative if state is "smaller" positive if larger
     */
    
    @Override
    public int compare(Race race1, Race race2) {
        if (race1.toString() == "NA" && race2.toString() == "NA")
        {
            return 0;
        }
        else if (race1.toString() == "NA")
        {
            return -1;
        }
        else if (race2.toString() == "NA")
        {
            return 1;
        }
        return race1.getRace().compareTo(race2.getRace());
    }

   
   
}
