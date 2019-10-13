/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Derivation;

/**
 *
 * @author n221
 */
public class Utilidades {
    
    public static String NS = "http://www.pucp.edu.pe/informatica#";

    public static Property crearPropiedad (String NS, String id, Model model) {
        String propertyURI = NS + id.trim();
        return model.createProperty(propertyURI) ;
    }
    
    public static Resource crearRecurso (String NS, String id, Model model) {
        String resourceURI = NS + id.trim() ;
        return model.createResource (resourceURI) ;
    }
    
    public static void grabarRDF (String nmRDFFile, Model model) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream ( nmRDFFile.trim() ) ;
        } catch ( FileNotFoundException e ) {
            System.out.println("Ocurrio un error al crear el archivo.");
            return null;
        }
        model.write(output, "RDF/XML-ABBREV") ;
    }
    
    public static Boolean existenAfirmaciones (InfModel inf, Resource Sujeto, Property predicado, Resource objeto) {
        Boolean hayAfirmaciones;
        Selector selector = new SimpleSelector(Sujeto, predicado, objeto ) ;
        StmtIterator iter = inf.listStatements(selector) ;
        hayAfirmaciones = iter.hasNext () ;
        return hayAfirmaciones ;
    }
    
    public static void mostrarDerivaciones ( InfModel inf, Resource Sujeto, Property predicado, Resource objeto ) {
        PrintWriter out = new PrintWriter ( System . out ) ;
        for ( StmtIterator i = inf . listStatements ( Sujeto , predicado , objeto ) ; i . hasNext () ;) {
            Statement s = i . nextStatement () ;
            System . out . println (" Statement is " + s ) ;
            for ( Iterator id = inf . getDerivation ( s ) ; id . hasNext () ;) {
                Derivation deriv = ( Derivation ) id . next () ;
                deriv . printTrace ( out , true ) ;
            }
        }
        out . flush () ;
    }
    
    public static void mostrarDeclaraciones(InfModel inf, Resource Sujeto, Property predicado, Resource objeto) {
        Selector selector = new SimpleSelector(Sujeto, predicado, objeto) ;
        StmtIterator iter = inf.listStatements(selector) ;
        while (iter.hasNext()) {
            System.out.println(iter.nextStatement().toString()) ;
        }
    }

    public static Resource obtenerRecurso (String NS, String id, Model model) {
        String resourceURI = NS + id.trim() ;
        return model.getResource(resourceURI) ;
    }
    
    public static Property obtenerPropiedad (String NS, String id, Model model) {
        String propertyURI = NS + id.trim() ;
        return model.getProperty(propertyURI) ;
    }

    
}
