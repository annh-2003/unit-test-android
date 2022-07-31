package com.sun.training.ut.exercise_ten.data.model

/**
 * Define a user with minimum attribute
 * @userId: is ID of user when use the service of restaurant
 * @userName: name of user, show it in UI
 * @classType: the current Class Type when use the service of restaurant
 * @point: the points accumulated after each use of the service at the restaurant
 *      It will increase after each use of the service
 *      The Class Type will depend of the points
 */
data class User(
    val userId: Int,
    val userName: String,
    var classType: Int = MemberClassType.UNKNOWN_CLASS,
    var point: Int = 0,
)