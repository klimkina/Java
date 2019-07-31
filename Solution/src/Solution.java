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
There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
*/
class Solution {
	public int minimumCost(int N, int[][] conections) {
        int res = 0;
        
        int[] union = new int[N+1];
        int[] size = new int[N+1];
        for(int i = 1;  i <= N; i++)
        {
            union[i] = i;
            size[i] = 1;
        }
        int edges = 0;
        Arrays.sort(conections, (a,b)->(a[2]-b[2]));
        for(int[] conn : conections)
        {
            
            if (add(union, size, conn[0], conn[1]))
            {
                res += conn[2];
                edges++;
            }
            if (edges == N-1)
                return res;
        }
        
        return -1;
    }
    private int parent(int[] union, int kid)
    {
        while(union[kid] != kid)
        {
            kid = union[kid];
            union[kid] = union[union[kid]];
        }
        return kid;
    }
    private boolean add(int[] union, int[] size, int kid1, int kid2)
    {
        int par1 = parent(union, kid1);
        int par2 = parent(union, kid2);
        if (par1 != par2)
        {
            if(size[par1] > size[par2])
            {
                size[par1] += size[par2];
                union[par2] = par1;
            }
            else
            {
                size[par2] += size[par1];
                union[par1] = par2;
            }
            return true;
        }
        return false;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] arr = {{}};
		System.out.println(obj.minimumCost(5120, arr));
	}
}
