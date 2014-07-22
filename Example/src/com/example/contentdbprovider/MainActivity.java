package com.example.contentdbprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contentdbprovider.adapter.ViewHolder;
import com.example.contentdbprovider.domain.Produto;
import com.example.dbprovider.ListContentActivity;
import com.example.dbprovider.listener.QueryListener;

public class MainActivity extends ListContentActivity implements QueryListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
//		for (int i = 0; i < 15000; i++) {
//			String word = GeradorPalavras.gerar((int) (Math.random()*24));
//			System.out.println(word);
//			Produto produto = new Produto();
//			produto.setDescricao(word);
//			produto.setValor(BigDecimal.valueOf(i*word.length()));
//			getContentResolver().insert(Produto.CONTENT_ID_URI_BASE, produto.getValues());
//		}
		
		
		enablePositionSearch(true);
		
		EditText txt = (EditText) findViewById(R.id.search);
		txt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				search(new String[]{s.toString()});

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	
	@Override
	public void bindView(int position, View view, Cursor cursor) {
		super.bindView(position, view, cursor);
		
			ViewHolder holder = (ViewHolder) view.getTag();

			TextView tvDescricao;
			TextView tvCodigo;
			TextView tvValor; 
			
			
//			Produto produto = createObject(Produto.class, cursor);

			tvDescricao = holder.getDesc();
			tvCodigo = holder.getCod();
			tvValor = holder.getValor();

//			tvDescricao.setText(produto.getDescricao());
//			tvCodigo.setText(produto.getCodigo().toString());
//			tvValor.setText(produto.getValor().toString());
		
	}
	
	@Override
	public View createViewHolder(View view) {
		ViewHolder holder = (ViewHolder) view.getTag();
		if (holder == null) {
			TextView tvDescricao = (TextView) view.findViewById(	R.list_produtos_id.txt_descricao);
			TextView tvCodigo = (TextView) view.findViewById(R.list_produtos_id.txt_codigo);
			TextView tvValor = (TextView) view.findViewById(R.list_produtos_id.txt_valor);
			holder = new ViewHolder(tvCodigo,tvDescricao,tvValor );
			view.setTag(holder);
		}

		return view;
	}
	
	@Override
	public void onListItemClick(View view, int position, long id) {
			Cursor cursor = (Cursor) getListView().getAdapter().getItem(position);
//			Produto produto = //createObject(Produto.class, cursor);
//			System.out.println("tocou >>>>>> "+produto.getDescricao());
	}



	@Override
	public String initQuery() {

		String query = "select p.* from Produto p order by descricao";
		return query;

	}


	@Override
	public String onQueryChange(String[] params) {
		String parametro = params[0];
		String query = initQuery();
		if (!parametro.toString().equals("")) {
			query = "select p.* from produto p where descricao like '"+parametro+"%' order by descricao";
		}
		
		return query;
	}


	@Override
	public QueryListener getQueryListener() {
		return this;
	}


	@Override
	public int getListLayoutId() {
		return R.layout.list_produto;
	}


	@Override
	public String getClassName() {
		return "Produto";
	}
	

}
