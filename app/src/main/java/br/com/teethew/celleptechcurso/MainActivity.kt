package br.com.teethew.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declarando Textviews e botões
        val txvMainNome: TextView = findViewById(R.id.txvMainNome)
        val txvMainEmail: TextView = findViewById(R.id.txvMainEmail)
        val txvMainGenero: TextView = findViewById(R.id.txvMainGenero)
        val btnMainSair: Button = findViewById(R.id.btnMainSair)
        val btnMainSite: Button = findViewById(R.id.btnMainSite)

        // Recuperando o email passado pela Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        // Acessando o arquivo SharedPreferences
        val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

        // Recuperando dados do arquivo SharedPreferences
        val nome = sharedPrefs.getString("NOME", "Nome não encontrado")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "Gênero não encontrado")

        // Exibindo os dados no TextView
        txvMainNome.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainGenero.text = genero

        // Listener do botão Sair
        btnMainSair.setOnClickListener {

            // Criando e definindo o alert Dialog
            val alert = AlertDialog.Builder(this)
                .setTitle("Atenção") // Definindo titulo
                .setMessage("Deseja mesmo sair?") // Definindo a mensagem
                .setPositiveButton("Sair") {_, _ ->
                    // Abrindo a tela Login
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)

                    finishAffinity()
                }
                .setNeutralButton("Cancelar") {_, _ ->}
                .setCancelable(true)

            alert.show()
        }

        //Listener do botão Site Cellep
        btnMainSite.setOnClickListener {
            // Abrindo a Web Activity versão single-line
            startActivity(Intent(this, WebActivity::class.java))
        }

    }
}