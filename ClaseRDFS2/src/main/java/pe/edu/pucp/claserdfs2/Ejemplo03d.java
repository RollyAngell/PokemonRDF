/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;
import static pe.edu.pucp.claserdfs2.Utilidades.mostrarDeclaraciones;

/**
 *
 * @author n221
 */
public class Ejemplo03d {
    public static void main(String args[]){
        String inputFileName = "cirujanos2.rdf";
        Model model = FileManager . get () . loadModel ( inputFileName ) ;
        InfModel inf = ModelFactory . createRDFSModel ( model ) ;
        String NS = Utilidades.NS;
        String resourceURI = NS + "Kildare";
        Resource Kildare = model . getResource ( resourceURI ) ;
        Resource Surgeon = model.getResource(NS + "Surgeon");
        mostrarDeclaraciones ( inf , Kildare , RDF . type , Surgeon ) ;    
    }
}
