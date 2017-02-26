import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
   private WordNet outcastWordNet;
   public Outcast(WordNet wordnet)         // constructor takes a WordNet object
   {
       outcastWordNet = wordnet;
   }
   public String outcast(String[] nouns)   // given an array of WordNet nouns, return an outcast
   {
       int maxDist = 0; 
       String res = "";
       for (String a : nouns) {
           int dist = 0;      
           for (String b : nouns) {
               int i = outcastWordNet.distance(a, b);
               if (i < 0)
                   throw new java.lang.IllegalArgumentException("No common root");
               dist += outcastWordNet.distance(a, b);
           }
           if (dist > maxDist) {
               maxDist = dist;
               res = a;
           }
       }
       return res;
   }
   
   public static void main(String[] args)  // see test client below
   {
       WordNet wordnet = new WordNet("wordnet\\synsets.txt", "wordnet\\hypernyms.txt");
       Outcast outcast = new Outcast(wordnet);
       In in = new In("wordnet\\outcast11.txt");
       String[] nouns = in.readAllStrings();
       StdOut.println(outcast.outcast(nouns));
       
   }
}