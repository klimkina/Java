import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
	static class Worker
	{
		int q;
		int w;
		public Worker(int q1, int w1)
		{
			q = q1;
			w = w1;
		}
	}
	public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		int n = quality.length;
		Worker[] workers = new Worker[n];
		for (int i = 0; i < n; i++)
			workers[i] = new Worker(quality[i], wage[i]);
		Arrays.sort(workers, (a,b) -> ((int)((double)a.w/a.q - (double)b.w/b.q)));
		
		int sum = 0;
		double res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++)
		{
			sum += workers[i].q;
			pq.offer(-workers[i].q);
			if (i == K-1)
				res = (double)sum*workers[i].w/workers[i].q;
			else if (i >= K)
			{
				sum += pq.poll();
				res = Math.min(res, (double)sum*workers[i].w/workers[i].q);
			}
		}
        return res;
    }
    
	
	public static void main(final String[] args) {
		int[] qual = {25,68,35,62,52,57,35,83,40,51};
		int[] wage = {147,97,251,129,438,443,120,366,362,343};
		int K =	2;
		System.out.print(mincostToHireWorkers(qual, wage, K));
	}
}
