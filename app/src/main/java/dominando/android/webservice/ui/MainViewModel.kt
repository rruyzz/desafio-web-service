package dominando.android.webservice.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dominando.android.webservice.models.Quadrinho
import dominando.android.webservice.service.Service
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainViewModel(private val service: Service): ViewModel() {

    val listaQuadrinho = MutableLiveData<ArrayList<Quadrinho>>()

    fun getQuadrinho(){
        try {
            viewModelScope.launch{
                val response = service.getQuadrinhoRepo(
                    1,
                    100,
                    "1",
                    "6eb7e8896ec5850c52515a8a23ee97f0",
                    "40a3aa568bb269dfad85ae0c4a297181"
                )
                val results = response.get("data").asJsonObject.get("results")
                val quadrinhoObj = Gson().fromJson(results, object : TypeToken<List<Quadrinho>>() {}. type ) as ArrayList<Quadrinho>
                listaQuadrinho.value = quadrinhoObj
            }
        } catch (e: Exception){
            Log.i("Erro", "Erro")
            throw java.lang.Exception()
        }
    }
}

