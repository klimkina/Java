import java.util.ArrayList;
import java.util.Arrays;

public class AfraidOfDark {
	private int[] isLight;
	private ArrayList<Integer>[] adj;
	private boolean[] marked;
	private boolean[] marked2;
	private boolean turnOn;
	 
	public AfraidOfDark(int[] rooms) {
		isLight = new int[rooms.length];
		System.arraycopy( rooms, 0, isLight, 0, rooms.length);
		
		adj = new ArrayList[rooms.length];
		for (int v = 0; v < rooms.length; v++)
			adj[v] = new ArrayList<Integer>();
		marked = new boolean[rooms.length];
		marked2 = new boolean[rooms.length];
	}
	public void addCoridor(int room1, int room2) {
		adj[room1-1].add(room2-1);
		adj[room2-1].add(room1-1);
	}
	public Iterable<Integer> adj(int room)
	 { return adj[room]; }

	public int visitRooms(int v) {
		Arrays.fill(marked, false);
		Arrays.fill(marked2, false);
		turnOn = false;
		
		return dfs(v-1);
	}
	
	private boolean searchDark(int s) {
		marked2[s] = true;
		if(isLight[s] != 1)
			return true;
		if(adj[s].isEmpty())
			return false;
		for (int w : adj(s))
			if (!marked2[w] && !marked[w])
				if(searchDark(w))
					return true;
		return false;
	}
	private boolean hasDark(int s) {
		Arrays.fill(marked2, false);
		marked2[s] = true;
		if(adj[s].isEmpty())
			return false;
		for (int w : adj(s))
			if(!marked[w] && searchDark(w))
				return true;
		return false;
	}
	private int dfs(int s)
	{	
		if(isLight[s] != 1)
			if(turnOn)
				turnOn = !turnOn;
			else 
				if(hasDark(s)) 
					turnOn = !turnOn;
				else
					return 0;
		
		marked[s] = true;
		int res = 0;
		int max = 0;
		int curr = 0;
		boolean prevTurn = turnOn;
		for (int w : adj(s))
		{
			if (!marked[w])	{
				curr = dfs(w);
				if(isLight[s] != 1 && prevTurn != turnOn) {
					max = Math.max(max, curr);
					turnOn = !turnOn;
				}
				else
					res += curr;
			}
		}
		return res + max + 1;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rooms = {0, 0, 0, 1, 1, 1};
		AfraidOfDark obj = new AfraidOfDark(rooms);
		obj.addCoridor(3, 1);
		obj.addCoridor(4, 1);
		obj.addCoridor(3, 2);
		obj.addCoridor(2, 5);
		obj.addCoridor(5, 6);
		for(int i = 1; i <= rooms.length; i++)
			System.out.println(obj.visitRooms(i));
		/*Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] s = new int[n];
            for(int s_i = 0; s_i < n; s_i++){
                s[s_i] = in.nextInt();
            }
            AfraidOfDark obj = new AfraidOfDark(s);
            for(int a1 = 0; a1 < n-1; a1++){
                int a = in.nextInt();
                int b = in.nextInt();
                // Write Your Code Here
                obj.addCoridor(a, b);
            }
            for(int i = 1; i <= s.length; i++)
    			System.out.println(obj.visitRooms(i));
        }
        in.close();*/
	}

}
