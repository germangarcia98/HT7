/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/


class Nodo extends Arbol {
    public final Arbol left, right;  
    public Nodo(Arbol l, Arbol r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
