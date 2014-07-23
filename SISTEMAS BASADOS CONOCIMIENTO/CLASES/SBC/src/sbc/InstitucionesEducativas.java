
package sbc;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InstitucionesEducativas {
    
    public static String foaf = "http://xmlns.com/foaf/0.1/";
    public static String schema = "http://schema.org/";
    public static String geo="http://www.w3.org/2003/01/geo/";
    public static String dbpedia="http://dbpedia.org/ontology/Place#Country";
    public static String places="http://purl.org/ontology/places/";
    
     
    public static String institucionRecursos = "http://localhost/page/";
    public static String institucionUriOntologia="http://localhost/ontologiaInstitucionesEducativas/";
   
    public static String archivo = "file:///C:/sbc/valido.owl";
    public static OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
    
    public static void main(String[] args) throws IOException, BiffException ,FileNotFoundException{   
        Workbook workbook1 = Workbook.getWorkbook(new File("C:\\sbc\\datosLimpios.xls"));
        Sheet sheet1 = workbook1.getSheet(7);
        model.read(archivo, "RDF/XML");           
               
        String nombre;
        String direccion;
        String correo;
        String sitioWeb;
          
        ///PROPIEDADES DE ESTRUCTURA ACADEMICA
        
        String nivel;
        String tipoEducacion;
        String jornada;
        String tipoInstitucion;
        String modalidad;
        String jurisdiccion;
        
        //PROPIEDADES DE OFERTA ACADEMICA
        String anoLectivo="2014";
        String numeroEst;
        String numeroDoc;
                
        //PROPIEDADES DE OTROS
        String nombrCanton;
        String nombrParroquia;
        String nombrProvincia;
        String nombrZona;
        String circuito;
        
        
           //Obtenemos la CLASEESS y creamos la instancias
            OntClass insClass = model.getOntClass(schema+"Organization");
            OntClass estAcadClass = model.getOntClass(institucionUriOntologia+"EstructuraAcademica");
            OntClass ofertaAcadClass = model.getOntClass(institucionUriOntologia+"OfertaAcademica");
            OntClass distritoClass= model.getOntClass(institucionUriOntologia+"Distrito");
            OntClass circuitoClass= model.getOntClass(institucionUriOntologia+"Circuito");
            OntClass geo= model.getOntClass(institucionUriOntologia+"Geo");
            OntClass person= model.getOntClass(institucionUriOntologia+"Person");
            OntClass directorCircuito= model.getOntClass(institucionUriOntologia+"DirectorCircuito");
            OntClass principalAutoridad= model.getOntClass(institucionUriOntologia+"PrincipalAutoridad");
            OntClass provinciaClass=model.getOntClass(institucionUriOntologia+"Provincia");
            OntClass parroquiaClass=model.getOntClass(institucionUriOntologia+"Parroquia");
            OntClass cantonClass=model.getOntClass(institucionUriOntologia+"Canton");
             
            // llamamos a las propiedades
            DatatypeProperty nameInstitucion = model.getDatatypeProperty(schema+"Organization#legalName");  
            DatatypeProperty address = model.getDatatypeProperty(schema + "Organization#address");
            DatatypeProperty url= model.getDatatypeProperty(schema + "Organization#url");
                     
            ///PROPIEDADES DE ESTRUCTURA ACADEMICA
             DatatypeProperty level= model.getDatatypeProperty(institucionUriOntologia+"nivel");
             DatatypeProperty tipEducation= model.getDatatypeProperty(institucionUriOntologia+"tipoEducacion");
             DatatypeProperty tipInstitution= model.getDatatypeProperty(institucionUriOntologia+"tipoInstitucion");
             DatatypeProperty journal= model.getDatatypeProperty(institucionUriOntologia+"jornada");
             DatatypeProperty jurisdiction= model.getDatatypeProperty(institucionUriOntologia+"jurisdiccion");
             DatatypeProperty modality= model.getDatatypeProperty(institucionUriOntologia+"modalidad");   
             ///PROPIEDADES DE OFERTA ACADEMICA
             DatatypeProperty year= model.getDatatypeProperty(institucionUriOntologia+"anioLectivo");
             DatatypeProperty numberEst= model.getDatatypeProperty(institucionUriOntologia+"numeroEstudiantes");
             DatatypeProperty numberDoc= model.getDatatypeProperty(institucionUriOntologia+"numeroDocentes");
          //PROPIEDADES DE LUGARES
             DatatypeProperty nameProvince=model.getDatatypeProperty(institucionUriOntologia+"nombreProvincia");
             DatatypeProperty nameParroqui=model.getDatatypeProperty(institucionUriOntologia+"nombreParroquia");
             DatatypeProperty nameCantone=model.getDatatypeProperty(institucionUriOntologia+"nombreCanton");
             DatatypeProperty nameCircuito=model.getDatatypeProperty(institucionUriOntologia+"nombreCircuito");
             DatatypeProperty nameDistrito=model.getDatatypeProperty(institucionUriOntologia+"nombreDistrito");
            
             //OBTENEMOS PROPIEDADES DE RELACION
             
            ObjectProperty hasStructure = model.getObjectProperty(institucionUriOntologia + "tieneEstructura");
            ObjectProperty offert = model.getObjectProperty(institucionUriOntologia + "ofrece");
            ObjectProperty isAgrupation = model.getObjectProperty(institucionUriOntologia + "esAgrupacionDe");

        for (int i = 1; i < 1000; i++) {     
            ////////////////////////////////////
            //OBTENER DATOS DEL ARCHIVO EXCEL   
            Cell a1 = sheet1.getCell(1, i);
            nombre = a1.getContents();
            
            Cell a2 = sheet1.getCell(14, i);
           tipoEducacion = a2.getContents();

            Cell a3 = sheet1.getCell(17, i);
            nivel= a3.getContents();

            Cell a4 = sheet1.getCell(16, i);
            jornada = a4.getContents();
            
             Cell a5 = sheet1.getCell(12, i);
            tipoInstitucion = a5.getContents();
            
             Cell a6 = sheet1.getCell(15, i);
            modalidad = a6.getContents();
            
             Cell a7 = sheet1.getCell(21, i);
            jurisdiccion = a7.getContents();         
             
             Cell a9 = sheet1.getCell(19, i);
            numeroEst = a9.getContents();
            
              Cell a10 = sheet1.getCell(20, i);
            numeroDoc = a10.getContents();
            
              Cell a11 = sheet1.getCell(5, i);
            nombrCanton = a11.getContents();         
             
             Cell a12 = sheet1.getCell(7, i);
            nombrParroquia = a12.getContents();
            
            Cell a13 = sheet1.getCell(3, i);
            nombrProvincia = a13.getContents();
            
            Cell a14 = sheet1.getCell(2, i);
            nombrZona = a14.getContents();
            
            Cell a15 = sheet1.getCell(11, i);
            circuito = a15.getContents();
            
             /////////////////////////////////////////   
//          //Creamos la institucion de la clase id
            Individual institution = model.createIndividual(institucionRecursos+nombre.replace(" ", "_"), insClass);
            Individual estructuraAca = model.createIndividual(institucionRecursos+nombre.replace(" ", "_")+"_Estructura_Academica_2014", estAcadClass);
            Individual ofertaAca = model.createIndividual(institucionRecursos+nombre.replace(" ", "_")+"_Oferta_Academica_2014", ofertaAcadClass);
            Individual codCircuito = model.createIndividual(institucionRecursos+circuito.replace(" ", "_"), circuitoClass);
            
           
            //System.out.print(nameInstitucion.toString());
            //creamos los literales
            institution.setPropertyValue(nameInstitucion, model.createLiteral(nombre));    
            //////////////////////////
            estructuraAca.setPropertyValue(level, model.createLiteral(nivel));
            estructuraAca.setPropertyValue(tipEducation, model.createLiteral(tipoEducacion));
            estructuraAca.setPropertyValue(tipInstitution, model.createLiteral(tipoInstitucion));
            estructuraAca.setPropertyValue(journal, model.createLiteral(jornada));
            estructuraAca.setPropertyValue(jurisdiction, model.createLiteral(jurisdiccion));
            estructuraAca.setPropertyValue(modality, model.createLiteral(modalidad));
            //System.out.println(nameInstitucion.toString());
             
            ofertaAca.setPropertyValue(year, model.createLiteral(anoLectivo));
            ofertaAca.setPropertyValue(numberEst, model.createLiteral(numeroEst));
            ofertaAca.setPropertyValue(numberDoc, model.createLiteral(numeroDoc));
            
            institution.setPropertyValue(hasStructure,estructuraAca);
            institution.setPropertyValue(offert,ofertaAca );
            institution.setPropertyValue(isAgrupation,model.getResource(institucionRecursos+circuito));
            
            codCircuito.setPropertyValue(nameCircuito, model.createLiteral(circuito)); 
             
         }
            System.out.println("/////");
            workbook1.close();        
            model.write(System.out,"N-TRIPLES");
        
    }
}

