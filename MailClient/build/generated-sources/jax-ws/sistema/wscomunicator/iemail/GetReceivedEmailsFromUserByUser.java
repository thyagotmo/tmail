
package sistema.wscomunicator.iemail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getReceivedEmailsFromUserByUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReceivedEmailsFromUserByUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSentUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idReceivedUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReceivedEmailsFromUserByUser", propOrder = {
    "idSentUser",
    "idReceivedUser"
})
public class GetReceivedEmailsFromUserByUser {

    protected String idSentUser;
    protected String idReceivedUser;

    /**
     * Gets the value of the idSentUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSentUser() {
        return idSentUser;
    }

    /**
     * Sets the value of the idSentUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSentUser(String value) {
        this.idSentUser = value;
    }

    /**
     * Gets the value of the idReceivedUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReceivedUser() {
        return idReceivedUser;
    }

    /**
     * Sets the value of the idReceivedUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReceivedUser(String value) {
        this.idReceivedUser = value;
    }

}
