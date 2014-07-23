package sbc;

import java.util.List;
import java.io.*;
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;


public class ontologia extends Object {
        static final String inputFileName = "C:\\Documents and Settings\\Santiago.EXIT-SANTIAGO\\Mis documentos\\validar.owl";
            public static void main (String args[]) {
            // Create an empty in-memory ontology model
                    OntDocumentManager mgr = new OntDocumentManager();
                    OntModelSpec s = new OntModelSpec( OntModelSpec.RDFS_MEM );
                    s.setDocumentManager( mgr );
                    OntModel m = ModelFactory.createOntologyModel( s, null );
                    // use the FileManager to open the ontology from the filesystem
                    InputStream in = FileManager.get().open(inputFileName);
                    if (in == null) {
                    throw new IllegalArgumentException( "File: " + inputFileName + " not found"); }
                    // read the ontology file
                    m.read( in, "" );
                    // write it to standard out (RDF/XML)
                    m.write(System.out); 
            
                    
            }
            
                    
}                   
                      