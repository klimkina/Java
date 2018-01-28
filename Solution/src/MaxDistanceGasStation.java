
public class MaxDistanceGasStation {
	public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
		double low = 0, high = stations[n - 1], m = 0, d;
		int i, j, t;

		while (high - low >= 0.0000001) {
			m = (high + low) / 2;
			t = K;
			for (i = 0; i < n - 1; i++) {
				d = stations[i + 1] - stations[i];
				if (d > m) 
					t -= Math.ceil((d / m) - 1);
			}
			if (t < 0) low = m;
			else high = m;
		}
		return m;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDistanceGasStation obj = new MaxDistanceGasStation();
		int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int K = 9;
		System.out.println(obj.minmaxGasDist(stations, K));
	}

}
