
public class BinarySubstrings {
	public int countBinarySubstrings(String s) {
		int res = 0;
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			int num = 0;
			char first = arr[i];
			int j = i + 1;
			while (j < arr.length && arr[j] == first)
				j++;
			num = j - i;
			for(j = 0; j < num && i + j + num < arr.length; j++)
				if(arr[i + num + j] == first)
					break;
			if (j == num)
				res++;
		}
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		BinarySubstrings obj = new BinarySubstrings();
		System.out.println(obj.countBinarySubstrings(s));
	}

}
