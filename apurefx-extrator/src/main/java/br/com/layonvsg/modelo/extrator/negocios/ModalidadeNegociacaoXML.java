package br.com.layonvsg.modelo.extrator.negocios;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import br.com.temasistemas.java.lang.ext.enums.IntegerValuableEnum;

@XmlType
@XmlEnum
public enum ModalidadeNegociacaoXML implements IntegerValuableEnum<ModalidadeNegociacaoXML> {

    @XmlEnumValue(value = "1" ) OPERADOR {

        @Override
        public int getValue() {

            return 1;
        }
    },
    @XmlEnumValue(value = "2" ) DMA {

        @Override
        public int getValue() {

            return 2;
        }
    };

}
