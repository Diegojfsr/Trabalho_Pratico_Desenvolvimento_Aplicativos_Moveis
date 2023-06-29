package br.com.ifsudestemg.sistemapdvif.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.R;
import br.com.ifsudestemg.sistemapdvif.domain.AppDatabase;
import br.com.ifsudestemg.sistemapdvif.domain.CidadeDAO;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Cidade;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListagemConsultaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListagemConsultaFragment extends Fragment {

    private RecyclerView lstCidade;

    private CidadeDAO cidadeDAO;

    public ListagemConsultaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListagemCidadeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListagemConsultaFragment newInstance(String param1, String param2) {
        ListagemConsultaFragment fragment = new ListagemConsultaFragment();
         return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AppDatabase db = AppDatabase.getDatabase(getContext());
        cidadeDAO = db.cidadeDAO();

        List<Cidade> dados =cidadeDAO.buscarTodos();

        View layout = inflater.inflate(R.layout.fragment_listagem_consulta, container, false);

        lstCidade = layout.findViewById(R.id.lstCidade);

        //Configurando o layout do RecycleView;
        RecyclerView.LayoutManager manager
                = new LinearLayoutManager(this.getContext());
        lstCidade.setLayoutManager(manager);

        //Criando a instância do CustomAdapter para ser utilizado no RecycleView
        CidadeAdapter adapter = new CidadeAdapter(dados, getActivity());

        lstCidade.setAdapter(adapter);

        return layout;
    }
}