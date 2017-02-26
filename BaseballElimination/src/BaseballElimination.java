import java.util.ArrayList;

import java.util.HashMap;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BaseballElimination {
    private static final double FLOATING_POINT_EPSILON = 1E-11;
    private static final double INFINITY = Double.POSITIVE_INFINITY;
    private HashMap<String, Integer> teams;
    private HashMap<String, BaseballTeamInfo> teamsInfo;

    private class BaseballTeamInfo {
        private int teamWins;
        private int teamLoss;
        private int teamRemainingGames;
        private int[] gameSchedule;
        private BaseballTeamInfo(int wins, int losses, int remains, int[] schedule) {
            teamWins = wins;
            teamLoss = losses;
            teamRemainingGames = remains;
            gameSchedule = schedule;
        }
    }
    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename)  
    {
        In in = new In(filename);
        int num = Integer.parseInt(in.readLine());
        teams = new HashMap<String, Integer>();
        teamsInfo = new HashMap<String, BaseballTeamInfo>();
        int teamNum = 0;
        while (!in.isEmpty()) {
            String team = in.readString();
            int wins = in.readInt();
            int losses = in.readInt();
            int remains = in.readInt();
            int[] schedule = new int[num];
            for (int i = 0; i < num; i++)
                schedule[i] = in.readInt();
            BaseballTeamInfo info = new BaseballTeamInfo(wins, losses, remains, schedule);
            teamsInfo.put(team, info);
            teams.put(team, teamNum++);
        }
    }
    public int numberOfTeams()                        // number of teams
    {
        return teams.size();
    }
    public Iterable<String> teams()                                // all teams
    {
        return teams.keySet();
    }
    public int wins(String team)                      // number of wins for given team
    {
        if (!teamsInfo.containsKey(team))
            throw new java.lang.IllegalArgumentException();
        return teamsInfo.get(team).teamWins;
    }
    public int losses(String team)                    // number of losses for given team
    {
        if (!teamsInfo.containsKey(team))
            throw new java.lang.IllegalArgumentException();
        return teamsInfo.get(team).teamLoss;
    }
    public int remaining(String team)                 // number of remaining games for given team
    {
        if (!teamsInfo.containsKey(team))
            throw new java.lang.IllegalArgumentException();
        return teamsInfo.get(team).teamRemainingGames;
    }
    public int against(String team1, String team2)    // number of remaining games between team1 and team2
    {
        if (!teamsInfo.containsKey(team1) || !teamsInfo.containsKey(team2))
            throw new java.lang.IllegalArgumentException();
        return teamsInfo.get(team1).gameSchedule[teams.get(team2)];
    }
    public boolean isEliminated(String team)              // is given team eliminated?
    {
        if (!teamsInfo.containsKey(team))
            throw new java.lang.IllegalArgumentException();
        BaseballTeamInfo xInfo = teamsInfo.get(team);
        for (String t : teams.keySet()) {
            if (!t.equals(team))
                if (teamsInfo.get(t).teamWins > xInfo.teamWins + xInfo.teamRemainingGames)
                    return true;
        }
        FlowNetwork g = constructGameGraph(team);
        FordFulkerson maxflow = new FordFulkerson(g, g.V() - 2, g.V() - 1);
        return !isFull(g, maxflow.value());
    }
    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team)  
    {
        if (!teamsInfo.containsKey(team))
            throw new java.lang.IllegalArgumentException();
        ArrayList<String> res = new ArrayList<String>();
        BaseballTeamInfo xInfo = teamsInfo.get(team);
        for (String t : teams.keySet()) {
            if (!t.equals(team))
                if (teamsInfo.get(t).teamWins > xInfo.teamWins + xInfo.teamRemainingGames)
                    res.add(t);
        }
        if (!res.isEmpty())
            return res;
        FlowNetwork g = constructGameGraph(team);
        FordFulkerson maxflow = new FordFulkerson(g, g.V() - 2, g.V() - 1);
        if (!isFull(g, maxflow.value()))
            for (String t : teams.keySet())
                if (maxflow.inCut(teams.get(t)))
                    res.add(t);
        if (res.isEmpty())
            return null;
        return res;
    }
    private boolean isFull(FlowNetwork g, double value)
    {
        double capacity = 0.0;
        for (FlowEdge e : g.adj(g.V() - 2))
            capacity += e.capacity();
        return capacity < value + FLOATING_POINT_EPSILON;
    }
    private FlowNetwork constructGameGraph(String team) {
        int x = teams.get(team);
        BaseballTeamInfo xInfo = teamsInfo.get(team);
        FlowNetwork g = new FlowNetwork(partialSum(teams.size() - 1) + teams.size() + 2);
        for (String t : teams.keySet()) {
            int teamNum = teams.get(t);
            if (teamNum != x) {
                BaseballTeamInfo info = teamsInfo.get(t);
                g.addEdge(new FlowEdge(teamNum, g.V() - 1, xInfo.teamWins + xInfo.teamRemainingGames - info.teamWins));
                
                for (int i = 0; i < teams.size(); i++)
                    if (i != x && i > teamNum && info.gameSchedule[i] > 0) {
                        g.addEdge(new FlowEdge(g.V() - 2, calcVertice(teamNum, i, teams.size()), info.gameSchedule[i]));
                        g.addEdge(new FlowEdge(calcVertice(teamNum, i, teams.size()), teamNum, INFINITY));
                        g.addEdge(new FlowEdge(calcVertice(teamNum, i, teams.size()), i, INFINITY));
                    }
            }
        }        
        return g;
    }
    
    private static int calcVertice(int team1, int team2, int size)
    {
        return size - 1 + shift(team1, size) + team2 - team1;
    }
    
    private static int shift(int n, int size) {
        int shift = 0;
        for (int i = size - 1; i > size - n - 1; i--)
            shift += i;
        return shift;
    }
    
    private static int partialSum(int n) {
        int res = 0; // this  will be the result
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }
    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination("test\\team4.txt");
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
