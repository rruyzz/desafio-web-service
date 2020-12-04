package dominando.android.webservice.service

import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import dominando.android.webservice.models.Quadrinho
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.Serializable

interface Service {

    @GET("characters/1009610/comics")

    suspend fun getQuadrinhoRepo(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): JsonObject


}
val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com/v1/public/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val service: Service = retrofit.create(Service::class.java)