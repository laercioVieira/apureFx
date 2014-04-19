
package br.com.layonvsg.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.layonvsg.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ImportarApartirDe_QNAME = new QName("http://ws.layonvsg.com.br/", "importarApartirDe");
    private final static QName _Log_QNAME = new QName("http://ws.layonvsg.com.br/", "log");
    private final static QName _ImportarApartirDeResponse_QNAME = new QName("http://ws.layonvsg.com.br/", "importarApartirDeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.layonvsg.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportarApartirDeResponse }
     * 
     */
    public ImportarApartirDeResponse createImportarApartirDeResponse() {
        return new ImportarApartirDeResponse();
    }

    /**
     * Create an instance of {@link Log }
     * 
     */
    public Log createLog() {
        return new Log();
    }

    /**
     * Create an instance of {@link ImportarApartirDe }
     * 
     */
    public ImportarApartirDe createImportarApartirDe() {
        return new ImportarApartirDe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportarApartirDe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.layonvsg.com.br/", name = "importarApartirDe")
    public JAXBElement<ImportarApartirDe> createImportarApartirDe(ImportarApartirDe value) {
        return new JAXBElement<ImportarApartirDe>(_ImportarApartirDe_QNAME, ImportarApartirDe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Log }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.layonvsg.com.br/", name = "log")
    public JAXBElement<Log> createLog(Log value) {
        return new JAXBElement<Log>(_Log_QNAME, Log.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportarApartirDeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.layonvsg.com.br/", name = "importarApartirDeResponse")
    public JAXBElement<ImportarApartirDeResponse> createImportarApartirDeResponse(ImportarApartirDeResponse value) {
        return new JAXBElement<ImportarApartirDeResponse>(_ImportarApartirDeResponse_QNAME, ImportarApartirDeResponse.class, null, value);
    }

}
