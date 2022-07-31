package com.sun.training.ut.data.remote

import com.sun.training.ut.data.model.Post
import retrofit2.http.GET

/**
 * Interface apiService for declare api endpoint
 */
interface ApiServiceInterface {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
