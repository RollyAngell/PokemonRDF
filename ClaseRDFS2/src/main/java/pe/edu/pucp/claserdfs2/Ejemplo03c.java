/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.claserdfs2;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import static pe.edu.pucp.claserdfs2.Utilidades.crearRecurso;
import static pe.edu.pucp.claserdfs2.Utilidades.grabarRDF;

/**
 *
 * @author n221
 */
public class Ejemplo03c {
    public static void main(String args[]){
        Model model = ModelFactory . createDefaultModel () ;
        Resource Staff = crearRecurso ( Utilidades.NS , " Staff ", model ) ;
        Resource Physician = crearRecurso ( Utilidades.NS , " Physician ", model ) ;
        Resource Surgeon = crearRecurso ( Utilidades.NS , " Surgeon ", model ) ;
        Resource Kildare = crearRecurso ( Utilidades.NS , " Kildare ", model ) ;
        model . add ( Surgeon , RDFS . subClassOf , Staff ) ;
        model . add ( Surgeon , RDFS . subClassOf , Physician ) ;
        model . add ( Kildare , RDF . type , Staff ) ;
        model . add ( Kildare , RDF . type , Physician ) ;
        grabarRDF ("cirujanos2.rdf", model ) ;
    }
}
