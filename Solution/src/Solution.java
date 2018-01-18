/*The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.*/

class Solution {
	int read4(char[] buf) {
		Arrays.fill(buf, 'a');
		return 3;
	}

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	private char[] charr = new char[4];
	private int charr_left = 0;
	private int charr_start = 0;
	
    public int read(char[] buf, int n) { 	
        
        int count = 0;
        while(count < n) {
        	if(charr_left == 0)
        		charr_left = read4(charr);
        	if(charr_left == 0) break; //end
        	while(count < n && charr_start < charr_left)
        		buf[count++] = charr[charr_start++];
        	if(charr_start >= charr_left){
                charr_left = 0;
                charr_start = 0;
            }
        }
        
        return count;
    }
    
	
    public static void main(String[] args) { 
    	Solution obj = new Solution();
    	char[] temp = new char[4];
    	System.out.println(obj.read(temp, 1));
    	System.out.println(obj.read(temp, 2));
    }
}