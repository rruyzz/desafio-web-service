package dominando.android.webservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dominando.android.webservice.R
import dominando.android.webservice.models.Quadrinho
import dominando.android.webservice.ui.MainActivity
import kotlinx.android.synthetic.main.rv_quadrinho.view.*

class QuadrinhoAdapter(var listener: OnClickQuadrinhoListener, var context: MainActivity) : RecyclerView.Adapter<QuadrinhoAdapter.QuadrinhoAdapterViewHolder>(){

    var listaQuadrinho = arrayListOf<Quadrinho>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuadrinhoAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_quadrinho, parent, false)
        return QuadrinhoAdapterViewHolder(itemView)
    }

    override fun getItemCount() = listaQuadrinho.size

    fun addQuadrinho(lista: ArrayList<Quadrinho>) {
        listaQuadrinho.addAll(lista)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: QuadrinhoAdapter.QuadrinhoAdapterViewHolder,
        position: Int
    ) {
        val quadrinho = listaQuadrinho[position]
        holder.numeroQuadrinho.text = quadrinho.id.toString()
        Picasso.get().load(quadrinho.thumbnail.path.replace("http://", "https://") +"."+ quadrinho.thumbnail.extension).into(holder.capaQuadrinho)

    }

    interface OnClickQuadrinhoListener{
        fun quadrinhoClick(position: Int)
    }

    inner class QuadrinhoAdapterViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val capaQuadrinho: ImageView = itemView.findViewById(R.id.imgquadrinho)
        val numeroQuadrinho: TextView = itemView.numberquadrinho

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(RecyclerView.NO_POSITION != position)
                listener.quadrinhoClick(position)
        }
    }

}