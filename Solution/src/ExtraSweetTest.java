import static org.junit.Assert.*;

import org.junit.Test;

public class ExtraSweetTest {

	@Test
	public void testExtraSweet1() {
		ExtraSweet obj = new ExtraSweet();
		obj.addRange(0, 9);
        assertEquals(15, obj.calcSweetness(2, 4));
        assertEquals(21, obj.calcSweetness(6, 7));
        assertEquals(9, obj.calcSweetness(9, 9));
	}

	@Test
	public void testExtraSweet2() {
		ExtraSweet obj = new ExtraSweet();
        obj.addRange(0, 9);
        assertEquals(9, obj.calcSweetness(3, 3));
        assertEquals(19, obj.calcSweetness(5, 6));
	}
	@Test
	public void testExtraSweet3() {
		ExtraSweet obj = new ExtraSweet();
        obj.addRange(0, 100);
        assertEquals(9, obj.calcSweetness(3, 3));
        assertEquals(582, obj.calcSweetness(44,53));
        assertEquals(1817, obj.calcSweetness(69,89));
        assertEquals(147, obj.calcSweetness(23,26));
        assertEquals(46, obj.calcSweetness(11,12));
        assertEquals(532, obj.calcSweetness(91,94));
        assertEquals(6, obj.calcSweetness(1,1));
        assertEquals(430, obj.calcSweetness(34,42));
        assertEquals(177, obj.calcSweetness(14,21));
        assertEquals(654, obj.calcSweetness(59,66));
        assertEquals(21, obj.calcSweetness(6,7));
		assertEquals(351, obj.calcSweetness(97,98));
		assertEquals(156, obj.calcSweetness(100,100));
		assertEquals(122, obj.calcSweetness(29,32));
	}
}
