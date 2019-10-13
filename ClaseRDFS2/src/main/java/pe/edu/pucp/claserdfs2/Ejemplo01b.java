/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDFS;

/**
 *
 * @author n221
 */
public class Ejemplo01b {
    
    public static void main(String args[]){
        String inputFileName = "relaciones_trabajadores.rdf";
        Model model = FileManager . get () . loadModel ( inputFileName ) ;
        InfModel inf = ModelFactory . createRDFSModel ( model ) ;
        
        String NS = Utilidades.NS;
        String resourceURI = NS + "Goldman";
        Resource goldman = model . getResource ( resourceURI ) ;
        resourceURI = NS + "TheFirm";
        Resource TheFirm = model . getResource ( resourceURI ) ;
        String propertyURI = NS + "worksFor";
        Property worksFor = model . getProperty ( propertyURI ) ;
       
        Selector selector = new SimpleSelector ( goldman , worksFor , TheFirm ) ;
        StmtIterator iter = inf . listStatements ( selector ) ;
        while ( iter . hasNext () ) {
            System . out . println ( iter . nextStatement () . toString () ) ;
        }
    }
    
}
