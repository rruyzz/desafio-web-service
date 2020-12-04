package dominando.android.webservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import dominando.android.webservice.R
import dominando.android.webservice.adapter.QuadrinhoAdapter
import dominando.android.webservice.service.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), QuadrinhoAdapter.OnClickQuadrinhoListener {

    lateinit var adapter : QuadrinhoAdapter
    lateinit var layout: GridLayoutManager

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
            setLogo(R.drawable.marvel_logo)
        }


        viewModel.getQuadrinho()

        adapter = QuadrinhoAdapter(this, this)
        layout = GridLayoutManager(this, 3)
        rvquadrinhos.adapter = adapter
        rvquadrinhos.layoutManager = layout
        rvquadrinhos.hasFixedSize()



        viewModel.listaQuadrinho.observe(this) {
            adapter.addQuadrinho(it)
        }


    }

    override fun quadrinhoClick(position: Int) {
        val quadrinhoClick = viewModel.listaQuadrinho.value?.get(position)

        val intent = Intent(this, DetalheActivity::class.java)
        intent.putExtra("quadrinhoClick", quadrinhoClick)
        startActivity(intent)

    }
}