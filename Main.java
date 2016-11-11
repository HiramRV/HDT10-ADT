import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Main {
	public static void main(String[] args) {
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		File file= new File("C:/Users/AndreaMaybell/Documents/AMPE/deberes/Algoritmos y Estructuras de Datos/Proyecto2/Base2");
		GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);
		Funciones funciones= new Funciones();
		
		try (Transaction tx = db.beginTx()) {
			//creación Scanner
			Scanner scan= new Scanner(System.in);
			System.out.println("MOVIEST");
			System.out.println("");
			
			//objetos necesarios
			Vector<Integer> pelisId= funciones.IdsPeliculas(db); //vector con Id's de las películas
			
			//ingreso
			System.out.println("Ingrese su nombre de usuario:");
			String nombre= scan.nextLine();
			Node usuario= funciones.ingreso(db, nombre);
			System.out.println("");

			//recomendación
			Node pelicula = null;
			if (funciones.getIndicador()==1)
			{
				pelicula= funciones.recomendacion(db,pelisId,usuario);
			}
			if (funciones.getIndicador()==2)
			{
				pelicula= funciones.recomendacionRandom(db, pelisId);
			}
			
			System.out.println("Le gustó la recomendación?(S/N)");
			String o= scan.nextLine();
			/*while (o.equals("S")==false||o.equals("N")==false)
			{
				System.out.println("Debe ingresar S o N para indicar si le gustó la película (S=sí, N=no)");
				System.out.println("Le gustó la recomendación?(S/N)");
				o= scan.nextLine();
			}*/
			if (o.equals("S"))
			{
				usuario.createRelationshipTo(pelicula, Relaciones.Vio);
			}
			if (o.equals("N"))
			{
				System.out.println("no le gustó");
			}
			tx.success();
		}
	}}
