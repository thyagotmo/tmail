
package sistema.wscomunicator.icadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for abstractSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="abstractSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://prov.spec.cadastro.kernel.sistema/}abstractCollection">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractSet")
@XmlSeeAlso({
    HashSet.class
})
public abstract class AbstractSet
    extends AbstractCollection
{


}
