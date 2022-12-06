rpackage com.example.tpandroid.Retrofit

import retrofit2.http.GET

interface RetrofitService {
    @GET("/exempleEndpoint")
    suspend fun getData(): List<WhereIsDataInJson>
}