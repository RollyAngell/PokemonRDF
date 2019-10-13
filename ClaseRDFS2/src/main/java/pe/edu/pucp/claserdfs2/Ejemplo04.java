/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import static pe.edu.pucp.claserdfs2.Utilidades.crearPropiedad;
import static pe.edu.pucp.claserdfs2.Utilidades.crearRecurso;
import static pe.edu.pucp.claserdfs2.Utilidades.grabarRDF;

/**
 *
 * @author n221
 */
public class Ejemplo04 {
    public static void main(String args[]){
        Model model = ModelFactory . createDefaultModel () ;
        Property billedFor = crearPropiedad ( Utilidades.NS , " billedFor ", model ) ;
        Property assignedTo = crearPropiedad ( Utilidades.NS , " assignedTo ", model ) ;
        Property lodgedIn = crearPropiedad ( Utilidades.NS , " lodgedIn ", model ) ;
        
        model . add ( lodgedIn , RDFS . subPropertyOf , billedFor ) ;
        model . add ( lodgedIn , RDFS . subPropertyOf , assignedTo ) ;
        
        Resource Marcus = crearRecurso ( Utilidades.NS , " Marcus ", model ) ;
        Resource Room101 = crearRecurso ( Utilidades.NS , " Room101 ", model ) ;
        model . add ( Marcus , lodgedIn , Room101 ) ;
        
        grabarRDF ("habitacion.RDF", model ) ;
    }
}
