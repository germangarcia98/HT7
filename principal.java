import java.util.*;
import java.util.Scanner;

/**
 *  Universidad del Valle de Guatemala, Algoritmos y Estructuras de Datos, Seccion 20
 *  @author German Garcia 15008
 *  @author Luis Nájera 15581.
 *  version 02.10.16
 **/


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
        
        /*Se instancia Arbol*/
        /*Se envia la frecuencia de cada caracter*/
        Arbol tree = crearArbol(FrecuenciaCaracter);      //Se envia 
        
        /*Se imprimen los resultados*/
        System.out.println("\nLetra    Cantidad       CÓDIGO");
        ImprimirCodigo(tree, new StringBuffer());
        
        
        System.out.println("\n\nCodigo a decodificar: \n");
        String encode = dc.nextLine();
        
        System.out.println("\nTEXTO DECODIFICADO");
        System.out.println(decode(tree,encode));

    }

	
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
    
    
    public static String getCodigo(Arbol tree, StringBuffer prefix, char w) {
        
        if (tree instanceof Hoja) {
            Hoja leaf = (Hoja)tree;
            
            // Retorna o texto compactado da letra
            if (leaf.value == w ){
            	return prefix.toString();
            }
            
        } else if (tree instanceof Nodo) {
            Nodo node = (Nodo)tree;
 
            
            prefix.append('0');
            String left = getCodigo(node.left, prefix, w);
            prefix.deleteCharAt(prefix.length()-1);
 
            
            prefix.append('1');
            String right = getCodigo(node.right, prefix,w);
            prefix.deleteCharAt(prefix.length()-1);
            
            if (left==null) return right; else return left;
        }
		return null;
    }
        
    
    
    public static String decode(Arbol tree, String encode) {
    	assert tree != null;
    	
    	String decodeText="";
    	Nodo node = (Nodo)tree;
    	for (char code : encode.toCharArray()){
    		if (code == '0'){ 
    		    if (node.left instanceof Hoja) { 
    		    	decodeText += ((Hoja)node.left).value;  
	                node = (Nodo)tree; 
	    		}else{
	    			node = (Nodo) node.left;  
	    		}
    		}else if (code == '1'){ 
    		    if (node.right instanceof Hoja) {
    		    	decodeText += ((Hoja)node.right).value; 
	                node = (Nodo)tree; 
	    		}else{
	    			node = (Nodo) node.right; 
	    		}
    		}
    	} 
    	return decodeText; 
    }   
    
}
