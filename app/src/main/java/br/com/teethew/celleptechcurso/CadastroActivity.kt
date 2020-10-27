package br.com.teethew.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Obtendo as referências para os componentes
        val edtCadastroNome: EditText = findViewById(R.id.edtCadastroNome)
        val edtCadastroSobrenome: EditText = findViewById(R.id.edtCadastroSobrenome)
        val edtCadastroEmail: EditText = findViewById(R.id.edtCadastroEmail)
        val edtCadastroSenha: EditText = findViewById(R.id.edtCadastroSenha)
        val spnCadastroGenero: Spinner = findViewById(R.id.spnCadastroGenero)
        val btnCadastroCadastrar: Button = findViewById(R.id.btnCadastroCadastrar)


        // Criando uma lista de opções para o Spinner
        val listaGeneros = arrayListOf("Selecione o gênero", "Masculino", "Feminino", "Outro(a)")

        // Criando um adaptador para o Spinner
        val generoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item, //layout
            listaGeneros
        )

        // Plugar a lista adaptada no Spinner
        spnCadastroGenero.adapter = generoAdapter

        // Listener do botão Cadastrar
        btnCadastroCadastrar.setOnClickListener {

            // Obtendo os dados inseridos pelo usuário
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim()
            val senha = edtCadastroSenha.text.toString().trim()

            val genero = spnCadastroGenero.selectedItem.toString()

            // Validação dos campos
            if (nome.isEmpty() || sobrenome.isEmpty()
                || email.isEmpty() || senha.isEmpty()
                || genero == listaGeneros[0]) {

                // Exibindo uma mensagem de erro usando Toast
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {

                // Criando ou acessar o arquivo SharedPreferences
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                // Criando uma referência para o editor do arquivo
                val editPrefs = sharedPrefs.edit()

                // Definindo as alterações do arquivo
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                // Salvando as alterações no arquivo SharedPreferences
                editPrefs.apply()

                // Abrindo a tela Main
                val mIntent = Intent(this, MainActivity::class.java)

                // Passando dados de uma Activity para outra, utilizando a intent
                mIntent.putExtra("INTENT_EMAIL", email)

                startActivity(mIntent)

                finishAffinity() // Encerra a tela atual e as anteriores da pilha
            }
        }
    }
}