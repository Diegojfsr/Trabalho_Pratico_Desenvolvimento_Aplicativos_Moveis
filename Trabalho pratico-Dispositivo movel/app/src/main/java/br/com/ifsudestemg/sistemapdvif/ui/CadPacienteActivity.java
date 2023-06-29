package br.com.ifsudestemg.sistemapdvif.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.ifsudestemg.sistemapdvif.R;
import br.com.ifsudestemg.sistemapdvif.ResultCodeActivity;
import br.com.ifsudestemg.sistemapdvif.databinding.ActivityCadPacienteBinding;
import br.com.ifsudestemg.sistemapdvif.domain.AppDatabase;
import br.com.ifsudestemg.sistemapdvif.domain.PacienteDAO;
import br.com.ifsudestemg.sistemapdvif.domain.entities.Paciente;

public class CadPacienteActivity extends AppCompatActivity {
    /**
     * Classe gerada pelo Android para que possamos
     * acessar os componentes da interface sem precisar
     * declarar os objetos utilizando o método findViewById
     */
    private ActivityCadPacienteBinding binding;
    /**
     * O objeto estado é utilizado para armazenar os dados
     * do cadastro para ser enviado par ao banco de dados
     */
    private Paciente paciente;

    //Objeto utilizado para realizar as operações da base dados
    private PacienteDAO pacienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Configurando o recurso de Binding
         */
        binding = ActivityCadPacienteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AppDatabase db = AppDatabase.getDatabase(this);
        pacienteDAO = db.pacienteDAO();

        /**
         * Recuperando parâmetros enviados de outro Activity
         */
        Intent it = getIntent();
        if (it != null){
            /**
             * Para recuperar um objeto devemos converter para o
             * tipo apropriado.
             */
            if (it.hasExtra("ITEM")) {
                paciente = (Paciente) it.getSerializableExtra("ITEM");
                binding.edtNome.setText(paciente.nome);
                binding.edtSigla.setText(paciente.cpf);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_confirmarcancelar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_confirmar:

                if (paciente == null){
                    paciente = new Paciente();
                    paciente = popularObjeto(paciente);
                    pacienteDAO.inserir(paciente);
                }
                else{
                    paciente = popularObjeto(paciente);
                    pacienteDAO.atualizar(paciente);
                }

                setResult(ResultCodeActivity.OK);
                finish();

            case android.R.id.home:
                setResult(ResultCodeActivity.CANCEL);
                finish();
                break;

            case R.id.action_cancelar:
                setResult(ResultCodeActivity.CANCEL);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private Paciente popularObjeto(Paciente paciente) {
        paciente.nome  = binding.edtNome.getText().toString();
        paciente.cpf = binding.edtSigla.getText().toString();
        return paciente;
    }

}