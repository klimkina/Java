
public class LoveRectangle {
	int left_x;
	int bottom_y;
	int width;
	int height;
	public LoveRectangle(int x, int y, int width, int height) {
		left_x = x;
		bottom_y = y;
		this.width = width;
		this.height = height;
	}
	public LoveRectangle intersection(LoveRectangle that) {
		int x = Math.max(this.left_x, that.left_x);
		int y = Math.max(this.bottom_y, that.bottom_y);
		int width = Math.min(this.left_x + this.width, that.left_x + that.width) - x;
		int height = Math.min(this.bottom_y + this.height, that.bottom_y + that.height) - y;
		if(width > 0 && height > 0)
			return new LoveRectangle(x, y, width, height);
		return null;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoveRectangle rec1 = new LoveRectangle(1,1,2,2);
		LoveRectangle rec2 = new LoveRectangle(4,4,4,4);
		LoveRectangle rec3 = rec1.intersection(rec2);
	}

}
