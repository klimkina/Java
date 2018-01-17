/*A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

 For 1-byte character, the first bit is a 0, followed by its unicode code.
 For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
*/
public class ValidUTF {
	public boolean validUtf8(int[] data) {
		if(data==null || data.length==0) return false;
		int i = 0;
		while(i < data.length) {
			if(data[i] > 255) return false; // 1 after 8th digit, 100000000
			int count = countLeadingBits(data[i]);
			if(count > 4 || count == 1 || i + count > data.length)
				return false;
			if(count == 0) count++;
			for(int j=1; j < count; j++) { // check that the next n bytes start with 10xxxxxx
				if(i+j >= data.length) return false;
				if(countLeadingBits(data[i+j]) != 1) return false; // 192(11000000), 128(10000000)
			}
			i += count;
		}
        return true;
    }
	private int countLeadingBits(int n) {
		int mask = (1 << 7);
		int count = 0;
		while((n&mask) != 0) {
			mask >>>= 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidUTF obj = new ValidUTF();
    	int[] data = {240,162,138,147};
    	System.out.println(obj.validUtf8(data));
	}

}
