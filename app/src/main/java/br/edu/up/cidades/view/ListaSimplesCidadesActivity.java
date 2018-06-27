package br.edu.up.cidades.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.edu.up.cidades.R;
import br.edu.up.cidades.dal.CidadeDAO;

public class ListaSimplesCidadesActivity extends AppCompatActivity {

    private ListView lstCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_simples_cidades);

        lstCidades = (ListView) findViewById(R.id.lstSimplesCidades);

//        String[] opcoes = new String[]{
//                "Configurações",
//                "Conta",
//                "Sair"
//        };

        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<String>
                        (this,
                                android.R.layout.simple_list_item_1,
                                CidadeDAO.retornarCidades());

        lstCidades.setAdapter(stringArrayAdapter);

        lstCidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaSimplesCidadesActivity.this, "Posição: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}










