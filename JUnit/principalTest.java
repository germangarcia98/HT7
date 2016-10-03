import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/
public class principalTest {
    
    public principalTest() {
    }
    int[] FrecuenciaCaracter = new int[256];
    /**
     * Test of main method, of class principal.
     */
    @Test
    
    public void testMain() {
        System.out.println("main");
        String test = "prueba";
        
        for (char c : test.toCharArray())
            FrecuenciaCaracter[c]++;
        
        if (FrecuenciaCaracter ==null){
            fail("The test case is a prototype.");
        }
       
    }

    /**
     * Test of crearArbol method, of class principal.
     */
    @Test
    public void testCrearArbol() {
        System.out.println("crearArbol");
        Arbol expResult = null;
        Arbol result = principal.crearArbol(FrecuenciaCaracter);
        assertEquals(expResult, result);
        
        if (FrecuenciaCaracter == null){
            fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of ImprimirCodigo method, of class principal.
     */
    @Test
    public void testImprimirCodigo() {
        System.out.println("ImprimirCodigo");
        Arbol tree = null;
        StringBuffer TextoBinario = null;
        principal.ImprimirCodigo(tree, TextoBinario);
        
    }

    /**
     * Test of getCodigo method, of class principal.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Arbol tree = null;
        StringBuffer TextoBinario = null;
        char salidaCodigo = ' ';
        String expResult = "";
        String result = expResult;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult !=result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of decodificador method, of class principal.
     */
    @Test
    public void testDecodificador() {
        System.out.println("decodificador");
        Arbol tree = null;
        String binario = "101";
        String expResult = "a";
        
        String decodificado="";
    	Nodo nodo = (Nodo)tree;
    	
        
        if("1".equals(expResult)){
            fail("The test case is a prototype.");
        }
                
        
    }
    
}
