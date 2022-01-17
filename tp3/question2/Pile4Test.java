package question2;

/**
 * Classe-test Pile4Test.
 * 
 * @author (votre nom)
 * @version (un numé?ro de version ou une date)
 * 
 *          Les classes-test sont documenté?es ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basé?es sur le document ©? 2002 Robert A. Ballance intitulé?
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associé?s aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque mé?thode Test à
 *          exé?cuter. Il peut y avoir plus d'une mé?thode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ dé?couvrira
 *          automatiquement (par introspection) les mé?thodes Test de votre
 *          classe Test et gé?né?rera la TestSuite consé?quente. Chaque appel d'une
 *          mé?thode Test sera pré?cé?dé? d'un appel de setUp(), qui ré?alise les
 *          engagements, et suivi d'un appel à tearDown(), qui les dé?truit.
 */
public class Pile4Test extends junit.framework.TestCase {
    // Dé?finissez ici les variables d'instance né?cessaires à vos engagements;
    // Vous pouvez é?galement les saisir automatiquement du pré?sentoir
    // à l'aide du menu contextuel "Pré?sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pré?sentoir (les objets sans constructeur, comme int, float, etc.).

    private PileI p1;
    private PileI p2;
    /**
     * Constructeur de la classe-test Pile4Test
     */
    public Pile4Test() {
    }

    /**
     * Met en place les engagements.
     * 
     * Mé?thode appelé?e avant chaque appel de mé?thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        System.out.println("Debut test");
        p1 = new question2.Pile4();
        p2 = new question2.Pile4();
    }

    /**
     * Supprime les engagements
     * 
     * Mé?thode appelé?e après chaque appel de mé?thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libé?rez ici les ressources engagé?es par setUp()
        p1 = null;
        p2 = null;
        System.out.println("Fin test");
    }
    
    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }
    
    public void test_Pile_estPleine() throws Exception {
        PileI p = new question2.Pile4(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }
    
    public void test_Pile_sommet() throws Exception {
        PileI p = new question2.Pile4(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }
    
    public void test_Pile_estVide() throws Exception {
        PileI p = new question2.Pile4(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }
    
    public void test_Pile_toString() throws Exception {
        PileI pile1 = new question2.Pile4(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }
    
    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile4(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }
    
    public void test_Pile_equals() throws Exception {

        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);

        assertTrue("é?galité? de deux piles ? ", p1.equals(p2));
        assertTrue("é?galité? de deux piles ? ", p2.equals(p1));
        assertTrue("é?galité? de deux piles ? ", p1.equals(p1));

        p2.empiler(1);
        assertFalse("é?galité? de deux piles ? ", p1.equals(p2));

    }

}