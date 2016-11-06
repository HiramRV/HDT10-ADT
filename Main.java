import java.io.File;
import java.util.Vector;

import org.neo4j.graphdb.Direction;
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
			
			//Node node1= db.findNode(Labels.Persona, "nombre", "Per1");
			//System.out.println(node1.getId()); //el Id de Per1 es 0
			Vector<Integer> vectorId= new Vector<Integer>();
			Vector<Long> vectorCant= new Vector<Long>();
			for(int i=0; i<196; i++){
			try{
				Relationship rel= db.getRelationshipById(i);
				long cant= (long) rel.getProperty("cant");
				vectorId.addElement(i);
				vectorCant.addElement(cant);
				//System.out.println(cant);
			}
			catch (Exception e)
			{
				//System.out.println(i+" no es relación");
			}}
			
			//relaciones con más de 6 correos
			String masD6= "Relaciones con más de 6 correos \n";
			for(int j=0; j<vectorId.size(); j++){
				if(vectorCant.get(j)>6){
				masD6= masD6 + db.getRelationshipById(vectorId.get(j)).getStartNode().getProperty("nombre");
				masD6= masD6 + " envió "+ vectorCant.get(j) + " correos a: ";
				masD6= masD6 + db.getRelationshipById(vectorId.get(j)).getEndNode().getProperty("nombre");
				masD6= masD6 + "\n";
			}}
			System.out.println(masD6);
			
			//eliminar relaciones de autoenvío 
			
			for(int k=0; k<vectorId.size(); k++)
			{
				Relationship r= db.getRelationshipById(vectorId.get(k));
				if (r.getStartNode() == r.getEndNode())
				{
					System.out.println(r.getId());
					System.out.println(r.getStartNode().getProperty("nombre")+" a "+ r.getEndNode().getProperty("nombre"));
					//r.delete();
				}
			}
			
			//PageRank
			Vector<Double> PR1= new Vector<Double>();
			Vector<Double> C= new Vector<Double>();
			for (int l=0; l<14; l++)
			{
				PR1.add(l, (double)db.getNodeById(l).getDegree(Direction.INCOMING));
				//System.out.println("PR1 "+l+": "+PR1.get(l));
				C.add(l, (double)db.getNodeById(l).getDegree(Direction.OUTGOING));
				//System.out.println("C "+l+": "+C.get(l));
			}
			
			Vector<Double> PR2= new Vector<Double>();
			double c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c10=0,c11=0,c12=0,c13=0,c14=0;
			for (int m=0; m<vectorId.size(); m++)
			{
				Relationship r2= db.getRelationshipById(vectorId.get(m));
				int n1= (int) r2.getEndNode().getId();
				int n2= (int) r2.getStartNode().getId();
				if (n1==0)
					c1=c1+((PR1.get(n2))/(C.get(n2)));
				if (n1==1)
					c2=c2+((PR1.get(n2))/(C.get(n2)));
				if (n1==2)
					c3=c3+((PR1.get(n2))/(C.get(n2)));
				if (n1==3)
					c4=c4+((PR1.get(n2))/(C.get(n2)));
				if (n1==4)
					c5=c5+((PR1.get(n2))/(C.get(n2)));
				if (n1==5)
					c6=c6+((PR1.get(n2))/(C.get(n2)));
				if (n1==6)
					c7=c7+((PR1.get(n2))/(C.get(n2)));
				if (n1==7)
					c8=c8+((PR1.get(n2))/(C.get(n2)));
				if (n1==8)
					c9=c9+((PR1.get(n2))/(C.get(n2)));
				if (n1==9)
					c10=c10+((PR1.get(n2))/(C.get(n2)));
				if (n1==10)
					c11=c11+((PR1.get(n2))/(C.get(n2)));
				if (n1==11)
					c12=c12+((PR1.get(n2))/(C.get(n2)));
				if (n1==12)
					c13=c13+((PR1.get(n2))/(C.get(n2)));
				if (n1==13)
					c14=c14+((PR1.get(n2))/(C.get(n2)));
			}
				PR2.addElement(c1);
				PR2.addElement(c2);
				PR2.addElement(c3);
				PR2.addElement(c4);
				PR2.addElement(c5);
				PR2.addElement(c6);
				PR2.addElement(c7);
				PR2.addElement(c8);
				PR2.addElement(c9);
				PR2.addElement(c10);
				PR2.addElement(c11);
				PR2.addElement(c12);
				PR2.addElement(c13);
				PR2.addElement(c14);
				//System.out.println(c1 +"\n"+ c2 +"\n"+ c3 +"\n"+c4 +"\n"+c5 +"\n"+c6 +"\n"+c7 +"\n"+c8 +"\n"+c9 +"\n"+c10 +"\n"+c11 +"\n"+c12 +"\n"+c13 +"\n"+c14 +"\n");
				
			Vector<Double> PR3= new Vector<Double>();
			for (int p=0; p<14; p++)
			{
				double p2;
				p2= (PR2.get(p))*0.85;
				p2= 0.15+p2;
				PR3.add(p2);
				//System.out.println("PR3 "+p+": "+p2);
			}
			
			Vector<Integer> PR4= new Vector<Integer>();
			for (int i=0; i<14; i++)
			{
				double b= PR3.get(0);
				int k=-1;
				for(int j=0; j<PR3.size(); j++)
				{
					//System.out.println("it"+j+" k= "+k);
					double d= PR3.get(j);
					//System.out.println("b="+b+" d="+d);
					if (d>=b)
					{
						b=d;
						k=j;
					}
				}
				PR4.add(k);
				PR3.set(k,0.0);
			}
			
			System.out.println("Page Rank");
			for (int i=0; i<14; i++)
			{
				System.out.println(" Per "+(PR4.get(i)+1));
			}
			tx.success();
		}
	}

}
