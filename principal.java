import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Luis Nájera
 */


public class principal {
    
    
    public static void main(String args[]) {
        
        Scanner dc = new Scanner(System.in);
        String entrada;
        
        
        System.out.println("Mensaje de entrada: \n");
        entrada = dc.nextLine();
        
        /************************************************************************/
        int[] FrecuenciaCaracter = new int[256];       //Se define el máximo de caracteres (256)
        for (char caracteres : entrada.toCharArray())   //Se separa la cadena por caracteres.
            FrecuenciaCaracter[caracteres]++;          //Se almacena en un array los caracteres y su frecuencia.
        /************************************************************************/
        
        /*Se envia la frecuencia de cada caracter para crear el arbol*/
        Arbol tree = crearArbol(FrecuenciaCaracter);      //Se envia 
        
        /*Se imprimen los resultados de caracter, cantidad y codigo*/
        System.out.println("\nLetra    Cantidad       CÓDIGO");
        ImprimirCodigo(tree, new StringBuffer());
        
        /*Se ingresa el codigo a decodificar*/
        System.out.println("\n\nCodigo a decodificar: \n");
        String encode = dc.nextLine();
        
        /*Se imprime el texto decodificado*/
        System.out.println("\nTexto decodificado:");
        System.out.println(decodificador(tree,encode));

    }

	/* Crear el árbol de codificación - A partir de la cantidad de frecuencia de cada letra
	 *                                 crea un árbol binario para la compresión de texto
	 * Parámetro de entrada: arreglo con frecuencia de cada letra
	 * Parámetro de salida: el árbol binario.
	 */
    public static Arbol crearArbol(int[] FrecuenciaCaracter) {
    	
        // Se crea una cola de prioridad (PriorityQueue).
    	// La prioridad se define por la frecuencia de cada letra. 
        PriorityQueue<Arbol> cola = new PriorityQueue<>();
        



        // Se crean las hojas para cada letra    
            for (int i = 0; i < FrecuenciaCaracter.length; i++){
            if (FrecuenciaCaracter[i] > 0)
                cola.offer(new Hoja(FrecuenciaCaracter[i], (char)i)); //Se coloca el caracter en la cola dependiendo de su frecuencia. 
        }
            
            
        // Se usa un while para recorrer todos los caracteres de la cola
        // Se crea el arbol en base a la prioridad del caracter
        while (cola.size() > 1) {
            
            // Se toman los dos nodos con menor frecuencia. 
            Arbol NodoMenor1 = cola.poll();
            Arbol NodoMenor2 = cola.poll();
            /*.Poll() devuelve la próxima posición, o null si ya no hay más datos*/
 
            // Se crean los nodos del arbol.
            cola.offer(new Nodo(NodoMenor1, NodoMenor2)); 
        }
        
        // Devuelve el primer nodo del arbol (el caracter más frecuente)
        return cola.poll();
    }
 
    /* 
     * Método para recorrer el árbol.
     * Parâmetros de Entrada: Arbol, StringBuffer
     */
    public static void ImprimirCodigo(Arbol tree, StringBuffer TextoBinario) {
        
        
        if (tree instanceof Hoja) {
            Hoja leaf = (Hoja)tree;
            
            // Imprime la lista con caracter, frecuencia y codigo.
            System.out.println(leaf.value + "          " + leaf.frequency + "            " + TextoBinario);
 
        } else if (tree instanceof Nodo) {
            Nodo node = (Nodo)tree;
 
            // Coloca 0 en los nodos Izq.
            TextoBinario.append('0');
            ImprimirCodigo(node.left, TextoBinario);
            TextoBinario.deleteCharAt(TextoBinario.length()-1);
 
            // Coloca 1 en los nodos Der.
            TextoBinario.append('1');
            ImprimirCodigo(node.right, TextoBinario);
            TextoBinario.deleteCharAt(TextoBinario.length()-1);
        }
    }
    
    /* 
     * Método para compactar el codigo en una variable (salidaCodigo)
     * Parámetros de Entrada: Arbol, codigos binarios (individuales), codigo compactado
     * Parámetros de salida: Codigo compactado.
     */
    public static String getCodigo(Arbol tree, StringBuffer TextoBinario, char salidaCodigo) {
        
        if (tree instanceof Hoja) {
            Hoja leaf = (Hoja)tree;
            
            // Devuelve el texto comprimido
            if (leaf.value == salidaCodigo ){
            	return TextoBinario.toString();
            }
            
        } else if (tree instanceof Nodo) {
            Nodo node = (Nodo)tree;
 
            // Recorre la Izq. del arbol.
            TextoBinario.append('0');       
            String left = getCodigo(node.left, TextoBinario, salidaCodigo);
            TextoBinario.deleteCharAt(TextoBinario.length()-1);
 
            // Recorre la derecha del arbol.
            TextoBinario.append('1');
            String right = getCodigo(node.right, TextoBinario,salidaCodigo);
            TextoBinario.deleteCharAt(TextoBinario.length()-1);
            
            if (left==null) return right; else return left;
        }
		return null;
    }
        
    
    
    public static String decodificador (Arbol tree, String encode) {
    	
    	String decodeText="";
    	Nodo node = (Nodo)tree;
    	for (char code : encode.toCharArray()){
    		if (code == '0'){ // Si Izq. = 0.
    		    if (node.left instanceof Hoja) { 
    		    	decodeText += ((Hoja)node.left).value; //Devuelve el valor del nodo  
	                node = (Nodo)tree; // Vuelve a la raiz del arbol.
	    		}else{
	    			node = (Nodo) node.left; // Continua recorriendo el lado Izq.
	    		}
    		}else if (code == '1'){ // Si Der. = 1
    		    if (node.right instanceof Hoja) {
    		    	decodeText += ((Hoja)node.right).value; //Devuelve el valor del nodo
	                node = (Nodo)tree; // Vuelve a la raiz del arbol.
	    		}else{
	    			node = (Nodo) node.right; // Continua recorriendo el lado Der.
	    		}
    		}
    	} 
    	return decodeText; // Devuelve el texto decodificado
    }   
    
}
