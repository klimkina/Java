import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


class Solution {
	public String[] reorderLogFiles(String[] logs) {
        String[] my_logs = new String[logs.length];
        for (int i = 0; i < logs.length; i++)
        {
            int pos = logs[i].indexOf(" ");
            my_logs[i] = logs[i].substring(pos+1, logs[i].length()) + " " + logs[i].substring(0, pos) + " " + i;
        }
        Arrays.sort(my_logs, new Comparator<String>(){
            public int compare (String a, String b)
            {
                if(a.length() == 0)
                    return -b.length();
                if (b.length() == 0)
                    return 1;
                boolean anum = a.charAt(0) <='9' && a.charAt(0) >='0';
                boolean bnum = b.charAt(0) <='9' && b.charAt(0) >='0';
                if (!anum&&!bnum)
                    return a.compareTo(b);
                if (anum && !bnum)
                    return 1;
                if (bnum && !anum)
                    return -1;
                int posa = a.lastIndexOf(" ");
                int posb = b.lastIndexOf(" ");
                int an = Integer.valueOf(a.substring(posa+1, a.length()));
                int bn = Integer.valueOf(b.substring(posb+1, b.length()));
                return an-bn;
            }
        });
        for (int i = 0; i < logs.length; i++)
        {
            int pos = my_logs[i].lastIndexOf(" ");
            my_logs[i] = my_logs[i].substring(0,pos);
            pos = my_logs[i].lastIndexOf(" ");
            my_logs[i] = my_logs[i].substring(pos+1, my_logs[i].length()) + " " + my_logs[i].substring(0, pos);
        }
        return my_logs;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String[] logs = {"o vzvqllcdgjzfejikkcihcxhjysaugixwjrzlqzxveioilg r",
		                  "12i5sarvhq8k 981328457964639772 52168951731 5731 1",
		                  "ns3jabozhtw puwvfrplwdnez ffcssolgkghrewiyuwwlgy y",
		                  "oh9md9kq4f 19626031835971546996056703362 63 09 22",
		                  "2 xfcutbes triwx vbro fbeg ogox fdsgvxqhgpckv rnd",
		                  "t9s89it4 915040039419954542 12268940190034 23561 1",
		                  "jrh 8620945174270391408001255268601674238582650 44",
		                  "adk2e 7 4331673806384451545446002301 132 997023176",
		                  "sjbu 4493891954530 5088427863 1340674677929573 380",
		                  "m3orha75jv7m 5611273074367021751530 99681603759263",
		                  "slnt8oupu7p0 5056515 01451106023885326147597559544",
		                  "w1kw2z6m5o cmyrphqnowgkmyisetu emdcsimwaiskzilzf a",
		                  "uxv 81998391835348322227034401 011157281662384 196",
		                  "p6 egjuhkojwoyaoe fudfnpsasafeajjab bwzedgsjl i s",
		                  "vlu0 szgbsj ddnzmkexzdnupfvndughwprxsvmsotdhiuf h",
		                  "v54thmh 8824194366 7679311944824228881619381423226",
		                  "se5 75438354647483406663945696134597520655594 5 1",
		                  "03 93888987235562143423459571011473 5191 7034 53 9",
		                  "i 4981979099600458193 56667 79241322153526694 04 8",
		                  "o0i9i2ljkgo kbxqdq jaeazub uhvokforhfthna gw z c v",
		                  "fywhz 292923415300936155 5452149683655416 63839748",
		                  "whjt8 gjnjqhrlrcgsysaoaygrmjgoknwv fqscxhv h djc v",
		                  "1go19zj7jj acvsrk f panfzgurqzpzczlvlmphksghjlfzc",
		                  "59pht5gu qyabwqmgckwwjqk gm bx jyfcvuybwywm vh iew",
		                  "z6q4wbp424l 1008645486 3657202 2865156614885369751",
		                  "bw7ks 0101269971263 819916346147102452825172340473",
		                  "2ywxl5fk 9417017431489198867196920771758497 14058",
		                  "c8d03gkf 9116537068 59665743 04359641901 9929382 4",
		                  "wd3u 716169115362619499845463482425867032320462 48",
		                  "q0st0wr2z 01743 53435 0084975 2 975795286383344 09",
		                  "u53dlm xwxmhirqhavozmjwcoeaamnbb eli nfnyu f jdvxy",
		                  "z 663130439561436386421513352215852722699062 249 7",
		                  "fu 326915798576989955532628901110812387 6742097870",
		                  "u90164 14044699857717350733 6 758958742319 1874119",
		                  "ajbo40n 325771614871485 3417851839 368815780366119",
		                  "jzqe7qdm8au 19714762229839827355742 31200800188 2",
		                  "souwlw26e754 jsbsphumepfqmzpfpwllextsnryozqrdv ul",
		                  "kdmunmmo gv ndaxmhyljndnxiihjys krtmuapxhmtnpyvg t",
		                  "pn 26800971339753263769 1 3736208573709970013644 7",
		                  "qvsz0ynb 04154894995359 308418 9219573295 6 53417",
		                  "xbc461e1is 3074369382298452 53908701998938964 7289",
		                  "hzpge8smy6 kzpymstcxterubbmkgslgdkidjpzrchiqzrdsl",
		                  "bm8wljp31 scrbzrvpvuovrgdrwdywxmfd uofvhw he mj ea",
		                  "0 61930955 779613186685045 427241 738322450 6 3 33",
		                  "tv77n01gax 88688419619585779350965802992823 66123",
		                  "jm6w91 62380982804880484391265315701463 11349677 4",
		                  "eyx4xb jdwtyxyivmxudlons ptkhatoulmsxju dsvrewo pz",
		                  "72u 00 33 629 659498206 170038 1443292997 9593335",
		                  "2 173674835 0690001188247046268235829594 67559 93",
		                  "voa6r53kv4 410816354221527837787819277490320 125 1"};
		String[] res = obj.reorderLogFiles(logs);
		for(String s:res)
			System.out.println(s);
	}
}
