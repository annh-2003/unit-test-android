package com.sun.training.ut.data.repository.impl

import com.sun.training.ut.data.model.Post
import com.sun.training.ut.data.remote.ApiServiceInterface
import com.sun.training.ut.data.repository.SampleRepository

/**
 * Implementation of repository
 */
class SampleRepositoryImpl(private val api: ApiServiceInterface) : SampleRepository {
    override suspend fun getPosts(): List<Post> = api.getPosts()
}