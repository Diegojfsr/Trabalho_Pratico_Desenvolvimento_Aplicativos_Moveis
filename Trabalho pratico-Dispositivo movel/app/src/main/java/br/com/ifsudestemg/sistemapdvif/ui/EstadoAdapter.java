package br.com.ifsudestemg.sistemapdvif.ui;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.R;
import br.com.ifsudestemg.sistemapdvif.domain.AppDatabase;
import br.com.ifsudestemg.sistemapdvif.domain.PacienteDAO;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Paciente;

public class EstadoAdapter
     extends RecyclerView.Adapter<EstadoAdapter.CustomAdapterViewHolder>
     implements View.OnClickListener{

    /**
     * Objeto que representa os dados que serão exibidos na
     * lista.
     */
    private List<Paciente> localDataSet;

    /***
     * Objeto utilizado para referência o Activity no CustomAdapter.
     * Desta forma podemos chamar algumas operações do Activity através
     * do CustomAdapter, como por exemplo, chamar outras telas.
      */
    private Activity activity;

    /**
     * Marca a posição atual do item na lists
     */
    private int posicaoAtual = 0;

    /**
     * Inicializa os dados do Adapter
     */
    public EstadoAdapter(List<Paciente> dataSet, Activity act) {
        localDataSet = dataSet;
        activity = act;
    }

    @Override
    public void onClick(View v) {
        //Recuperando o item da lista de acordo com a posição
        //atual
        int posicao = (int)v.getTag();
        Paciente paciente = localDataSet.get(posicao);

        //Se a referência do click for um TextView
        if (v.getId() == R.id.txtItem){
            Intent it = new Intent(activity, CadPacienteActivity.class);
            it.putExtra("ITEM", paciente);
            activity.startActivityForResult(it, 1);
        }

        if (v.getId() == R.id.btnExcluir){

            AppDatabase db = AppDatabase.getDatabase(activity);
            PacienteDAO estadoDAO = db.pacienteDAO();
            estadoDAO.excluir(paciente);

            localDataSet.remove(posicao);
            //Notifica o RecycleView que ele foi alterado
            //após a exclusão do item
            notifyDataSetChanged();

        }



    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public class CustomAdapterViewHolder extends
                    RecyclerView.ViewHolder {
        private final TextView txtItem;
        private final Button btnExcluir;

        public CustomAdapterViewHolder(View view) {
            super(view);
            txtItem    = view.findViewById(R.id.txtItem);
            btnExcluir = view.findViewById(R.id.btnExcluir);

            /**
             * Neste trecho de código estamos passando a referência
             * da classse que contém o ouvinte de eventos OnClickListener
             * implementado.
             * */
            txtItem.setOnClickListener(EstadoAdapter.this);
            btnExcluir.setOnClickListener(EstadoAdapter.this);


        }

        public TextView getTxtItem() {
            return txtItem;
        }

        public Button getBtnExcluir(){
            return btnExcluir;
        }

    }


    /**
     * O método onCreateViewHolder é um método responsável por
     * carregar o layout das linhas do componente RecyclerView.
     * Devemos utilizar a classe interna declarada internamente
     * dentro desta classe.
     */
    @Override
    public CustomAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        /**
         * Primeiro criamos um objeto do tipo View para armazenar
         * as informações do layout carregado. Para isso, utilizamos
         * a classe LayoutInflater e devemos passar o layout que
         * desejamos que as linhas do componente RecycleView tenha.
         * Após criar um instância do objeto View, devemos criar uma
         * instância da classe ViewHolder declarada internamente.
         */
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_linha, viewGroup, false);

        return new CustomAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapterViewHolder viewHolder, final int position) {

        //Recuperando valor da linha atual no RecycleView
        Paciente item = localDataSet.get(position);

        viewHolder.getTxtItem().setText(item.nome);

        /**
         * Gravando a posição atual para cada objeto de texto
         * exibido na lista.
         */
        viewHolder.getTxtItem().setTag(position);
        viewHolder.getBtnExcluir().setTag(position);




    }

    // Retorna a quantidade de dados armazenados na lista
    @Override
    public int getItemCount(){
        return localDataSet.size();
    }

}