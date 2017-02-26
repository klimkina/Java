import static org.junit.Assert.*;
import org.junit.Test;
import edu.princeton.cs.algs4.Picture;
import java.awt.Color;

public class SeamCarverTest {

    /*
    @Test
    public void test4x6() {
        Picture picture = new Picture("seamCarving\\4x6.png");
        SeamCarver carver = new SeamCarver(picture);
        int[] seam = carver.findVerticalSeam();
        carver.removeVerticalSeam(seam);
        4x6.png (4-by-6 image)

        The table gives the dual-gradient energies of each pixel.
        The asterisks denote a minimum energy vertical or horizontal seam.

        Vertical seam: { 1 2 1 1 2 1 }
        1000.00  1000.00* 1000.00  1000.00  
        1000.00   275.66   173.21* 1000.00  
        1000.00   173.21*  321.01  1000.00  
        1000.00   171.80*  195.63  1000.00  
        1000.00   270.93   188.15* 1000.00  
        1000.00  1000.00* 1000.00  1000.00  
        Total energy = 2706.370116


        Horizontal seam: { 1 2 1 0 }
        1000.00  1000.00  1000.00  1000.00* 
        1000.00*  275.66   173.21* 1000.00  
        1000.00   173.21*  321.01  1000.00  
        1000.00   171.80   195.63  1000.00  
        1000.00   270.93   188.15  1000.00  
        1000.00  1000.00  1000.00  1000.00  
        Total energy = 2346.424595



    }
*/
    @Test
    public void test5x6() {
        Picture picture = new Picture("seamCarving\\5x6.png");
        int[] resVerticalSeam = { 1, 2, 2, 3, 2, 1 };
        double[][] aimEnergy = {
                { 1000.00,  1000.00, 1000.00,  1000.00,  1000.00 },  
                { 1000.00,   300.07,   265.33,  289.67,  1000.00 },  
                { 1000.00,   311.94,    94.36,  309.61,  1000.00 },  
                { 1000.00,   295.49,   312.36,   193.36, 1000.00 }, 
                { 1000.00,   264.36,   216.49,  299.43,  1000.00 },  
                { 1000.00,  1000.00, 1000.00,  1000.00,  1000.00 } 
        };
        SeamCarver verticalCarver = new SeamCarver(picture);
        for (int row = 0; row < picture.height(); row++)
            for (int col = 0; col < picture.width(); col++)
                assertEquals(verticalCarver.energy(col, row), aimEnergy[row][col], 0.01);
        int[] verticalSeam = verticalCarver.findVerticalSeam();
        checkSeam(resVerticalSeam, verticalSeam);
        verticalCarver.removeVerticalSeam(verticalSeam);
        double[][] newEnergy = {
                { 1000.00,  1000.00,  1000.00,  1000.00 },  
                { 1000.00,   301.53,   200.20,  1000.00 },  
                { 1000.00,   291.29,    119.92,  1000.00 },  
                { 1000.00,   295.49,   325.66,   1000.00 }, 
                { 1000.00,   278.74,   256.36,  1000.00 },  
                { 1000.00,  1000.00,  1000.00,  1000.00 } 
        };
        for (int row = 0; row < 6; row++)
            for (int col = 0; col < 4; col++)
                assertEquals(verticalCarver.energy(col, row), newEnergy[row][col], 0.01);
       
    }
    @Test
    public void test5x6Horizontal() {
        Picture picture = new Picture("seamCarving\\5x6.png");
        
        int[] resHorizontalSeam = { 2, 3, 2, 3, 2 };
        SeamCarver horizontalCarver = new SeamCarver(picture);
        int[] horizontalSeam = horizontalCarver.findHorizontalSeam();
        checkSeam(resHorizontalSeam, horizontalSeam);
        horizontalCarver.removeHorizontalSeam(horizontalSeam);
        horizontalSeam = horizontalCarver.findHorizontalSeam();
        horizontalCarver.removeHorizontalSeam(horizontalSeam);
        horizontalSeam = horizontalCarver.findHorizontalSeam();
        horizontalCarver.removeHorizontalSeam(horizontalSeam);
        horizontalSeam = horizontalCarver.findHorizontalSeam();
        horizontalCarver.removeHorizontalSeam(horizontalSeam);
        horizontalSeam = horizontalCarver.findHorizontalSeam();
        horizontalCarver.removeHorizontalSeam(horizontalSeam);
    }
    private void checkSeam(int[] resSeam, int[] seam) {
        assertEquals(resSeam.length, seam.length);
        for (int i = 0; i < resSeam.length; i++)
            assertEquals(resSeam[i], seam[i]);
    }

