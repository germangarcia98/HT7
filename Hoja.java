/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/


class Hoja extends Arbol {
    public final char value; 

    public Hoja(int freq, char val) {
        super(freq);
        value = val;
    }
}
