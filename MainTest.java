import static org.junit.Assert.*;

import java.io.File;
import java.util.Vector;

import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class MainTest {

	GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
	//Se abre el archivo con la base de datos de Neo4j
	// ***ojo, modificar este valor segun donde se almacene la base de neo4j **** ////
	File file= new File("C:/Users/AndreaMaybell/Documents/AMPE/deberes/Algoritmos y Estructuras de Datos/BaseHoja10");
	GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);
	

	@Test
	public void test() {
		try (Transaction tx = db.beginTx()) {
			
			Vector<Integer> vectorId= new Vector<Integer>();
			Vector<Long> vectorCant= new Vector<Long>();
			for(int i=0; i<196; i++){
				try{
					Relationship rel= db.getRelationshipById(i);
					long cant= (long) rel.getProperty("cant");
					vectorId.addElement(i);
					vectorCant.addElement(cant);
				}
				catch (Exception e)
				{
					
				}}
			long c= (long)db.getRelationshipById(vectorId.get(1)).getProperty("cant");
			assertEquals(c,2);//para la segunda relacion la cantidad de correos es de 2
			long id= db.getRelationshipById(vectorId.get(1)).getStartNode().getId();
			assertEquals(id,0);//la segunda relacion inica en la persona 1 con id=0
			tx.success();
	}}

}
