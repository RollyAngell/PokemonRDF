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
public class Ejemplo05 {
    public static void main(String args[]){
        String NS = Utilidades.NS;
        Model model = ModelFactory . createDefaultModel () ;
        
        Resource AllStarCandidate = crearRecurso ( Utilidades.NS , " AllStarCandidate ", model ) ;
        Resource MVP = crearRecurso ( NS , "MVP", model ) ;
        Resource TopScorer = crearRecurso ( NS , " TopScorer ", model ) ;
        
        model . add ( MVP , RDFS . subClassOf , AllStarCandidate ) ;
        model . add ( TopScorer , RDFS . subClassOf , AllStarCandidate ) ;
        
        Resource Reilly = crearRecurso ( NS , " Reilly ", model ) ;
        Resource Kaneda = crearRecurso ( NS , " Kaneda ", model ) ;
        
        model . add ( Reilly , RDF . type , MVP ) ;
        model . add ( Kaneda , RDF . type , TopScorer ) ;
        
        grabarRDF (" deportes.rdf", model ) ;
    }
}
