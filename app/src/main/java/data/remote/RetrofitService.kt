package data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {

    companion object{

        private lateinit var retrofit: Retrofit
        private lateinit var apiService: ApiService

        fun getInstance():ApiService{
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder().baseUrl(data.constants.ApiConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

            }
            if(::retrofit.isInitialized){
                apiService = retrofit.create(ApiService::class.java)
            }

            return apiService

        }
    }

}