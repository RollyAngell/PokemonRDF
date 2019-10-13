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
import static pe.edu.pucp.claserdfs2.Utilidades.existenAfirmaciones;
import static pe.edu.pucp.claserdfs2.Utilidades.mostrarDerivaciones;

/**
 *
 * @author n221
 */
public class Ejemplo04b {
    
    public static void main(String args[]){
        String inputFileName = "habitacion.rdf ";
        Model model = FileManager . get () . loadModel ( inputFileName ) ;
        InfModel inf = ModelFactory . createRDFSModel ( model ) ;
        inf . setDerivationLogging ( true ) ;

        String NS = Utilidades.NS;
        String resourceURI = NS + "Marcus";
        Resource Marcus = model . getResource ( resourceURI ) ;
        resourceURI = NS + "Room101";
        Resource Room101 = model . getResource ( resourceURI ) ;
        String propertyURI = NS + "billedFor";
        Property billedFor = model . getProperty ( propertyURI ) ;

        if ( existenAfirmaciones ( inf , Marcus , billedFor , Room101 ) ) {
            System . out . println ("La afirmacion es cierta ") ;
            mostrarDerivaciones ( inf , Marcus , billedFor , Room101 ) ;
        }
        else
            System . out . println ("La afirmacion no es cierta ") ;
    }
}
