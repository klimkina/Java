class Solution {
	public String intToRoman(int num) {
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
    }
	public int romanToInt(String s) {
		int nums[]=new int[s.length()];
	    for(int i=0;i<s.length();i++){
	        switch (s.charAt(i)){
	            case 'M':
	                nums[i]=1000;
	                break;
	            case 'D':
	                nums[i]=500;
	                break;
	            case 'C':
	                nums[i]=100;
	                break;
	            case 'L':
	                nums[i]=50;
	                break;
	            case 'X' :
	                nums[i]=10;
	                break;
	            case 'V':
	                nums[i]=5;
	                break;
	            case 'I':
	                nums[i]=1;
	                break;
	        }
	    }
	    int sum=0;
	    for(int i=0;i<nums.length-1;i++){
	        if(nums[i]<nums[i+1])
	            sum-=nums[i];
	        else
	            sum+=nums[i];
	    }
	    return sum+nums[nums.length-1];
    }
    public static void main(String[] args) {
    	int num = 1235;
    	Solution obj = new Solution();
    	String s = obj.intToRoman(num);
    	System.out.println(s);
    	System.out.println(obj.intToRoman(s));
    }
}