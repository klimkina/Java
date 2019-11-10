import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 */
class Solution {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] word_scores = new int[n];
        int[][] word_letters = new int[n][26];
        int[] let_count = new int[26];
        for(int i = 0; i < letters.length; i++)
            let_count[letters[i] - 'a']++; 
        for(int j = 0; j < n; j++)
            for(int i = 0; i < words[j].length(); i++)
                word_letters[j][words[j].charAt(i) - 'a']++; 
        for(int j = 0; j < n; j++)
        {
            for(int i = 0; i < 26; i++)
            {
                if (word_letters[j][i] > let_count[i])
                {
                    word_scores[j] = 0;
                    break;
                }
                word_scores[j] += score[i]* word_letters[j][i];
            }
        }
        return maxScoreWords(word_letters, let_count, word_scores, 0);
    }
    private int maxScoreWords(int[][] word_letters, int[] let_count, int[] word_scores, int start) {
        if (start >= word_scores.length)
            return 0;
        if(word_scores[start] == 0 || getScore(let_count, word_letters[start]) == 0)
            return maxScoreWords(word_letters, let_count, word_scores, start + 1);
        
        for(int i = 0; i < 26; i++)
            let_count[i] -= word_letters[start][i];
        int res2 = maxScoreWords(word_letters, let_count, word_scores, start + 1) + word_scores[start];
        for(int i = 0; i < 26; i++)
            let_count[i] += word_letters[start][i];
        int res1 = maxScoreWords(word_letters, let_count, word_scores, start + 1);
        return Math.max(res1, res2);
    }
    private int getScore(int[] let_count, int[] word_count)
    {
    	for(int i = 0; i < 26; i++)
        {
            if (word_count[i] > let_count[i])
            	return 0;
        }
    	return 1;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String[] words = {"dog","cat","dad","good"};
		char[] letters = {'a','a','c','d','d','d','g','o','o'};
		int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(obj.maxScoreWords(words, letters, score));
	}
}
