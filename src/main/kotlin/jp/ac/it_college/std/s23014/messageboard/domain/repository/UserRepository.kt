package jp.ac.it_college.std.s23014.messageboard.domain.repository

import jp.ac.it_college.std.s23014.messageboard.domain.model.Users


interface UserRepository {
<<<<<<< HEAD
    fun findByEmail(email: String): Users?
    fun findById(id: Long): Users?
    fun createUser(user: Users): Users
    fun deleteUser(id: Long)
    fun updateUser(user: Users): Users
    fun save (users: Users): Users

=======
    fun findByUsername(username: String): Users?
>>>>>>> parent of 08f068b (課題最終push)
}