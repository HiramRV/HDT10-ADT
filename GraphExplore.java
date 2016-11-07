/**
*GraphExplore, clase que muestra el grafo completo 
*@version: 2.0
*@author: Andrea Maybell Pena 15127 // Steven Rubio, 15044 
*@since 2016-11-07
*/
 import java.util.Iterator;
    import org.graphstream.graph.*;
    import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


    public class GraphExplore {
    	
    		/**Atributos***/
    		private MultiGraph graph;
    		

    		/**
    	 	 * Constructor sin parametros, crea un grafo con multiples relaciones
    	 	 * @param ninguno
    	 	 * @return algo en pantalla
    	 	 */
        public GraphExplore() {
        	
        	
    		Graph graph = new MultiGraph("Grafo 1");
    		//Mostrar el grafo en pantalla
    		Viewer viewer = graph.display();
    		//Atributos de los nodos
    		graph.addAttribute("ui.stylesheet", styleSheet);
    		graph.setAutoCreate(true);
            graph.setStrict(false);
            
           
               
            //Se crean los nodos
    		graph.addNode("Per1" );
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
    		/////////////////////////////////////
    		graph.addEdge("P1-3", "Per1", "Per3");
    		graph.addEdge("P1-4", "Per1", "Per4");
    		graph.addEdge("P1-9", "Per1", "Per9");
    		graph.addEdge("P1-14", "Per1", "Per14");
    		/////////////////////////////////////
    		graph.addEdge("P2-1", "Per2", "Per1");
    		graph.addEdge("P2-3", "Per2", "Per3");
    		graph.addEdge("P2-4", "Per2", "Per4");
    		graph.addEdge("P2-12", "Per2", "Per12");
    		///////////////////////////////////////
    		graph.addEdge("P3-1", "Per3", "Per1");
    		graph.addEdge("P3-4", "Per3", "Per4");
    		///////////////////////////////////////
    		graph.addEdge("P4-5", "Per4", "Per5");
    		graph.addEdge("P4-6", "Per4", "Per6");
    		graph.addEdge("P4-11", "Per4", "Per11");
    		graph.addEdge("P4-13", "Per4", "Per13");
    		graph.addEdge("P4-14", "Per4", "Per14");
    		///////////////////////////////////////
    		graph.addEdge("P5-4", "Per5", "Per4");
    		graph.addEdge("P5-6", "Per5", "Per6");
    		graph.addEdge("P5-11", "Per5", "Per11");
    		graph.addEdge("P5-12", "Per5", "Per12");
    		graph.addEdge("P5-13", "Per5", "Per13");
    		graph.addEdge("P5-14", "Per5", "Per14");
    		///////////////////////////////////////
    		graph.addEdge("P6-4", "Per6", "Per4");
    		graph.addEdge("P6-5", "Per6", "Per5");
    		graph.addEdge("P6-12", "Per6", "Per12");
    		graph.addEdge("P6-13", "Per6", "Per13");
    		///////////////////////////////////////
    		graph.addEdge("P7-8", "Per7", "Per8");
    		graph.addEdge("P7-9", "Per7", "Per9");
    		graph.addEdge("P7-11", "Per7", "Per11");
    		///////////////////////////////////////
    		graph.addEdge("P8-6", "Per8", "Per6");
    		graph.addEdge("P8-7", "Per8", "Per7");
    		graph.addEdge("P8-9", "Per8", "Per9");
    		graph.addEdge("P8-10", "Per8", "Per10");
    		///////////////////////////////////////
    		graph.addEdge("P9-5", "Per9", "Per5");
    		graph.addEdge("P9-7", "Per9", "Per7");
    		graph.addEdge("P9-8", "Per9", "Per8");
    		///////////////////////////////////////
    		graph.addEdge("P10-4", "Per10", "Per4");
    		graph.addEdge("P10-5", "Per10", "Per5");
    		graph.addEdge("P10-6", "Per10", "Per6");
    		graph.addEdge("P10-7", "Per10", "Per7");
    		graph.addEdge("P10-11", "Per10", "Per11");
    		graph.addEdge("P10-12", "Per10", "Per12");
    		graph.addEdge("P10-13", "Per10", "Per13");
    		graph.addEdge("P10-14", "Per10", "Per14");
    		///////////////////////////////////////
    		graph.addEdge("P11-4", "Per11", "Per4");
    		graph.addEdge("P11-6", "Per11", "Per6");
    		graph.addEdge("P11-10", "Per11", "Per10");
    		graph.addEdge("P11-13", "Per11", "Per13");
    		graph.addEdge("P11-14", "Per11", "Per14");
    		///////////////////////////////////////
    		graph.addEdge("P12-4", "Per12", "Per4");
    		graph.addEdge("P12-5", "Per12", "Per5");
    		graph.addEdge("P12-6", "Per12", "Per6");
    		graph.addEdge("P12-10", "Per12", "Per10");
    		graph.addEdge("P12-11", "Per12", "Per11");
    		graph.addEdge("P12-13", "Per12", "Per13");
    		graph.addEdge("P12-14", "Per12", "Per14");
    		///////////////////////////////////////
    		graph.addEdge("P13-4", "Per13", "Per4");
    		graph.addEdge("P13-5", "Per13", "Per5");
    		graph.addEdge("P13-10", "Per13", "Per10");
    		graph.addEdge("P13-11", "Per13", "Per11");
    		graph.addEdge("P13-12", "Per13", "Per12");
    		///////////////////////////////////////
    		graph.addEdge("P14-4", "Per14", "Per4");
    		graph.addEdge("P14-10", "Per14", "Per10");
    		graph.addEdge("P14-11", "Per14", "Per11");
    		graph.addEdge("P14-12", "Per14", "Per12");
    		
 
/////////////////////////////////////////////////////////
    		
    		
    		//Se agregan atributos a los nodos
    		for (Node node : graph) {
                node.addAttribute("ui.label", node.getId());
            }

            explore(graph.getNode("Per1"));
           
          //Se muestra un tiempo en pantalla
            sleep();
            //Se cierra
            viewer.close();
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

        // Skin de los nodos 
        protected String styleSheet =
            "node {" +
            "	fill-color: black;" +
            "}" +
            "node.marked {" +
            "	fill-color: blue;" +
            "}";
    }
