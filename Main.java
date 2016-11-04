import java.io.File;
import java.util.Vector;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Main {

	public static void main(String[] args) {
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		File file= new File("C:/Users/AndreaMaybell/Documents/AMPE/deberes/Algoritmos y Estructuras de Datos/BaseHoja10");
		GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);
		
		try (Transaction tx = db.beginTx()) {
			
			//Node node1= db.findNode(Labels.Persona, "nombre", "Per1");
			//System.out.println(node1.getId()); //el Id de Per1 es 0
			Vector<Integer> vector1= new Vector<Integer>();
			Vector<Long> vector2= new Vector<Long>();
			for(int i=0; i<196; i++){
			try{
				Relationship rel= db.getRelationshipById(i);
				long cant= (long) rel.getProperty("cant");
				vector1.addElement(i);
				vector2.addElement(cant);
				//System.out.println(cant);
			}
			catch (Exception e)
			{
				//System.out.println(i+" no es relación");
			}}
			
			//relaciones con más de 6 correos
			String masD6= "Relaciones con más de 6 correos \n";
			for(int j=0; j<vector1.size(); j++){
				if(vector2.get(j)>6){
				masD6= masD6 + db.getRelationshipById(vector1.get(j)).getStartNode().getProperty("nombre");
				masD6= masD6 + " envió "+ vector2.get(j) + " correos a: ";
				masD6= masD6 + db.getRelationshipById(vector1.get(j)).getEndNode().getProperty("nombre");
				masD6= masD6 + "\n";
			}}
			System.out.println(masD6);
			
			//eliminar relaciones de autoenvío 
			
			for(int k=0; k<vector1.size(); k++)
			{
				Relationship r= db.getRelationshipById(vector1.get(k));
				if (r.getStartNode() == r.getEndNode())
				{
					System.out.println(r.getId());
					System.out.println(r.getStartNode().getProperty("nombre")+" a "+ r.getEndNode().getProperty("nombre"));
					//r.delete();
				}
			}
			tx.success();
		}
	}

}
