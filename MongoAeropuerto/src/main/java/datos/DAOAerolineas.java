package datos;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import modelos.Aerolinea;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos (DAO) para realizar operaciones CRUD en la 
 * colección "airlines" de una base de datos MongoDB. Gestiona las operaciones 
 * relacionadas con las aerolíneas almacenadas en MongoDB.
 * 
 * @author skevi
 */
public class DAOAerolineas {

    // Cliente de MongoDB para la conexión a la base de datos
    MongoClient mongoClient;
    
    // Base de datos MongoDB a utilizar
    MongoDatabase database;
    
    // Colección específica dentro de la base de datos para almacenar 
    // aerolíneas
    MongoCollection<Document> collection;

    /**
     * Constructor de la clase DAOAerolineas.
     * Establece la conexión con la base de datos "airport" y 
     * la colección "airlines".
     */
    public DAOAerolineas(){ 
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("airport");
        collection = database.getCollection("airlines");
    }

    /**
     * Recupera todas las aerolíneas almacenadas en la colección.
     * 
     * @return Lista de objetos Aerolinea que contiene los datos de cada 
     * aerolínea
     */
    public ArrayList<Aerolinea> obtenerAerolineas() {
        ArrayList<Aerolinea> aerolineas = new ArrayList<>();
        
        // Obtiene un cursor para iterar sobre los documentos de la colección
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            // Itera sobre cada documento y lo convierte en un objeto Aerolinea
            while (cursor.hasNext()) {
                Document d = cursor.next();
                
                // Crea un nuevo objeto Aerolinea a partir de los datos 
                // del documento
                Aerolinea a = new Aerolinea(d.getObjectId("_id"), 
                        d.getString("name"), d.getString("country"),
                        d.getString("currency"), 
                        d.getBoolean("lowcost") == null ? false : true);
                
                // Agrega la aerolínea a la lista
                aerolineas.add(a);
            }
        } finally {
            // Cierra el cursor para liberar recursos
            cursor.close();
        }
        return aerolineas;
    }
    
    /**
     * Agrega una nueva aerolínea a la colección "airlines" en MongoDB.
     * 
     * @param aerolinea Objeto Aerolinea que contiene los datos de la aerolínea 
     * a agregar
     */
    public void agregarAerolinea(Aerolinea aerolinea){
        // Crea un documento a partir de los atributos de la aerolínea
        Document d = new Document("name", aerolinea.getNombre())
                .append("country", aerolinea.getPais())
                .append("currency", aerolinea.getMoneda())
                .append("lowcost", aerolinea.isEconomica());
        
        // Inserta el documento en la colección
        collection.insertOne(d);
    }
    
    /**
     * Elimina una aerolínea de la colección basada en su id.
     * 
     * @param id Identificador único de la aerolínea en formato String
     */
    public void eliminarAerolinea(String id){
        // Elimina el documento que coincide con el id proporcionado
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }
}

