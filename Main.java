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
			//creaci�n Scanner
			Scanner scan= new Scanner(System.in);
			System.out.println("MOVIEST");
			System.out.println("");
			
			//objetos necesarios
			Vector<Integer> pelisId= funciones.IdsPeliculas(db); //vector con Id's de las pel�culas
			
			//ingreso
			System.out.println("Ingrese su nombre de usuario:");
			String nombre= scan.nextLine();
			Node usuario= funciones.ingreso(db, nombre);
			System.out.println("");

			//recomendaci�n
			Node pelicula = null;
			if (funciones.getIndicador()==1)
			{
				pelicula= funciones.recomendacion(db,pelisId,usuario);
			}
			if (funciones.getIndicador()==2)
			{
				pelicula= funciones.recomendacionRandom(db, pelisId);
			}
			
			System.out.println("Le gust� la recomendaci�n?(S/N)");
			String o= scan.nextLine();
			/*while (o.equals("S")==false||o.equals("N")==false)
			{
				System.out.println("Debe ingresar S o N para indicar si le gust� la pel�cula (S=s�, N=no)");
				System.out.println("Le gust� la recomendaci�n?(S/N)");
				o= scan.nextLine();
			}*/
			if (o.equals("S"))
			{
				usuario.createRelationshipTo(pelicula, Relaciones.Vio);
			}
			if (o.equals("N"))
			{
				System.out.println("no le gust�");
			}
			tx.success();
		}
	}}
