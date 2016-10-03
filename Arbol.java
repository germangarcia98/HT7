/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/

/*
* Clase para la implementacion del Arbol 
*/


abstract class Arbol implements Comparable<Arbol> {
    public final int frecuencia; 
    
    public Arbol(int freq) { 
    	frecuencia = freq; 
    }
    
    // Se utiliza para las frecuencias, con lo cual se implementa Comparable para el orden de las filas
    public int compareTo(Arbol tree) {
        return frecuencia - tree.frecuencia;
    }
    
}
