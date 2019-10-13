/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;
import static org.apache.jena.vocabulary.RDFS.Resource;

/**
 *
 * @author n221
 */
public class Ejemplo01 {
    
    public static void main(String args[]){
        Model model = ModelFactory . createDefaultModel () ;
        Property worksFor = Utilidades.crearPropiedad ( Utilidades.NS , "worksFor", model ) ;
        Property contractsTo = Utilidades.crearPropiedad ( Utilidades.NS , "contractsTo", model ) ;
        Property isEmployedBy = Utilidades.crearPropiedad ( Utilidades.NS , "isEmployedBy", model ) ;
        Property freeLancesTo = Utilidades.crearPropiedad ( Utilidades.NS , "freeLancesTo", model ) ;
        Property indirectlyContractsTo = Utilidades.crearPropiedad ( Utilidades.NS ,"indirectlyContractsTo", model ) ;
        
        model . add ( contractsTo , RDFS . subPropertyOf , worksFor ) ;
        model . add ( isEmployedBy , RDFS . subPropertyOf , worksFor ) ;
        model . add ( freeLancesTo , RDFS . subPropertyOf , contractsTo ) ;
        model . add ( indirectlyContractsTo , RDFS . subPropertyOf , contractsTo ) ;
        
        Resource TheFirm = Utilidades.crearRecurso ( Utilidades.NS , "TheFirm", model ) ;
        Resource Goldman = Utilidades.crearRecurso ( Utilidades.NS , "Goldman", model ) ;
        Resource Spence = Utilidades.crearRecurso ( Utilidades.NS , "Spence", model ) ;
        Resource Long = Utilidades.crearRecurso ( Utilidades.NS , "Long", model ) ;
            
        model . add ( Goldman , isEmployedBy , TheFirm ) ;
        model . add ( Spence , freeLancesTo , TheFirm ) ;
        model . add ( Long , indirectlyContractsTo , TheFirm ) ;

        FileOutputStream output = null ;
        try {
            output = new FileOutputStream ("relaciones_trabajadores.rdf") ;
        } catch ( FileNotFoundException e ) {
            System . out . println (" Ocurrio un error al crear el archivo .") ;
        }
        model . write ( output , "RDF/XML-ABBREV") ;
    }
    
}
