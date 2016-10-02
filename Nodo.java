
/**
 *
 * @author Luis Nájera
 */
class Nodo extends Arbol {
    public final Arbol left, right; // sub-árvores
 
    public Nodo(Arbol l, Arbol r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
