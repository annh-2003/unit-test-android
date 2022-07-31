package com.sun.training.ut.data.repository

import com.sun.training.ut.data.model.Post

/**
 * Main entry point for accessing data.
 */
interface SampleRepository {
    suspend fun getPosts(): List<Post>
}
