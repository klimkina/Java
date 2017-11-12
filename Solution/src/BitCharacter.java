
public class BitCharacter {
	public boolean isOneBitCharacter(int[] bits) {
		int i = 0;
		for(; i < bits.length - 1; i++)
			if(bits[i] == 1) //skip
				i++;
		return i == bits.length - 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitCharacter obj = new BitCharacter();
		int[] bits1 = {1, 0, 0};
		System.out.println(obj.isOneBitCharacter(bits1));
		int[] bits2 = {1, 1, 1, 0};
		System.out.println(obj.isOneBitCharacter(bits2));
	}

}
