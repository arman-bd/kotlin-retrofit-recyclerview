package test.kotlin.application.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import test.kotlin.application.Retrofit.Models.Repositories

interface GitHub {

    @Headers("Accept: application/vnd.github.inertia-preview+json")
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repositories>>

}

