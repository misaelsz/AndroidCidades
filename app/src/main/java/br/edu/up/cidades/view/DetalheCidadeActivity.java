package br.edu.up.cidades.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.edu.up.cidades.R;
import br.edu.up.cidades.model.Cidade;

public class DetalheCidadeActivity extends AppCompatActivity {

    private TextView txtNomeDetalhe, txtEstadoDetalhe, txtPopulacaoDetalhe;
    private Cidade cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cidade);

        txtNomeDetalhe = (TextView) findViewById(R.id.txtNomeDetalhe);
        txtPopulacaoDetalhe = (TextView) findViewById(R.id.txtPopulacaoDetalhe);
        txtEstadoDetalhe = (TextView) findViewById(R.id.txtEstadoDetalhe);

        cidade = (Cidade) getIntent().getSerializableExtra("Cidade");

        txtNomeDetalhe.setText(cidade.getNome());
        txtPopulacaoDetalhe.setText(cidade.getPopulacao());
        txtEstadoDetalhe.setText(cidade.getEstado());

    }

    public void btnEnviarEmailClick(View view) {
        String[] emails = new String[]{
                "diogo.deconto@up.edu.br",
                "maria@maria.com.br"
        };

        String conteudo = "Cidade: " + cidade.getNome() +
                "\nEstado: " + cidade.getEstado() +
                "\nPopulação: " + cidade.getPopulacao();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, emails);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Detalhe da Cidade");
        intent.putExtra(Intent.EXTRA_TEXT, conteudo);
        startActivity(Intent.createChooser(intent,"Escolha um aplicativo"));

    }
}













