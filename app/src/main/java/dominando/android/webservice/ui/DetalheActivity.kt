package dominando.android.webservice.ui

import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.squareup.picasso.Picasso
import dominando.android.webservice.R
import dominando.android.webservice.models.Quadrinho
import kotlinx.android.synthetic.main.activity_detalhe.*
import java.text.SimpleDateFormat
import java.util.*

class DetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        supportActionBar?.hide()

        btnVoltar.setOnClickListener {
            finish()
        }

        val quadrinhoVal = intent.getSerializableExtra("quadrinhoClick") as Quadrinho


        Picasso.get().load(quadrinhoVal.thumbnail.path.replace("http://", "https://") +"."+ quadrinhoVal.thumbnail.extension).into(quadrinhoCapa)
        Picasso.get().load(quadrinhoVal.thumbnail.path.replace("http://", "https://") +"."+ quadrinhoVal.thumbnail.extension).into(quadrinhoBanner)

        var descricao = quadrinhoVal?.description
        if (descricao==null)
        {
            descricao="API não possui descricao"
        }
        quadrinhoDescricao.text = descricao

        var titulo= quadrinhoVal?.title
        if(titulo == null) {
            titulo = "API NÃO POSSUI TITULO"
        }
        quadrinhoTitulo.text = titulo

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

        var data = quadrinhoVal?.dates?.get(0)?.dates
        quadrinhoData.text = "$data"

        var preco = quadrinhoVal?.prices?.get(0)?.price
        quadrinhoPreco.text = "$preco"

        var pagina = quadrinhoVal?.pageCount
        if(pagina == null){
            pagina=-1
        }
        quadrinhoPagina.text = pagina.toString()




        quadrinhoCapa.setOnClickListener {
            val intent = Intent(this, CapaActivity::class.java)
            intent.putExtra("quadrinhoClick", quadrinhoVal)
            startActivity(intent)
        }


    }
}