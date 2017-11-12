import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AccountsMerge {
	private class Account {
		String name;
		HashSet<String> emails;
		public Account(String name) {
			this.name = name;
			emails = new HashSet<>();
		}
		public void add(String email) {
			emails.add(email);
		}
	}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<Account> email_accounts = InitEmailSet(accounts);
		
		merge(email_accounts);
		List<List<String>> res = new ArrayList<>();
		Iterator<Account> litr = email_accounts.iterator();
		while(litr.hasNext()) {
			Account acc = litr.next();			
			List<String> temp = new ArrayList<>();
			temp.add(acc.name);
			for(String s:acc.emails) 
				temp.add(s);
				
			res.add(temp);
		}
        return res;
    }

	private void merge(List<Account> email_accounts) {
		Iterator<Account> litr = email_accounts.iterator();
		while(litr.hasNext()) {
			Account acc = litr.next();	
			HashSet<String> temp = new HashSet<>();
			for(String s:acc.emails) {
				Iterator<Account> litr2 = litr;
				temp.add(s);
				while(litr2.hasNext()) {
					Account next_acc = litr2.next();
					if(next_acc.name == acc.name && next_acc.emails.contains(s)) {
						for(String s2: next_acc.emails)
							temp.add(s2);
						litr2.remove();
					}
				}
			}
			acc.emails = temp;
		}
	}
	
	private List<Account> InitEmailSet(List<List<String>> accounts) {
		List<Account> res = new ArrayList<>();
		for(List<String> acc: accounts) {
			
			Iterator<String> litr = acc.iterator();
			Account new_acc = new Account(litr.next());
			litr = acc.iterator();
			litr.next();
			while(litr.hasNext())
				new_acc.add(litr.next());
			res.add(new_acc);
		}
		return res;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] temp = 
				{{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},
				 {"John","johnnybravo@mail.com"}};
		List<List<String>> accounts = new ArrayList<>();
		for(int i = 0; i < temp.length; i++) {
			List<String> l = new ArrayList<>();
			for(int j = 0; j < temp[i].length; j++)
				l.add(temp[i][j]);
			accounts.add(l);
		}
		AccountsMerge obj = new AccountsMerge();
		List<List<String>> res = obj.accountsMerge(accounts);
		for(List<String> acc:res) {
			for(String s:acc)
				System.out.print(s + " ");
			System.out.println("");
		
		}
	}

}
