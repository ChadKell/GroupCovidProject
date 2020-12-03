package prj5;

import java.util.Comparator;

public class compareCFR implements Comparator<Race> {

    public int compare(Race race1, Race race2) {
        return race1.compareTo(race2);
    }

}