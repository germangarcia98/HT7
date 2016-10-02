/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/



abstract class Arbol implements Comparable<Arbol> {
    public final int frequency; 
    
    public Arbol(int freq) { 
    	frequency = freq; 
    }
    
    
    public int compareTo(Arbol tree) {
        return frequency - tree.frequency;
    }
    
}
