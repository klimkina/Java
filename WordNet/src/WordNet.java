import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class WordNet {
    
    private Digraph hypernyms;
    private Set<String> synsetSet;
    private HashMap<String, ArrayList<Integer>> synsetsByNouns;
    private ArrayList<String> synsetByID;
   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms)
   {
       In inSynsets = new In(synsets);
       synsetsByNouns = new HashMap<String, ArrayList<Integer>>();
       synsetSet = new HashSet<String>();
       synsetByID = new ArrayList<String>();
       while (!inSynsets.isEmpty()) {
           String[] fields = inSynsets.readLine().split("\\,");
           int key = Integer.parseInt(fields[0]);
           String[] nouns = fields[1].split("\\ ");
           synsetByID.add(nouns[0]);
           for (String noun : nouns) {
               ArrayList<Integer> arr = synsetsByNouns.get(noun);
               if (arr == null) {
                   arr = new ArrayList<Integer>();
                   arr.add(key);
                   synsetsByNouns.put(noun, arr);
               } else
                   arr.add(key);
               synsetSet.add(noun);
           }
       }
       In inHypernyms = new In(hypernyms);
       this.hypernyms = new Digraph(synsetSet.size());
       while (!inHypernyms.isEmpty()) {
           String[] fields = inHypernyms.readLine().split("\\,");
           int v = Integer.parseInt(fields[0]);
           for (int i = 1; i < fields.length; i++)
               this.hypernyms.addEdge(v, Integer.parseInt(fields[i]));
       }
       DirectedCycle finder = new DirectedCycle(this.hypernyms);
       if (finder.hasCycle())
           throw new java.lang.IllegalArgumentException("Hypernyms have cycle");
   }
   
   private WordNet(WordNet wordNet) {
       hypernyms = new Digraph(wordNet.hypernyms);
       synsetSet = new HashSet<String>(wordNet.synsetSet);
       synsetsByNouns = new HashMap<String, ArrayList<Integer>>(wordNet.synsetsByNouns);
   }

   // returns all WordNet nouns
   public Iterable<String> nouns()
   {
       return synsetSet;
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word)
   {
       if (word.isEmpty())
           throw new java.lang.NullPointerException();
       return synsetsByNouns.containsKey(word);
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB)
   {
       if (nounA.isEmpty() || nounB.isEmpty())
           throw new java.lang.NullPointerException();
       if (!isNoun(nounA) || !isNoun(nounB))
           throw new java.lang.IllegalArgumentException();
       SAP sap = new SAP(hypernyms);
       ArrayList<Integer> aIDs = synsetsByNouns.get(nounA);
       ArrayList<Integer> bIDs = synsetsByNouns.get(nounB);
       
       return sap.length(aIDs, bIDs);
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB)
   {
       if (nounA.isEmpty() || nounB.isEmpty())
           throw new java.lang.NullPointerException();
       if (!isNoun(nounA) || !isNoun(nounB))
           throw new java.lang.IllegalArgumentException();
       SAP sap = new SAP(hypernyms);
       ArrayList<Integer> aIDs = synsetsByNouns.get(nounA);
       ArrayList<Integer> bIDs = synsetsByNouns.get(nounB);
       int ancestor = sap.ancestor(aIDs, bIDs);
       if (ancestor < 0)
           throw new java.lang.IllegalArgumentException("Hypernyms have no root");
       return synsetByID.get(ancestor);
   }
   
   // do unit testing of this class
   public static void main(String[] args)
   {
       WordNet wordNet = new WordNet("wordnet\\synsets.txt", "wordnet\\hypernyms.txt");
       StdOut.print(wordNet.distance("municipality", "region"));
   }
}