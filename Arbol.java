
/**
 *
 * @author Luis Nájera
 */
abstract class Arbol implements Comparable<Arbol> {
    public final int frequency; // 
    
    public Arbol(int freq) { 
    	frequency = freq; 
    }
    
    // Compara as frequências - Implementação da Interface Comparable para a ordenação na fila
    @Override
    public int compareTo(Arbol tree) {
        return frequency - tree.frequency;
    }
    
}
