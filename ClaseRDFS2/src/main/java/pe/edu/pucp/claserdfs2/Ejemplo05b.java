/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;
import static pe.edu.pucp.claserdfs2.Utilidades.existenAfirmaciones;
import static pe.edu.pucp.claserdfs2.Utilidades.mostrarDerivaciones;
import static pe.edu.pucp.claserdfs2.Utilidades.obtenerRecurso;

/**
 *
 * @author n221
 */
public class Ejemplo05b {
    public static void main(String args[]){
        String inputFileName = "deportes.rdf ";
        Model model = FileManager . get () . loadModel ( inputFileName ) ;
        InfModel inf = ModelFactory . createRDFSModel ( model ) ;
        
        String NS = Utilidades.NS;
        Resource Reilly = obtenerRecurso ( NS , "Reilly", model ) ;
        Resource Kaneda = obtenerRecurso ( NS , "Kaneda", model ) ;
        Resource AllStarCandidate = obtenerRecurso ( NS , "AllStarCandidate",model ) ;
        
        if ( existenAfirmaciones ( inf , Kaneda , RDF . type , AllStarCandidate ) ) {
            System . out . println ("La afirmacion es cierta ") ;
        } else {
            System . out . println ("La afirmacion no es cierta ") ;
        }
    }
}
