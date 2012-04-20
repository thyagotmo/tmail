
package sistema.wscomunicator.iinitserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sistema.wscomunicator.iinitserver package. 
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

    private final static QName _InitServer_QNAME = new QName("http://config/", "initServer");
    private final static QName _InitServerResponse_QNAME = new QName("http://config/", "initServerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sistema.wscomunicator.iinitserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InitServer }
     * 
     */
    public InitServer createInitServer() {
        return new InitServer();
    }

    /**
     * Create an instance of {@link InitServerResponse }
     * 
     */
    public InitServerResponse createInitServerResponse() {
        return new InitServerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://config/", name = "initServer")
    public JAXBElement<InitServer> createInitServer(InitServer value) {
        return new JAXBElement<InitServer>(_InitServer_QNAME, InitServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://config/", name = "initServerResponse")
    public JAXBElement<InitServerResponse> createInitServerResponse(InitServerResponse value) {
        return new JAXBElement<InitServerResponse>(_InitServerResponse_QNAME, InitServerResponse.class, null, value);
    }

}
