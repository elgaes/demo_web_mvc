//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.01 at 12:33:55 AM AEDT 
//


package au.gov.dva.digitize.document.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the au.gov.dva.digitize.document.jaxb package. 
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

    private final static QName _MailMeta_QNAME = new QName("http://www.dva.gov.au/ReceivedMailMeta", "mailMeta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: au.gov.dva.digitize.document.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MailMeta }
     * 
     */
    public MailMeta createMailMeta() {
        return new MailMeta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMeta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dva.gov.au/ReceivedMailMeta", name = "mailMeta")
    public JAXBElement<MailMeta> createMailMeta(MailMeta value) {
        return new JAXBElement<MailMeta>(_MailMeta_QNAME, MailMeta.class, null, value);
    }

}