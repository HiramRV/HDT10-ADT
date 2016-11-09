/**
*GraphExplore2, clase que muestra el grafo reducido 
*@version: 2.0
*@author: Andrea Maybell Pena 15127 // Steven Rubio, 15044 
*@since 2016-11-07
*/

import java.util.Iterator;
    import org.graphstream.graph.*;
    import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

    
public class GraphExplore2 {
	
	/**Atributos***/
	private MultiGraph graph;
	
	
	/**
 	 * Constructor sin parametros, crea un grafo con multiples relaciones
 	 * @param ninguno
 	 * @return algo en pantalla
 	 */
public GraphExplore2(){


	Graph graph = new MultiGraph("Grafo 2");
	//Mostrar el grafo en pantalla
	Viewer viewer = graph.display();
	//Atributos de los nodos
	graph.addAttribute("ui.stylesheet", styleSheet);
	graph.setAutoCreate(true);
    graph.setStrict(false);
  
    
    
    
  //Se crean los nodos
    graph.addNode("Per2" );
	graph.addNode("Per3" );
	graph.addNode("Per4" );
	graph.addNode("Per5" );
	graph.addNode("Per6" );
	graph.addNode("Per7" );
	graph.addNode("Per8" );
	graph.addNode("Per9" );
	graph.addNode("Per10" );
	graph.addNode("Per11" );
	graph.addNode("Per12" );
	graph.addNode("Per13" );
	graph.addNode("Per14" );
	
	//Se crean las realciones
	graph.addEdge("P2-3", "Per2", "Per3");
	graph.addEdge("P4-6", "Per4", "Per6");
	graph.addEdge("P4-14", "Per4", "Per14");
	graph.addEdge("P5-13", "Per5", "Per13");
	graph.addEdge("P5-14", "Per5", "Per14");
	graph.addEdge("P6-12", "Per6", "Per12");
	graph.addEdge("P6-13", "Per6", "Per13");
	graph.addEdge("P7-8", "Per7", "Per8");
	graph.addEdge("P7-9", "Per7", "Per9");
	graph.addEdge("P8-7", "Per8", "Per7");
	graph.addEdge("P8-9", "Per8", "Per9");
	graph.addEdge("P9-7", "Per9", "Per7");
	graph.addEdge("P9-8", "Per9", "Per8");
	graph.addEdge("P10-4", "Per10", "Per4");
	graph.addEdge("P10-5", "Per10", "Per5");
	graph.addEdge("P10-13", "Per10", "Per13");
	graph.addEdge("P11-13", "Per11", "Per13");
	graph.addEdge("P12-6", "Per12", "Per6");
	graph.addEdge("P12-13", "Per12", "Per13");
	graph.addEdge("P12-14", "Per12", "Per14");
	graph.addEdge("P14-4", "Per14", "Per4");
	graph.addEdge("P14-11", "Per14", "Per11");
	
	//Se agregan atributos a los nodos
    for (Node node : graph) {
        node.addAttribute("ui.label", node.getId());
    }

    explore(graph.getNode("Per2"));
    explore(graph.getNode("Per4"));
    explore(graph.getNode("Per8"));
 
    //Se muestra un tiempo en pantalla
    sleep();
    //Se cierra
    //viewer.close();
}


/**
 * Hace un delay entre procesos 
 * @param none
 * @return  none
 */
protected void sleep() {
    try { Thread.sleep(5000); } catch (Exception e) {}
}

/**
	 * Recorre todos los nodos y les agrega los atributos que mostraran 
	 * @param Node
	 * @return void
	 */
public void explore(Node source) {
    Iterator<? extends Node> k = source.getBreadthFirstIterator();

    while (k.hasNext()) {
        Node next = k.next();
        next.setAttribute("ui.class", "marked");
    }
}

//Skin de los nodos 
protected String styleSheet =
    "node {" +
    "	fill-color: black;" +
    "}" +
    "node.marked {" +
    "	fill-color: green;" +
    "}";
}

