package dominando.android.webservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import dominando.android.webservice.R
import dominando.android.webservice.models.Quadrinho
import kotlinx.android.synthetic.main.activity_capa.*
import kotlinx.android.synthetic.main.activity_detalhe.*

class CapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)
        supportActionBar?.hide()

        val quadrinhoVal = intent.getSerializableExtra("quadrinhoClick") as Quadrinho

        Picasso.get().load(quadrinhoVal.thumbnail.path.replace("http://", "https://") +"."+ quadrinhoVal.thumbnail.extension).into(quadrinhoCapaExpandida)
        btnX.setOnClickListener {
            finish()
        }

    }
}