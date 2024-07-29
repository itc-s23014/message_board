<<<<<<< HEAD:src/main/kotlin/jp/ac/it_college/std/s23014/messageboard/application/service/MessageBoardUserDetailsService.kt
package jp.ac.it_college.std.s23014.messageboard.application.service
import org.springframework.security.core.GrantedAuthority

class MessageBoardUserDetailsService(
    private val id: Long,
=======
package jp.ac.it_college.std.s23014.messageboard.security

import org.springframework.security.core.GrantedAuthority

class MessageBoardDetail {
>>>>>>> parent of 08f068b (課題最終push):src/main/kotlin/jp/ac/it_college/std/s23014/messageboard/security/MessageBoardDetail.kt
    private val username: String,
    private val password: String,
    private val authorities: Collection<GrantedAuthority>,
    private val enabled: Boolean = true,
    private val accountNonExpired: Boolean = true,
    private val accountNonLocked: Boolean = true,
    private val credentialsNonExpired: Boolean = true
<<<<<<< HEAD:src/main/kotlin/jp/ac/it_college/std/s23014/messageboard/application/service/MessageBoardUserDetailsService.kt
) {

    fun getId(): Long {
        return id
    }
=======
>>>>>>> parent of 08f068b (課題最終push):src/main/kotlin/jp/ac/it_college/std/s23014/messageboard/security/MessageBoardDetail.kt
}