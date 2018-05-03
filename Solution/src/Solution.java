import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n) 
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }
     
    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n)
    {
        if(n > 0)
        _printParenthesis(str, 0, n, 0, 0);
        return;
    }
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }*/
    	int n = 4;
        char[] str = new char[8];
        printParenthesis(str, n);
    }
}
