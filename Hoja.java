
/**
 *
 * @author Luis Nájera
 */

class Hoja extends Arbol {
    public final char value; // A letra é atribuida a um nó folha 
 
    public Hoja(int freq, char val) {
        super(freq);
        value = val;
    }
}
