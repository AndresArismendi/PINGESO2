/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import java.util.List;
import javax.ejb.Local;
import otrasclases.ParTerminos;

/**
 *
 * @author alonso
 */
@Local
public interface Neo4JLocal {
    // Entrega la profundidad del arbol
    int profundidad();
    
    // Método Lambda.
    // 0 en la misma jerarquia.
    // 1 en la misma vecindad.
    int lambda(int _accessionTerminoUno, int _accessionTerminoDos);
    
    // Recibe dos accession y retorna true si uno es ancestro del otro, retorna
    // false en otro caso.
    boolean esAncestro(int _accessionTerminoUno, int _accessionTerminoDos);
    
    // Obtiene la probabilidad de un nodo.
    float probabilidad(int _accessionTermino);
    
    // Optimizacion de los ancestros comunes minimos
    List<Integer> ancestrosComunesMinimos(List<ParTerminos> _listaParTerminos);
    
    // Retorna las distancias. Corta.
    // No sirve de mucho tal como esta. hay que cambiar la clase ParTerminos. Corta
    List<Integer> distancias(List<ParTerminos> _listaParTerminos);
    
    // Entrega la raiz de un grafo
    int raiz();

    // Carga la base de datos del proyecto.
    // Recibe la ruta en la que se encuentra el archivo csv.
    // El formato para la ruta debe ser este: "file:c:/Users/alonso/Desktop/archivo.csv".
    void cargaBaseDeDatos(String path);
    
    // Recibe el accession de un término y retorna una lista con los accession's de sus padres.
    List<Integer> padres(int accession);

    // Recibe una query en String y retorna un List<String> con la respuesta de la bd
    List<String> consulta(String _query);

    // Dados los ids de dos nodos, retorna el id del ancestro común mínimo.
    int ancestroComunMinimo(int idNodoUno, int idNodoDos);

    // Dado los accession de dos nodos, retorna la distancia entre ellos
    int distancia(int accessionUno, int accessionDos);

    // Dado un nodo retorna su nivel en el árbol
    int nivel(int idNodo);

    // Dado dos nodos, retorna true si estos estan en la misma jerarquia. Dos
    // nodos están en la misma jerarquía cuando estan el mismo nivel de 
    // profundidad con respecto al nodo raiz.
    boolean mismaJerarquia(int idNodoUno, int NodoDos);


    // Dado dos nodos, retorna true si estos estan en la misma vecindad
    boolean mismaVecindad(int idNodoUno, int idNodoDos);

    // Retorna true si accessionUno es padre de accessionDos, retorna false en otro caso.
    boolean esPadre(int accessionUno, int accessionDos);

    // Dado los ids de dos nodos, retorna true si el nodoUno es padre del nodoDos
    boolean esHijo(int idNodoUno, int idNodoDos);


}
