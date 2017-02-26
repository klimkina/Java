import java.util.HashMap;
import java.util.ArrayList;;
class Person {
  public static HashMap<Integer, ArrayList<Integer>> sort_scores(int[] unsorted_scores, int HIGHEST_POSSIBLE_SCORE) {
      HashMap<Integer, ArrayList<Integer>> res = new HashMap<Integer, ArrayList<Integer>>();
      for (int i : unsorted_scores){
          if (res.containsKey(HIGHEST_POSSIBLE_SCORE - i))
              res.get(HIGHEST_POSSIBLE_SCORE - i).add(i);
          else {
              ArrayList<Integer> temp = new ArrayList<Integer>();
              temp.add(i);
              res.put(HIGHEST_POSSIBLE_SCORE - i, temp);
          }
      }
      return res;
  }
  public static void main(String[] args) {
      int[] unsorted_scores = {37, 37, 89, 41, 65, 53, 91, 53};
      int  HIGHEST_POSSIBLE_SCORE = 100;
      HashMap<Integer, ArrayList<Integer>> res = sort_scores(unsorted_scores, HIGHEST_POSSIBLE_SCORE);
      for (int i = 0; i < HIGHEST_POSSIBLE_SCORE; i++){
          ArrayList<Integer> score = res.get(i);
          if (score != null) 
              for (int j : score)
                  System.out.println(j);
      }
  }  
}