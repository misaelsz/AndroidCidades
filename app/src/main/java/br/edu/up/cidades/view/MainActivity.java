package br.edu.up.cidades.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.edu.up.cidades.R;
import br.edu.up.cidades.dal.Banco;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnListar = (Button) findViewById(R.id.btnListaSimples);


    }

    public void btnCadastrarClick(View view) {
        Intent intent = new Intent(this, CadastrarCidadesActivity.class);
        startActivity(intent);
    }

    public void btnListaSimplesClick(View view) {
        Intent intent = new Intent(this, ListaSimplesCidadesActivity.class);
        startActivity(intent);
    }

    public void btnListaAvancadaClick(View view) {
        Intent intent = new Intent(this, ListaAvancadaCidadesActivity.class);
        startActivity(intent);
    }
}











