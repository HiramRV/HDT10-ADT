 import java.util.Iterator;
    import org.graphstream.graph.*;
    import org.graphstream.graph.implementations.*;

    
public class GraphExplore2 {
	public static void main(String args[]) {
        new GraphExplore2();
	}

public GraphExplore2(){


	Graph graph = new MultiGraph("Grafo 2");
	graph.addAttribute("ui.stylesheet", styleSheet);
	graph.setAutoCreate(true);
    graph.setStrict(false);
    graph.display();
    
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
	
    
    for (Node node : graph) {
        node.addAttribute("ui.label", node.getId());
    }

    explore(graph.getNode("B"));
}

public void explore(Node source) {
    Iterator<? extends Node> k = source.getBreadthFirstIterator();

    while (k.hasNext()) {
        Node next = k.next();
        next.setAttribute("ui.class", "marked");
        sleep();
    }
}


protected void sleep() {
    try { Thread.sleep(1000); } catch (Exception e) {}
}

protected String styleSheet =
    "node {" +
    "	fill-color: black;" +
    "}" +
    "node.marked {" +
    "	fill-color: red;" +
    "}";
}

