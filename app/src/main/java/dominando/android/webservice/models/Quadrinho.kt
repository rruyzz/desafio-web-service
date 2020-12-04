package dominando.android.webservice.models

import android.media.Image
import android.provider.MediaStore
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Quadrinho(val id: Int,
                     val title: String,
                     var issueNumber: Int,
                     val thumbnail: Thumbnail,
                     var description: String,
                     val pageCount: Int,
                     val prices: List<ComicPrice>,
                     val dates: List<Day>,
                     val numero: Int,
                     val capa: List<Image>
) : Serializable

data class Day(val type: String, val dates: Date) : Serializable

data class Data(val offset: Int, var results: ArrayList<Quadrinho>)

data class ComicPrice(val type: String, val price: Float) : Serializable

data class Thumbnail(val path: String, val extension: String): Serializable


