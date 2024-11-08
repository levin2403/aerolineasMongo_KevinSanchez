package com.mycompany.mongoaeropuertoo;

import datos.DAOAerolineas;
import java.util.ArrayList;
import modelos.Aerolinea;

/**
 *
 * @author skevi
 */
public class MongoAeropuerto {

    public static void main(String[] args) {
        
        DAOAerolineas a = new DAOAerolineas();  
        
        //lista de aerolineas insertadas
        ArrayList<Aerolinea> lista = a.obtenerAerolineas();
        
        //objeto para insercion
        Aerolinea aerolinea = new Aerolinea("Viva Aerobus", "MX", "MXN", true); 
        
        //Mostrar lista de aerolineas
        for (Aerolinea arg : lista) {
            System.out.println(arg.toString());
        }
        
        //Agregar aerolinea
        a.agregarAerolinea(aerolinea);
        System.out.println("Aerolinea agregada: \n" + aerolinea.toString());
        
        //Eliminar aerolinea
        String eliminar = "672e74121cc0fa5e40880a15";
        a.eliminarAerolinea(eliminar);
        System.out.println("Se eliminó la aerolinea con el id: " +eliminar);
        
    }
}
