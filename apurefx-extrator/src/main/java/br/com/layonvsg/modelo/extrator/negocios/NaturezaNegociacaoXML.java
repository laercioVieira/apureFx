package br.com.layonvsg.modelo.extrator.negocios;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.text.WordUtils;

import br.com.temasistemas.java.lang.ext.enums.IntegerValuableEnum;
import br.com.temasistemas.java.lang.ext.exception.BusinessRuntimeException;

@XmlType
@XmlEnum
public enum NaturezaNegociacaoXML implements IntegerValuableEnum<NaturezaNegociacaoXML> {

    @XmlEnumValue(value = "1" ) COMPRA {

        @Override
        public NaturezaNegociacaoXML obterNaturezaInversa() {

            return NaturezaNegociacaoXML.VENDA;
        }

        @Override
        public NaturezaNegociacaoXML obterNaturezaIgual() {

            return NaturezaNegociacaoXML.COMPRA;
        }

        @Override
        public int getValue() {

            return 1;
        }
    },
    @XmlEnumValue(value = "2" ) VENDA {

        @Override
        public NaturezaNegociacaoXML obterNaturezaInversa() {

            return NaturezaNegociacaoXML.COMPRA;
        }

        @Override
        public NaturezaNegociacaoXML obterNaturezaIgual() {

            return NaturezaNegociacaoXML.VENDA;

        }

        @Override
        public int getValue() {

            return 2;
        }
    },
    @XmlEnumValue(value = "5" ) EXERCICIO {

        @Override
        public NaturezaNegociacaoXML obterNaturezaIgual() {

            return NaturezaNegociacaoXML.EXERCICIO;
        }

        @Override
        public int getValue() {

            return 5;
        }

    };

    public String getDescricao() {

        return WordUtils.capitalize(this.name().toLowerCase());
    }

    public NaturezaNegociacaoXML obterNaturezaInversa() {

        throw new BusinessRuntimeException("Natureza da negociação "
                + "não suportada para obter a inversa");
    }

    public abstract NaturezaNegociacaoXML obterNaturezaIgual();

}
