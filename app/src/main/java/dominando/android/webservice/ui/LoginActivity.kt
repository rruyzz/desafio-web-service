package dominando.android.webservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dominando.android.webservice.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        chkRemember.isChecked = true

        txtCreate.setOnClickListener {
            val intent= Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
        btnLgn.setOnClickListener {
            val intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}