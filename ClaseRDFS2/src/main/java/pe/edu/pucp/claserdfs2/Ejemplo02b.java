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
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;

/**
 *
 * @author n221
 */
public class Ejemplo02b {
    
    public static void main(String args[]){
        String inputFileName = "nombre_soltera.rdf";
        Model model = FileManager . get () . loadModel ( inputFileName ) ;
        InfModel inf = ModelFactory . createRDFSModel ( model ) ;
        inf . setDerivationLogging ( true ) ;
        
        String NS = Utilidades.NS;
        String resourceURI = NS + "Karen";
        Resource Karen = model . getResource ( resourceURI ) ;
        resourceURI = NS + "MarriedWoman";
        Resource MarriedWoman = model . getResource ( resourceURI ) ;
        resourceURI = NS + "Woman";
        Resource Woman = model . getResource ( resourceURI ) ;
        /*
        Selector selector = new SimpleSelector ( Karen , RDF . type , MarriedWoman ) ;
        StmtIterator iter = inf . listStatements ( selector ) ;
        while ( iter . hasNext () ) {
        System . out . println ( iter . nextStatement () . toString () ) ;
        }
        */
        
        if ( Utilidades.existenAfirmaciones ( inf , Karen , RDF . type , MarriedWoman ) ){
            System . out . println ("La afirmacion es cierta ") ;
            Utilidades.mostrarDerivaciones ( inf , Karen , RDF . type , MarriedWoman ) ;
        }
        else
            System . out . println ("La afirmacion no es cierta ") ;
        
        if ( Utilidades.existenAfirmaciones ( inf , Karen , RDF . type , Woman ) ){
            System . out . println ("La afirmacion es cierta ") ;
            Utilidades.mostrarDerivaciones ( inf , Karen , RDF . type , Woman ) ;
        }
        else
            System . out . println ("La afirmacion no es cierta ") ;

    }
}
