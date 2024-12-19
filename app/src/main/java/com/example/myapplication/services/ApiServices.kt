package com.example.myapplication.services
import quicktype.SampleDatum
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("/objects")
    suspend fun fetchItems(): List<SampleDatum>

    @GET("/objects/{id}")
    suspend fun fetchItem(@Path("id") id: String): SampleDatum

    @POST
    suspend fun createItem(item: SampleDatum): SampleDatum
}
