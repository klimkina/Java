import java.util.ArrayList;
import java.util.List;

public class IPtoCIDR {
	public List<String> ipToCIDR(String ip, int range) {
		long ipnum = ip2int(ip);
		String s = int2CIDR(ipnum, range);
		List<String> res = new ArrayList<>();
		for (long i = ipnum;i < ipnum + range; i++) {
    		if ((i & 1) != 0) {
    			res.add(int2CIDR(i , 32));
    		} else {
    			long start = i;
    			int mask = 0;
    			while (mask < 31 && (i & (1 << mask)) == 0) { // last significant bit
    				mask++;
    			}
    			
    			while (mask >= 0) {
    				long temp = i + (1 << mask) - 1;
    				if (temp <= ipnum + range - 1) {
    					i = temp;
    					break;
    				}
    				mask--;
    			}
    			res.add(int2CIDR(start , 32 - mask));
    		}
    	}
        return res;
    }
	private long ip2int(String ip) {
		String[] strs = ip.split("\\.");
		long res = 0;
		for(int i = 0; i < strs.length; i++)
			res = (256*res) + Integer.parseInt(strs[i]);
		return res;
	}
	private String int2CIDR(long value , int bit) {
		
		StringBuilder builder = new StringBuilder();
		long mask = 255;
		for(int i = 3; i >= 0; i--) {
			mask = 255 << (i*8);
			if (builder.length() > 0) {
				builder.append(".");
			}
			builder.append((mask&value) >>> (i*8));
		}
		builder.append("/");
		builder.append(bit);
		return builder.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "255.0.0.7";
		int n = 10;
		IPtoCIDR obj = new IPtoCIDR();
		List<String> res = obj.ipToCIDR(ip, n);
		for(String s : res)
			System.out.println(s);
	}

}
