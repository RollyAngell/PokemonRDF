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
import org.apache.jena.vocabulary.RDFS;

/**
 *
 * @author n221
 */
public class Ejemplo02 {
    
    public static void main ( String [] args ) {
        String NS = Utilidades.NS;
        Model model = ModelFactory . createDefaultModel () ;
        
        Resource Woman = Utilidades.crearRecurso ( NS , "Woman", model ) ;
        Resource MarriedWoman = Utilidades.crearRecurso ( NS , "MarriedWoman", model ) ;
        Property hasMaidenName = Utilidades.crearPropiedad ( NS , "hasMaidenName", model ) ;

        model . add ( MarriedWoman , RDFS . subClassOf , Woman ) ;
        model . add ( hasMaidenName , RDFS . domain , MarriedWoman ) ;
        
        Resource Karen = Utilidades.crearRecurso ( NS , "Karen", model ) ;
        Resource Stephens = Utilidades.crearRecurso ( NS , "Stephens", model ) ;
        model . add ( Karen , hasMaidenName , Stephens ) ;
        
        Utilidades.grabarRDF ("nombre_soltera.rdf", model ) ;
    }
    
    
}
