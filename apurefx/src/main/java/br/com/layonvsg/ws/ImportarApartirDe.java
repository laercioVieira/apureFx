
package br.com.layonvsg.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for importarApartirDe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importarApartirDe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localizacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importarApartirDe", propOrder = {
    "localizacao"
})
public class ImportarApartirDe {

    protected String localizacao;

    /**
     * Gets the value of the localizacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Sets the value of the localizacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalizacao(String value) {
        this.localizacao = value;
    }

}
