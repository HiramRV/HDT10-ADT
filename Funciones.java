import java.util.Random;
import java.util.Vector;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class Funciones {
	
	int indicador;
	
	public int getIndicador() {
		return indicador;
	}

	public void setIndicador(int indicador) {
		this.indicador = indicador;
	}

	public Node ingreso(GraphDatabaseService db,String nombre)
	{
		Node usuario;
		usuario= db.findNode(Etiquetas.Persona, "nombreP", nombre);
		if (usuario==null)
		{
			usuario= db.createNode();
			usuario.addLabel(Etiquetas.Persona);
			usuario.setProperty("nombreP", nombre);
			setIndicador(2);
			System.out.println("Usuario nuevo");
		}
		else
		{
			setIndicador(1);
			System.out.println("Usuario guardado");
		}
		return usuario;
	}
	
	public Vector<Integer> IdsPeliculas(GraphDatabaseService db)
	{
		Node nodo1;
		Vector<Integer> pelisId= new Vector<Integer>();
		for (int i=0; i<900; i++)
		{
			try{
				nodo1= db.getNodeById(i);
				nodo1.getProperty("nombre");
				pelisId.add(i);
			}
			catch(Exception e){
				
			}
		}
		return pelisId;
	}
	
	public Node recomendacionRandom(GraphDatabaseService db, Vector<Integer>pelisId)
	{
		Random random= new Random();
		int r= random.nextInt(pelisId.size());
		Node pelicula= db.getNodeById(pelisId.get(r));
		String titulo= (String) pelicula.getProperty("nombre");
		System.out.println(titulo);
		System.out.println("");
		return pelicula;
	}
	
	public Node recomendacion(GraphDatabaseService db, Vector<Integer>pelisId, Node usuario)
	{
		Node pelicula;
		return pelicula;
	}

}
