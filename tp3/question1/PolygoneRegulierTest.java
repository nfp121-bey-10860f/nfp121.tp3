package question1;

public class PolygoneRegulierTest extends junit.framework.TestCase {
    private PolygoneRegulier p1;
    private PolygoneRegulier p2;
    private PolygoneRegulier p3;

    public void setUp() {
        p1 = new PolygoneRegulier(4, 100);
        p2 = new PolygoneRegulier(5, 100);
        p3 = new PolygoneRegulier(4, 100);
    }

    public void testEquals_hashCode() {
        assertFalse(p1.equals(p2));

        assertTrue(p1.equals(p3));
        assertTrue(p3.equals(p1));
        assertEquals(p1.hashCode(), p3.hashCode());
    }
}