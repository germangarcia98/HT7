/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/

/*
* Clase para la creacion de Hojas
*/


class Hoja extends Arbol {
    public final char valorL; // Se asigna una letra a una Hoja
 
    public Hoja(int freq, char val) {
        super(freq);
        valorL = val;
    }
}
