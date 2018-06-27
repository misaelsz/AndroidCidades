package br.edu.up.cidades.dal;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import br.edu.up.cidades.model.Cidade;

public class CidadeDAO {

    private static ArrayList<String> cidades = new ArrayList<String>();
    private static ArrayList<Cidade> objetosCidades =
            new ArrayList<Cidade>();

    public static void cadastrarCidade(String nomeCidade){
        cidades.add(nomeCidade);
        Log.v("Quantidade", String.valueOf(cidades.size()));
    }

    public static ArrayList<String> retornarCidades(){
        return cidades;
    }

    public static long cadastrarCidade(Cidade cidade, Context context){
//        objetosCidades.add(cidade);
        Banco b = new Banco(context);
        return b.cadastrarCidade(cidade);
    }

    public static ArrayList<Cidade> retornarObjetosCidades(Context context){
        Banco b = new Banco(context);
        return b.retornarCidades();
    }

}









