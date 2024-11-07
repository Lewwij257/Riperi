package data.remote

import com.google.firebase.database.core.Repo
import data.model.CarBrand
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    //Возвращает все брэнды
    @GET("/api/?format=json&select=make&api_key=Your_Database_Api_Key")
    fun getAllCarBrand(): Call<List<CarBrand>>

}