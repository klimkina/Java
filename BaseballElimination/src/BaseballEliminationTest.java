import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;

public class BaseballEliminationTest {

    @Test 
    public void testBaseballElimination1team() {
        BaseballElimination division = new BaseballElimination("test\\team1.txt");
        assertEquals(division.numberOfTeams(), 1);
        
    }

    @Test 
    /*
    Atlanta is not eliminated
    Philadelphia is eliminated by the subset R = { Atlanta New_York }
    New_York is not eliminated
    Montreal is eliminated by the subset R = { Atlanta }
    */
    public void testBaseballElimination4teams() {
        BaseballElimination division = new BaseballElimination("test\\team4.txt");
        for (String team : division.teams()) {
            if (team.equals("Atlanta") || team.equals("New_York")) {
                assertEquals(division.isEliminated(team), false);
            } else {
                assertEquals(division.isEliminated(team), true);
                if (team.equals("Montreal"))
                    for (String t : division.certificateOfElimination(team)) {
                        assertEquals(t, "Atlanta");
                    }
                else if (team.equals("Philadelphia"))
                    for (String t : division.certificateOfElimination(team)) {
                        assertTrue(t.equals("Atlanta") || t.equals("New_York"));
                    }
            }
        }
    }

    @Test 
    /*
    New_York is not eliminated
    Baltimore is not eliminated
    Boston is not eliminated
    Toronto is not eliminated
    Detroit is eliminated by the subset R = { New_York Baltimore Boston Toronto }
    */
    public void testBaseballElimination5teams() {
        BaseballElimination division = new BaseballElimination("test\\team5.txt");
        for (String team : division.teams()) {
            if (team.equals("Baltimore") || team.equals("New_York") || 
                    team.equals("Boston") || team.equals("Toronto")) {
                assertEquals(division.isEliminated(team), false);
            } else {
                assertEquals(division.isEliminated(team), true);
                if (team.equals("Detroit"))
                    for (String t : division.certificateOfElimination(team)) {
                        assertTrue(t.equals("Baltimore") || t.equals("New_York")
                                || t.equals("Boston") || t.equals("Toronto"));
                    }
            }
        }
    }


}
