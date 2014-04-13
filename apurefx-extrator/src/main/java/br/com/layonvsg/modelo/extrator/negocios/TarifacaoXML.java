package br.com.layonvsg.modelo.extrator.negocios;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.temasistemas.java.lang.ext.hash.HashCoder;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TarifacaoXML
        implements Serializable {

    private static final long serialVersionUID = 695981176625730173L;

    @XmlElement
    private double valorUnitarioTaxaRegistroNormal;

    @XmlElement
    private double valorUnitarioTaxaRegistroDayTrade;

    @XmlElement
    private double valorUnitarioTaxaNegociacaoNormal;

    @XmlElement
    private double valorUnitarioTaxaNegociacaoDayTrade;

    protected TarifacaoXML() {

        super();
    }

    public TarifacaoXML(
            final double valorUnitarioTaxaRegistroNormal,
            final double valorUnitarioTaxaRegistroDayTrade,
            final double valorUnitarioTaxaNegociacaoNormal,
            final double valorUnitarioTaxaNegociacaoDayTrade) {

        super();
        this.setValorUnitarioTaxaRegistroNormal(valorUnitarioTaxaRegistroNormal);
        this.setValorUnitarioTaxaRegistroDayTrade(valorUnitarioTaxaRegistroDayTrade);
        this.setValorUnitarioTaxaNegociacaoNormal(valorUnitarioTaxaNegociacaoNormal);
        this.setValorUnitarioTaxaNegociacaoDayTrade(valorUnitarioTaxaNegociacaoDayTrade);
    }

    @Override
    public int hashCode() {
        return HashCoder.hash()
                .append(this.getValorUnitarioTaxaNegociacaoDayTrade())
                .append(this.getValorUnitarioTaxaNegociacaoNormal())
                .append(this.getValorUnitarioTaxaRegistroDayTrade())
                .append(this.getValorUnitarioTaxaRegistroNormal()).toHashCode();
    }

    @Override
    public boolean equals(
            final Object obj) {

        if (obj instanceof TarifacaoXML) {

            final TarifacaoXML other = (TarifacaoXML) obj;

            if (other.getValorUnitarioTaxaNegociacaoDayTrade().equals(
                    this.getValorUnitarioTaxaNegociacaoDayTrade())
                    && other.getValorUnitarioTaxaNegociacaoNormal().equals(
                            this.getValorUnitarioTaxaNegociacaoNormal())
                    && other.getValorUnitarioTaxaRegistroDayTrade().equals(
                            this.getValorUnitarioTaxaRegistroDayTrade())
                    && other.getValorUnitarioTaxaRegistroNormal().equals(
                            this.getValorUnitarioTaxaRegistroNormal())) {

                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {

        return String
                .format(
                        "Tarifacao [valorUnitarioTaxaRegistroNormal=%s,"
                                + " valorUnitarioTaxaRegistroDayTrade=%s,"
                                + " valorUnitarioTaxaNegociacaoNormal=%s,"
                                + " valorUnitarioTaxaNegociacaoDayTrade=%s]",
                        this.getValorUnitarioTaxaRegistroNormal(),
                        this.getValorUnitarioTaxaRegistroDayTrade(),
                        this.getValorUnitarioTaxaNegociacaoNormal(),
                        this.getValorUnitarioTaxaNegociacaoDayTrade());
    }

    public Double getValorUnitarioTaxaRegistroNormal() {

        return this.valorUnitarioTaxaRegistroNormal;
    }

    private void setValorUnitarioTaxaRegistroNormal(
            final Double valorUnitarioTaxaRegistroNormal) {

        this.valorUnitarioTaxaRegistroNormal = valorUnitarioTaxaRegistroNormal;
    }

    public Double getValorUnitarioTaxaRegistroDayTrade() {

        return this.valorUnitarioTaxaRegistroDayTrade;
    }

    private void setValorUnitarioTaxaRegistroDayTrade(
            final Double valorUnitarioTaxaRegistroDayTrade) {

        this.valorUnitarioTaxaRegistroDayTrade = valorUnitarioTaxaRegistroDayTrade;
    }

    public Double getValorUnitarioTaxaNegociacaoNormal() {

        return this.valorUnitarioTaxaNegociacaoNormal;
    }

    private void setValorUnitarioTaxaNegociacaoNormal(
            final Double valorUnitarioTaxaNegociacaoNormal) {

        this.valorUnitarioTaxaNegociacaoNormal = valorUnitarioTaxaNegociacaoNormal;
    }

    public Double getValorUnitarioTaxaNegociacaoDayTrade() {

        return this.valorUnitarioTaxaNegociacaoDayTrade;
    }

    private void setValorUnitarioTaxaNegociacaoDayTrade(
            final Double valorUnitarioTaxaNegociacaoDayTrade) {

        this.valorUnitarioTaxaNegociacaoDayTrade = valorUnitarioTaxaNegociacaoDayTrade;
    }

}
