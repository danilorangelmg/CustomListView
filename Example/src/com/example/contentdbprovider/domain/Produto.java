package com.example.contentdbprovider.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import android.content.ContentValues;
import android.net.Uri;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
    public static final String AUTHORITY = "com.example.contentdbprovider.content.ApplicationProvider";
	public static final Uri CONTENT_URI =  Uri.parse("content://" + AUTHORITY + "/Produto");
    
	public static final Uri CONTENT_ID_URI_BASE = Uri.parse("content://" + AUTHORITY + "/Produto/");
	
	private Integer codigo;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private BigDecimal valor1;
	
	private BigDecimal valor2;
	
	private BigDecimal valor3;
	
	private BigDecimal valor4;
	
	private BigDecimal valor5;
	
	private BigDecimal valor6;
	
	private BigDecimal valor7;
	
	private BigDecimal valor8;
	
	private BigDecimal valor9;
	
	private BigDecimal valor10;
	
	private BigDecimal valor11;
	
	private BigDecimal valor12;
	
	private BigDecimal valor13;
	
	private BigDecimal valor14;
	
	private BigDecimal valor15;
	
	private BigDecimal valor16;
	
	private BigDecimal valor17;
	
	private BigDecimal valor18;
	
	private BigDecimal valor19;
	
	private BigDecimal valor20;
	
	private BigDecimal valor21;
	
	private BigDecimal valor22;
	
	private BigDecimal valor23;
	
	private BigDecimal valor24;
	
	private BigDecimal valor25;
	
	private BigDecimal valor26;
	
	private BigDecimal valor27;
	
	private BigDecimal valor28;
	
	private BigDecimal valor29;
	
	private BigDecimal valor30;
	
	private BigDecimal valor31;
	
	private BigDecimal valor32;
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
		this.valor1 = valor;
		this.valor2 = valor;
		this.valor3 = valor;
		this.valor4 = valor;
		this.valor5 = valor;
		this.valor6 = valor;
		this.valor7 = valor;
		this.valor8 = valor;
		this.valor9 = valor;
		this.valor10 = valor;
		this.valor11 = valor;
		this.valor12 = valor;
		this.valor13 = valor;
		this.valor14 = valor;
		this.valor15 = valor;
		this.valor16 = valor;
		this.valor17 = valor;
		this.valor18 = valor;
		this.valor19 = valor;
		this.valor20 = valor;
		this.valor21 = valor;
		this.valor22 = valor;
		this.valor23 = valor;
		this.valor24 = valor;
		this.valor25 = valor;
		this.valor26 = valor;
		this.valor27 = valor;
		this.valor28 = valor;
		this.valor29 = valor;
		this.valor30 = valor;
		this.valor31 = valor;
		this.valor32 = valor;
	}
	
	public ContentValues getValues() {
		ContentValues values = new ContentValues();
		values.put("codigo", codigo);
		values.put("descricao", descricao);
		values.put("valor", valor.doubleValue());
		values.put("valor1", valor1.doubleValue());
		values.put("valor2", valor2.doubleValue());
		values.put("valor3", valor3.doubleValue());
		values.put("valor4", valor4.doubleValue());
		values.put("valor5", valor5.doubleValue());
		values.put("valor6", valor6.doubleValue());
		values.put("valor7", valor7.doubleValue());
		values.put("valor8", valor8.doubleValue());
		values.put("valor9", valor9.doubleValue());
		values.put("valor10", valor10.doubleValue());
		values.put("valor11", valor11.doubleValue());
		values.put("valor12", valor12.doubleValue());
		values.put("valor13", valor13.doubleValue());
		values.put("valor14", valor14.doubleValue());
		values.put("valor15", valor15.doubleValue());
		values.put("valor16", valor16.doubleValue());
		values.put("valor17", valor17.doubleValue());
		values.put("valor18", valor18.doubleValue());
		values.put("valor19", valor19.doubleValue());
		values.put("valor20", valor20.doubleValue());
		values.put("valor21", valor21.doubleValue());
		values.put("valor22", valor22.doubleValue());
		values.put("valor23", valor23.doubleValue());
		values.put("valor24", valor24.doubleValue());
		values.put("valor25", valor25.doubleValue());
		values.put("valor26", valor26.doubleValue());
		values.put("valor27", valor27.doubleValue());
		values.put("valor28", valor28.doubleValue());
		values.put("valor29", valor29.doubleValue());
		values.put("valor30", valor30.doubleValue());
		values.put("valor31", valor31.doubleValue());
		values.put("valor32", valor32.doubleValue());
		
		return values;
	}
	
	

}
