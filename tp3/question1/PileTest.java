package question1;

public class PileTest extends junit.framework.TestCase {

    private Pile pile1;

    public PileTest() {
    }

    protected void setUp()
    {
        System.out.println("Debut test");
        pile1 = new Pile(3);
    }

    protected void tearDown()
    {
        pile1 = null;
        System.out.println("Fin Test");
    }

    public void testEncourageant(){
        assertTrue(true);
    }

    public void test_Pile_estPleine() throws Exception {
        pile1.empiler(3);
        pile1.empiler(2);
        pile1.empiler(1);

        assertEquals(true, pile1.estPleine());
        
        try {
            pile1.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_estVide() throws Exception {
        assertEquals(true, pile1.estVide());
        try {
            Object r = pile1.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());
    }
}