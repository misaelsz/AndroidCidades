package br.edu.up.cidades.dal;

import android.provider.BaseColumns;

public class Contrato {

    private Contrato() {}

    //Declarar todas as classes que vão virar tabela no banco
    public static class TabelaCidade implements BaseColumns{
        public static final String NOME_TABELA = "tbCidades";
        public static final String CIDADE = "Cidade";
        public static final String POPULACAO = "Populacao";
        public static final String ESTADO = "Estado";
    }

    //Exemplo com mais uma tabela
    public static class TabelaEstado implements BaseColumns{
        public static final String NOME_TABELA = "tbEstados";
        public static final String ESTADO = "Estado";
    }

}
