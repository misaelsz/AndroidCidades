package br.edu.up.cidades.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.edu.up.cidades.R;
import br.edu.up.cidades.model.Cidade;
import br.edu.up.cidades.view.DetalheCidadeActivity;

public class ArrayAdapterCidades extends ArrayAdapter<Cidade>{

    private TextView txtNome, txtPopulacao, txtEstado;
    private ArrayList<Cidade> cidades;
    private Context context;

    public ArrayAdapterCidades(Context context, ArrayList<Cidade> cidades) {
        super(context, 0, cidades);
        this.cidades = cidades;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Cidade cidade = cidades.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_list_layout, null);
        }

        txtNome = (TextView) convertView.findViewById(R.id.txtNome);
        txtEstado = (TextView) convertView.findViewById(R.id.txtEstado);
        txtPopulacao = (TextView) convertView.findViewById(R.id.txtPopulacao);

        txtNome.setText(cidade.getNome());
        txtEstado.setText(cidade.getEstado());
        txtPopulacao.setText(cidade.getPopulacao());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalheCidadeActivity.class);
                intent.putExtra("Cidade", cidade);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}













