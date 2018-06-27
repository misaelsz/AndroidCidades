package br.edu.up.cidades.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.cidades.model.Cidade;

public class Banco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "Cidades.db";
    public static final int VERSAO_BANCO = 1;

    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO = " INTEGER";
    public static final String VIRGULA = ", ";

    public static final String SQL_CRIAR_TABELA_CIDADE =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaCidade.NOME_TABELA +
                    "( " + Contrato.TabelaCidade._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaCidade.CIDADE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaCidade.ESTADO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaCidade.POPULACAO + TIPO_TEXTO + ");";

    public static final String SQL_DELETAR_TABELA_CIDADE =
            "DROP TABLE IF EXISTS " + Contrato.TabelaCidade.NOME_TABELA;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_CIDADE);
        db.execSQL(SQL_CRIAR_TABELA_CIDADE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("Banco", Banco.SQL_DELETAR_TABELA_CIDADE);
        db.execSQL(SQL_DELETAR_TABELA_CIDADE);
    }

    public long cadastrarCidade(Cidade c) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put(Contrato.TabelaCidade.CIDADE, c.getNome());
        dados.put(Contrato.TabelaCidade.POPULACAO, c.getPopulacao());
        dados.put(Contrato.TabelaCidade.ESTADO, c.getEstado());

        return db.insert(Contrato.TabelaCidade.NOME_TABELA, null, dados);
    }

    public ArrayList<Cidade> retornarCidades(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Cidade> cidades = new ArrayList<Cidade>();
        Cidade c = new Cidade();

        String[] colunas = new String[]{
                Contrato.TabelaCidade._ID,
                Contrato.TabelaCidade.CIDADE,
                Contrato.TabelaCidade.ESTADO,
                Contrato.TabelaCidade.POPULACAO
        };
//        Colocar o WHERE no terceiro parametro
//        Colocar o WHEREVALUES no quarto parametro

//        String where = Contrato.TabelaCidade.ESTADO + " = ?";
//        String[] valoresWhere = new String[]{
//                "PR"
//        };

        Cursor cursor = db.query(
                Contrato.TabelaCidade.NOME_TABELA,
                colunas,
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            do {
                //Preecher a lista com os dados cursor
                c = new Cidade();
                c.setNome(cursor.getString(1));
                c.setEstado(cursor.getString(2));
                c.setPopulacao(cursor.getString(3));
                cidades.add(c);
            }while (cursor.moveToNext());
            cursor.close();
            return cidades;
        }
        return null;
    }

    public int deletarCidades(int id){
        SQLiteDatabase db = getWritableDatabase();

        String where = Contrato.TabelaCidade._ID + " = ?";
        String[] valoresWhere = new String[]{
                String.valueOf(id)
        };

        return db.delete(
                Contrato.TabelaCidade.NOME_TABELA,
                where,
                valoresWhere);
    }

    public int alterarCidade(int id, Cidade cidade){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contrato.TabelaCidade.ESTADO, cidade.getEstado());

        String where = Contrato.TabelaCidade._ID + " = ?";
        String[] valoresWhere = new String[]{
                String.valueOf(id)
        };

        return db.update(
                Contrato.TabelaCidade.NOME_TABELA,
                contentValues,
                where,
                valoresWhere
        );
    }

}















