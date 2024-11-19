package com.example.iadesocial.data

data class User(
    val userId: Int,
    val username: String,
    val email: String,
    val password: String,
    val profileId: Int
    //val dateOfBirth: String,
    //val registrationDate: String
)

fun sampleUser(): User {
    return ( User(20220296,"Kelvin","kelvinlamas@gmail.com","password",1))
}

fun sampleUsers(): List<User> {
    return listOf(
        User(20220296,"Kelvin","kelvinlamas@gmail.com","password",1),
        User(20220297,"Aricarlo","AricarloAlberto@gmail.com","password",2),
        User(20220298,"Edson","EdsonPeixoto@gmail.com","password",3),
    )
}

/*fun getUser(userId: Int): User {
    var user = 0
    var c = 0

    if(userId == 20220296) { return User[0] }
    else if(userId == 20220297) { return User[1] }
    else if(userId == 20220298) { return User[2] }
    else { return User[0] }
}*/
