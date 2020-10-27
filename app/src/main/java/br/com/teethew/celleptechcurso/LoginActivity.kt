package br.com.teethew.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Capturando as referências para os componentes visuais
        val edtLoginEmail : EditText = findViewById(R.id.edtLoginEmail)
        val edtLoginSenha : EditText = findViewById(R.id.edtLoginSenha)
        val btnLoginEntrar : Button = findViewById(R.id.btnLoginEntrar)
        val btnLoginCadastrar : Button = findViewById(R.id.btnLoginCadastrar)

        // Criando o listener do button
        btnLoginEntrar.setOnClickListener {

            // Capturando os dados digitados pelo usuario
            val email = edtLoginEmail.text.toString().trim()
            val senha = edtLoginSenha.text.toString().trim()

            // Validação dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório"
                edtLoginEmail.requestFocus()
            } else if (senha.isEmpty()) {
                edtLoginSenha.error = "Campo obrigatório"
                edtLoginSenha.requestFocus()
            } else {
                // Verificação do email e senha corretos
                if (email == "teste@teste.com" && senha == "12345678") {

                    // Exibindo uma mensagem usando Toast
                    Toast.makeText(this, "Login efetuado com sucesso", Toast.LENGTH_LONG).show()

                    // Abrir MainActivity
                    val mIntent = Intent(this, MainActivity::class.java)

                    startActivity(mIntent)
                    finish()
                } else {
                    // Apresentar uma mensagem de erro usando Toast
                    Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_LONG).show()
                }
            }
        }

        // Listener do botão Cadastrar
        btnLoginCadastrar.setOnClickListener {
            // mudar para tela de cadastro
            val mIntent = Intent(this, CadastroActivity::class.java)

            startActivity(mIntent)
        }
    }
}