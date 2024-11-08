package modelos;

import org.bson.types.ObjectId;

/**
 * Clase que representa una aerolínea con atributos básicos como nombre,
 * país de origen, moneda y tipo de aerolínea.
 * Permite almacenar y obtener la información de una aerolínea.
 * 
 * @autor skevi
 */
public class Aerolinea {
    
    // Identificador único para la aerolínea
    private ObjectId id;
    
    // Nombre de la aerolínea
    private String nombre;
    
    // País de origen de la aerolínea
    private String pais;
    
    // Moneda que utiliza la aerolínea para sus transacciones
    private String moneda;
    
    // Indica si la aerolínea es económica o de bajo costo
    private boolean economica;

    /**
     * Constructor vacío para la clase Aerolinea.
     * Inicializa una instancia sin datos específicos.
     */
    public Aerolinea() {
    }

    /**
     * Constructor que permite inicializar una aerolínea con sus datos principales.
     * 
     * @param nombre    Nombre de la aerolínea
     * @param pais      País de origen de la aerolínea
     * @param moneda    Moneda utilizada por la aerolínea
     * @param economica Indica si la aerolínea es económica (true) o no (false)
     */
    public Aerolinea(String nombre, String pais, String moneda, 
            boolean economica) {
        this.nombre = nombre;
        this.pais = pais;
        this.moneda = moneda;
        this.economica = economica;
    }

    /**
     * Constructor que permite inicializar una aerolínea con todos sus atributos,
     * incluido el identificador único.
     * 
     * @param id        Identificador único de la aerolínea
     * @param nombre    Nombre de la aerolínea
     * @param pais      País de origen de la aerolínea
     * @param moneda    Moneda utilizada por la aerolínea
     * @param economica Indica si la aerolínea es económica (true) o no (false)
     */
    public Aerolinea(ObjectId id, String nombre, String pais, 
            String moneda, boolean economica) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.moneda = moneda;
        this.economica = economica;
    }
    
    /**
     * Obtiene el identificador único de la aerolínea.
     * 
     * @return id de la aerolínea
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la aerolínea.
     * 
     * @param id Nuevo id de la aerolínea
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la aerolínea.
     * 
     * @return nombre de la aerolínea
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la aerolínea.
     * 
     * @param nombre Nuevo nombre de la aerolínea
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país de origen de la aerolínea.
     * 
     * @return país de origen de la aerolínea
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país de origen de la aerolínea.
     * 
     * @param pais Nuevo país de origen de la aerolínea
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la moneda que utiliza la aerolínea.
     * 
     * @return moneda utilizada por la aerolínea
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Establece la moneda que utilizará la aerolínea.
     * 
     * @param moneda Nueva moneda de la aerolínea
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * Indica si la aerolínea es económica.
     * 
     * @return true si la aerolínea es económica, false en caso contrario
     */
    public boolean isEconomica() {
        return economica;
    }

    /**
     * Establece si la aerolínea es económica.
     * 
     * @param economica true si es económica, false en caso contrario
     */
    public void setEconomica(boolean economica) {
        this.economica = economica;
    }

    /**
     * Devuelve una representación en cadena de los datos de la aerolínea.
     * 
     * @return cadena con los datos de la aerolínea
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aerolinea{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", pais=").append(pais);
        sb.append(", moneda=").append(moneda);
        sb.append(", economica=").append(economica);
        sb.append('}');
        return sb.toString();
    }
    
}

