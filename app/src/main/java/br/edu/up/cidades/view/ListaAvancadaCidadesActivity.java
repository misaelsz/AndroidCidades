package br.edu.up.cidades.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.edu.up.cidades.R;
import br.edu.up.cidades.dal.CidadeDAO;
import br.edu.up.cidades.util.ArrayAdapterCidades;

public class ListaAvancadaCidadesActivity extends AppCompatActivity {

    private ListView lstAvancadaCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_avancada_cidades);

        lstAvancadaCidades = (ListView) findViewById(R.id.lstAvancadaCidades);

        ArrayAdapterCidades arrayAdapterCidades =
                new ArrayAdapterCidades(this,
                        CidadeDAO.retornarObjetosCidades(this));

        lstAvancadaCidades.setAdapter(arrayAdapterCidades);

    }
}











