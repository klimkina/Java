import java.awt.Color;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
   private static final double MAX_ENERGY = 1000;
   private Picture carvPicture;
   private Picture transPicture;
   private double[][] carvEnergy;
   private double[][] transEnergy;
   private int width, height;                        // width and height
   
   public SeamCarver(Picture picture)                // create a seam carver object based on the given picture
   {
       carvPicture = new Picture(picture);
       this.width  = picture.width();
       this.height = picture.height();
       carvEnergy = new double[carvPicture.height()][carvPicture.width()];
       for (int row = 0; row < carvPicture.height(); row++)
           for (int col = 0; col < carvPicture.width(); col++)
               carvEnergy[row][col] = calcEnergy(row, col, carvPicture);
       transEnergy = null;
       transPicture = null;
   }
   public Picture picture()                          // current picture
   {
       if (width == 0 || height == 0)
           return new Picture(0, 0);
       Picture res = new Picture(width, height);
       for (int row = 0; row < height; row++)
           for (int col = 0; col < width; col++)
               res.set(col, row, carvPicture.get(col, row)); 
       return res;
   }
   public     int width()                            // width of current picture
   {
       return width;
   }
   public     int height()                           // height of current picture
   {
       return height;
   }
   public  double energy(int col, int row)               // energy of pixel at column x and row y
   {
       if (col < 0 || col > width - 1 || row < 0 || row > height - 1)
           throw new java.lang.IndexOutOfBoundsException();
       return carvEnergy[row][col];
   }
   public   int[] findHorizontalSeam()               // sequence of indices for horizontal seam
   {
       transEnergy = transpose(carvEnergy, height, width);
       int[] res = findVerticalSeam(transEnergy, height, width);
       carvEnergy = transpose(transEnergy, width, height);
       return res;
   }
   public   int[] findVerticalSeam()                 // sequence of indices for vertical seam
   {      
       return findVerticalSeam(carvEnergy, width, height);
   }
   public    void removeHorizontalSeam(int[] seam)   // remove horizontal seam from current picture
   {
       if (seam == null)
           throw new java.lang.NullPointerException();
       if (seam.length > width)
           throw new java.lang.IllegalArgumentException("Seam is too long");
       transPicture = transpose(carvPicture, height, width);
       transEnergy = transpose(carvEnergy, height, width);
       int tempWidth = width;
       width = --height;
       height = tempWidth;
       removeVerticalSeam(seam, transPicture, transEnergy);
       height = width;
       width = tempWidth;
       carvPicture = transpose(transPicture, width, height);
       carvEnergy = transpose(transEnergy, width, height);
   }
   public    void removeVerticalSeam(int[] seam)     // remove vertical seam from current picture
   {
       width--;
       removeVerticalSeam(seam, carvPicture, carvEnergy);
       
       /*
       for (int row = 0; row < height; row++) {
           if (seam[row] < 0 || seam[row] > width)
               throw new java.lang.IllegalArgumentException("Wrong seam");
           for (int col = seam[row]; col < width; col++) { // shift to the left
               carvPicture.set(col, row, carvPicture.get(col + 1, row));
               carvEnergy[row][col] = carvEnergy[row][col + 1];
           }
           if (seam[row] > 0)
               carvEnergy[row][seam[row] - 1] = calcEnergy(row, seam[row] - 1);
           carvEnergy[row][seam[row]] = calcEnergy(row, seam[row]);
           if (row < height - 1 && row > 0 && (seam[row] - seam[row - 1] > 1 || seam[row] - seam[row - 1] < -1))
               throw new java.lang.IllegalArgumentException("Wrong seam");
       }
       */
   }
   private void removeVerticalSeam(int[] seam, Picture picture, double[][] energy)     // remove vertical seam from current picture
   {
       if (seam == null)
           throw new java.lang.NullPointerException();
       if (seam.length > height)
           throw new java.lang.IllegalArgumentException("Seam is too long");
       
       for (int row = 0; row < height; row++) {
           if (seam[row] < 0 || seam[row] > width)
               throw new java.lang.IllegalArgumentException("Wrong seam");
           for (int col = seam[row]; col < width; col++) { // shift to the left
               picture.set(col, row, picture.get(col + 1, row));
               energy[row][col] = energy[row][col + 1];
           }
           if (seam[row] > 0)
               energy[row][seam[row] - 1] = calcEnergy(row, seam[row] - 1, picture);
           energy[row][seam[row]] = calcEnergy(row, seam[row], picture);
           if (row < height - 1 && row > 0 && (seam[row] - seam[row - 1] > 1 || seam[row] - seam[row - 1] < -1))
               throw new java.lang.IllegalArgumentException("Wrong seam");
       }
       
   }
   private static Picture transpose(Picture img, int height, int width) {
       Picture out = new Picture(height, width);
       for (int x = 0; x < width; x++)
           for (int y = 0; y < height; y++)
               out.set(y, x, img.get(x, y));
       return out;
   }
   private static double[][] transpose(double[][] arr, int height, int width) {
       double[][] out = new double[width][height];
       for (int x = 0; x < height; x++)
           for (int y = 0; y < width; y++)
               out[y][x] = arr[x][y];

       return out;
   }
   private double calcEnergy(int row, int col, Picture picture)
   {
       if (row == 0 || col == 0 || // border
               row >= height - 1 || col >= width - 1)
           return MAX_ENERGY;
       double dx = diff(picture.get(col + 1, row), picture.get(col - 1, row));
       double dy = diff(picture.get(col, row + 1), picture.get(col, row - 1));
       return Math.sqrt(dx + dy);
   }
   
   private double diff(Color color1, Color color2)
   {
       return (color1.getRed() - color2.getRed()) * (color1.getRed() - color2.getRed()) +
               (color1.getGreen() - color2.getGreen()) * (color1.getGreen() - color2.getGreen()) +
               (color1.getBlue() - color2.getBlue()) * (color1.getBlue() - color2.getBlue());
   }
   private   int[] findVerticalSeam(double[][] energy, int width, int height)                 // sequence of indices for vertical seam
   {
       if (height < 1)
           return new int[0];
       double[][] distTo = new double[height][width];
       int[][] edgeTo = new int[height][width];
       for (int col = 0; col < width; col++) 
           distTo[0][col] = energy[0][col];
       for (int row = 1; row < height; row++) 
           for (int col = 0; col < width; col++) {
               distTo[row][col] = minPrevVertical(row, col, distTo[row - 1]) 
                       + energy[row][col];
               edgeTo[row - 1][col] = minPrevVerticalCol(row, col, distTo[row - 1]);
           }
       int[] res = new int[height];
       int start = 0;
       double min = Double.MAX_VALUE;
       for (int col = 1; col < width; col++) {
           if (distTo[height - 1][col] < min) {
               min = distTo[height - 1][col];
               start = col;
           }
       }
       res[height - 1] = start;
       for (int row = height - 2; row >= 0; row--) {
           res[row] = edgeTo[row][res[row + 1]];
       }
       
       return res;
   }
   private double minPrevVertical(int row, int col, double[] prevDist)
   {
       if (row < 1)
           throw new java.lang.IllegalArgumentException("No top pixels");
       if (col < 0 || col > prevDist.length - 1)
           throw new java.lang.IllegalArgumentException("Out of boundary pixel");
       if (prevDist.length == 1) // only one column
           return prevDist[0];
       if (prevDist.length == 2 || col == 0) // only 2 columns
           return Math.min(prevDist[0], prevDist[1]);
       if (col == prevDist.length - 1)
           return Math.min(prevDist[col], prevDist[col - 1]);
       return Math.min(prevDist[col - 1], 
               Math.min(prevDist[col], prevDist[col + 1]));
   }
   private int minPrevVerticalCol(int row, int col, double[] prevDist) {
       if (row < 1)
           throw new java.lang.IllegalArgumentException("No top pixels");
       if (col < 0 || col > prevDist.length - 1)
           throw new java.lang.IllegalArgumentException("Out of boundary pixel");
       if (prevDist.length == 1) // only one column
           return 0;
       if (prevDist.length == 2 || col == 0) // only 2 columns
           return (prevDist[0] < prevDist[1]) ? 0 : 1;
       if (col == prevDist.length - 1) // last column
           return (prevDist[col - 1] < prevDist[col]) ? col - 1 : col;
       if (prevDist[col - 1] > prevDist[col]) {
           if (prevDist[col] > prevDist[col + 1])
               return col + 1;
           else
               return col;
       } else {
           if (prevDist[col - 1] <= prevDist[col + 1])
               return col - 1;
           else
               return col + 1;
       }
   }
   
   public static void main(String[] args) {
       
   }
}