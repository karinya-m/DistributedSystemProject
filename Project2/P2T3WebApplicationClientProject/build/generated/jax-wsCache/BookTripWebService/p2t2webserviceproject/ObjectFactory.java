
package p2t2webserviceproject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the p2t2webserviceproject package. 
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

    private final static QName _BookTrip_QNAME = new QName("http://p2t2webserviceproject/", "bookTrip");
    private final static QName _BookTripResponse_QNAME = new QName("http://p2t2webserviceproject/", "bookTripResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: p2t2webserviceproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookTripResponse }
     * 
     */
    public BookTripResponse createBookTripResponse() {
        return new BookTripResponse();
    }

    /**
     * Create an instance of {@link BookTrip }
     * 
     */
    public BookTrip createBookTrip() {
        return new BookTrip();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookTrip }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p2t2webserviceproject/", name = "bookTrip")
    public JAXBElement<BookTrip> createBookTrip(BookTrip value) {
        return new JAXBElement<BookTrip>(_BookTrip_QNAME, BookTrip.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookTripResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p2t2webserviceproject/", name = "bookTripResponse")
    public JAXBElement<BookTripResponse> createBookTripResponse(BookTripResponse value) {
        return new JAXBElement<BookTripResponse>(_BookTripResponse_QNAME, BookTripResponse.class, null, value);
    }

}
