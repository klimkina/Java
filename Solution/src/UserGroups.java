import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;

public class UserGroups {
	protected static class User
	{
		String name;
		public User(String name)
		{
			this.name = name;
		}
	}
	protected static class Group
	{
		String name;
		List<Group> children =  new ArrayList<>();
		List<User> users=  new ArrayList<>();
		public Group(String n, Group[] ch, User[] u)
		{
			name = n; 
			if(ch != null && ch.length > 0)
			{
				for(Group g: ch)
					children.add(g);
			}
			if(u != null && u.length > 0)
				for(User user:u)
					users.add(user);
		}
	}
	
	HashMap<String, Group> groups = new HashMap<>();
	private boolean hasCycle = false;
	private HashSet<String> visited = new HashSet<>();
	public UserGroups()
	{
		
	}
	public boolean add(Group g, String[] parents)
	{
		groups.put(g.name, g);
		if(parents != null && parents.length > 0)
		{
			for(String s : parents)
				groups.get(s).children.add(g);
			if (hasCycle())
			{
				for(String s : parents)
					groups.get(s).children.remove(g);
				return false;
			}
		}
		return true;
	}
	private boolean hasCycle()
	{
		visited.clear();
		hasCycle = false;
		for(Group g : groups.values())
			if(!visited.contains(g.name))
				dfs(null, g);
		return hasCycle;
	}
	private void dfs(Group start, Group g)
	{
		visited.add(g.name);
		for(Group ch : g.children)
			if(!visited.contains(ch.name))
				dfs(g, ch);
			else if (ch != start) 
				hasCycle = true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserGroups obj = new UserGroups();
		User[] users1 = new User[2];
		users1[0] = new User("Mila");
		users1[1] = new User("Katya");
		Group g1 = new Group("MilaG", null, users1);
		System.out.println(obj.add(g1, null));
		Group[] child = new Group[1];
		child[0] = g1;
		Group g2 = new Group("KatyaG", child, users1);
		String[] parents = {"MilaG", "KatyaG"};
		System.out.println(obj.add(g2, parents));
	}

}