    @Test
    public void test1x8() {
        Picture picture = new Picture("seamCarving\\1x8.png");
        int[] res = { 0, 0, 0, 0, 0, 0, 0, 0};
        SeamCarver carver = new SeamCarver(picture);
        int[] seam = carver.findVerticalSeam();
        checkSeam(res, seam);
        carver.removeVerticalSeam(seam);
        assertEquals(carver.width(), 0);
    }

    @Test
    public void test8x1() {
        Picture picture = new Picture("seamCarving\\8x1.png");
        int[] res = { 1};
        Color[] resPicture = new Color[8];
        for (int i = 0; i < 8; i++)
            resPicture[i] = picture.get(i, 0);
        
        SeamCarver carver = new SeamCarver(picture);
        int[] seam = carver.findVerticalSeam();
        checkSeam(res, seam);
        carver.removeVerticalSeam(seam);
        
        Picture carvPicture = carver.picture();
        assertEquals(carver.picture().width(), 7);
        assertEquals(carvPicture.get(0, 0), resPicture[0]);
        for (int i = 2; i < 8; i++)
            assertEquals(carvPicture.get(i - 1, 0), resPicture[i]);
    }
    @Test
    public void test3x7() {
        Picture picture = new Picture("seamCarving\\3x7.png");
        int[] res = { 0, 1, 1, 1, 1, 1, 1};
        SeamCarver carver = new SeamCarver(picture);
        int[] seam = carver.findVerticalSeam();
        checkSeam(res, seam);
        carver.removeVerticalSeam(seam);
        assertEquals(carver.width(), 2);
        seam = carver.findVerticalSeam();
        carver.removeVerticalSeam(seam);
        assertEquals(carver.width(), 1);
        seam = carver.findVerticalSeam();
        carver.removeVerticalSeam(seam);
        assertEquals(carver.width(), 0);
        /*
        1000.00* 1000.00  1000.00  
        1000.00   294.32* 1000.00  
        1000.00   236.17* 1000.00  
        1000.00   325.15* 1000.00  
        1000.00   251.36* 1000.00  
        1000.00   279.64* 1000.00  
        1000.00* 1000.00  1000.00  
        Total energy = 3386.629883


        Horizontal seam: { 1 2 1 }
        1000.00  1000.00  1000.00  
        1000.00*  294.32  1000.00* 
        1000.00   236.17* 1000.00  
        1000.00   325.15  1000.00  
        1000.00   251.36  1000.00  
        1000.00   279.64  1000.00  
        1000.00  1000.00  1000.00  
        Total energy = 2236.167314
        */


    }
/*
    @Test
    public void testStripes() {
        Picture picture = new Picture("seamCarving\\stripes.png");
        SeamCarver carver = new SeamCarver(picture);
        int[] seam = carver.findVerticalSeam();
        carver.removeVerticalSeam(seam);
        stripes.png (9-by-12 image)

        The table gives the dual-gradient energies of each pixel.
        The asterisks denote a minimum energy vertical or horizontal seam.

        Vertical seam: { 0 1 1 1 1 1 1 1 1 1 1 0 }
        1000.00* 1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67*  441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00* 1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        Total energy = 6416.729559


        Horizontal seam: { 0 1 1 1 1 1 1 1 0 }
        1000.00* 1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00* 
        1000.00   441.67*  441.67*  441.67*  441.67*  441.67*  441.67*  441.67* 1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00   441.67   441.67   441.67   441.67   441.67   441.67   441.67  1000.00  
        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        Total energy = 5091.710692



    }
*/
}
