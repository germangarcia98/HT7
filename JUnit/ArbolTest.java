import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/
public class ArbolTest {
    
    public ArbolTest() {
    }

    /**
     * Test of compareTo method, of class Arbol.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        int frecuencia = 5;
        
        Arbol tree = null;
        Arbol instance = null;
        if (frecuencia == 0){
            fail("The test case is a prototype.");
        }
    }

    public class ArbolImpl extends Arbol {

        public ArbolImpl() {
            super(0);
        }
    }
    
}
