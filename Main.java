import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Main {

	public static void main(String[] args) {
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		File file= new File("C:/Users/AndreaMaybell/Documents/AMPE/deberes/Algoritmos y Estructuras de Datos/BaseHoja10");
		GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);
		
		try (Transaction tx = db.beginTx()) {
			
			Node node1= db.findNode(Labels.Persona, "nombre", "Per1");
			System.out.println(node1.getId()); //el Id de Per1 es 0
			
			tx.success();
		}
	}

}
