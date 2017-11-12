import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinStickers {
	public int minStickers(String[] stickers, String target) {
		
		List<HashMap<Character, Integer>> stickerMaps 
						= new ArrayList<HashMap<Character, Integer>>();
		for (int i = 0; i < stickers.length; i++) {
			HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
			updateHash(stickers[i], hm);
			stickerMaps.add(hm);
		}
		
		int[] used = new int[stickers.length];
		Arrays.fill(used, 0);
		
		char[] chars = target.toCharArray();
		
		for(int i = 0; i < chars.length; i++) {
			boolean found = false;
			found = findInSticker(stickers, stickerMaps, used, chars[i], 1);
			if(!found)
				found = findInSticker(stickers, stickerMaps, used, chars[i], 2);
			if(!found)
				found = findInSticker(stickers, stickerMaps, used, chars[i], 3);
			if(!found)
				return -1;
				
		}
		int res = 0;
		for(int i = 0; i < stickers.length; i++)
			res += used[i];
	    return res;
	}

	private boolean findInSticker(String[] stickers, List<HashMap<Character, Integer>> stickerMaps, int[] used,
			Character ch, int numtry) {
		for (int i = 0; i < stickers.length; i++)
			if((numtry > 1 || used[i] > 0) 
					&& (stickerMaps.get(i).get(ch) != null && stickerMaps.get(i).get(ch) >= 0)) {
				if(stickerMaps.get(i).get(ch) == 0) {
					updateHash(stickers[i], stickerMaps.get(i));
					used[i]++;
				}
				stickerMaps.get(i).put(ch, stickerMaps.get(i).get(ch) - 1);
				if(numtry > 1)
					used[i]++;
				return true;
			}
		return false;
	}
	
	private void updateHash(String sticker, HashMap<Character, Integer> hm) {
		char[] chars = sticker.toCharArray();
		for(int i = 0; i < chars.length; i++)
			if(hm.get((Character)(chars[i])) == null)
				hm.put((Character)(chars[i]), 1);
			else
				hm.put((Character)(chars[i]), hm.get((Character)(chars[i]))+1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStickers obj = new MinStickers();
		String[] stickers = {"these","guess","about","garden","him"};
		String target = "atomher";
		System.out.println(obj.minStickers(stickers, target));
	}

}
