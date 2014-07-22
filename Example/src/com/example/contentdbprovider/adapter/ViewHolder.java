package com.example.contentdbprovider.adapter;
import android.widget.TextView;

public class ViewHolder {

	private TextView cod;
	private TextView desc;
	private TextView valor;

	public ViewHolder(TextView cod, TextView desc, TextView valor) {
		this.cod = cod;
		this.desc = desc;
		this.valor = valor;
	}

	public TextView getCod() {
		return cod;
	}
	public TextView getDesc() {
		return desc;
	}
	public TextView getValor() {
		return valor;
	}

}