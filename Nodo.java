/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/

/*
* Clase para creacion de Nodos
*/

class Nodo extends Arbol {
    public final Arbol left, right; // Se utiliza para los arboles generados a partir de la raiz
 
    public Nodo(Arbol izq, Arbol der) {
        super(izq.frecuencia + der.frecuencia);
        left = izq;
        right = der;
    }
}
