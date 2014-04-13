package br.com.layonvsg.modelo.extrator.negocios;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import br.com.temasistemas.java.lang.ext.enums.IntegerValuableEnum;

@XmlType
@XmlEnum
public enum Mercado implements IntegerValuableEnum<Mercado> {
	@XmlEnumValue( value = "1" ) DISPONIVEL(1, "Disponível"),
	@XmlEnumValue( value = "2" ) OPCAO_SOBRE_DISPONIVEL(2, "Opção Sobre Disponivel"),
	@XmlEnumValue( value = "3" ) FUTURO(3, "Futuro"),
	@XmlEnumValue( value = "4" ) OPCAO_SOBRE_FUTURO(4, "Opção Sobre Futuro"),
	@XmlEnumValue( value = "5" ) SWAP(5, "Swap"),
	@XmlEnumValue( value = "6" ) OPCAO_FLEXIVEL(6, "Opções Flexiveis"),
	@XmlEnumValue( value = "7" ) ESTRUTURADA(7, "Estruturada"),
	@XmlEnumValue( value = "8" ) SWAP_CAMBIAL_COM_AJUSTE(8, "Swap Cambial Com Ajuste");

    
    private final int value;

    private final String descricao;

    private Mercado(
            final int value,
            final String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
