package br.edu.up.cidades.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.up.cidades.R;
import br.edu.up.cidades.dal.CidadeDAO;
import br.edu.up.cidades.model.Cidade;

public class CadastrarCidadesActivity extends AppCompatActivity {

    private EditText edtNome, edtPopulacao, edtEstado;
    private Button btnCadastrarCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cidades);

        edtEstado = (EditText) findViewById(R.id.edtEstado);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtPopulacao = (EditText) findViewById(R.id.edtPopulacao);
        btnCadastrarCidade = (Button) findViewById(R.id.btnCadastrarCidade);
    }

    public void btnCadastrarClick(View view) {
        if(!edtNome.getText().toString().equals("")) {
            //Exemplo Lista Simples
            String nomeCidade = edtNome.getText().toString();
            CidadeDAO.cadastrarCidade(nomeCidade);

            //Exemplo Lista Avançada
            Cidade c = new Cidade();
            c.setNome(edtNome.getText().toString());
            c.setEstado(edtEstado.getText().toString());
            c.setPopulacao(edtPopulacao.getText().toString());
            if(CidadeDAO.cadastrarCidade(c, this) != -1){
                Toast.makeText(this,
                        "Cidade cadastrada com sucesso!",
                        Toast.LENGTH_SHORT).show();
                edtNome.setText("");
                edtEstado.setText("");
                edtPopulacao.setText("");
                edtNome.requestFocus();
            }else{
                Toast.makeText(this,
                        "Cidade não cadastrada!",
                        Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Favor preecher o nome!", Toast.LENGTH_SHORT).show();
        }
    }
}











