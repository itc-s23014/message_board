<<<<<<< HEAD:src/main/kotlin/jp/ac/it_college/std/s23014/messageboard/application/service/ThreadService.kt
package jp.ac.it_college.std.s23014.messageboard.application.service
=======
package jp.ac.it_college.std.s23014.messageboard.security


>>>>>>> parent of 08f068b (課題最終push):src/main/kotlin/jp/ac/it_college/std/s23014/messageboard/security/ThreadService.kt
import jp.ac.it_college.std.s23014.messageboard.domain.model.Threads
import jp.ac.it_college.std.s23014.messageboard.domain.repository.ThreadRepository
import kotlinx.datetime.LocalDateTime
import org.springframework.stereotype.Service


@Service
class ThreadService(
    private val threadRepository: ThreadRepository,
) {
    fun createThread(
        title: String,
        userId: Long,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime,
        deleted: Boolean
    ): Threads {
        val newThread = Threads(
            id = 0,
            title = title,
            userId = userId,
            createdAt = createdAt,
            updatedAt = updatedAt,
            deleted = deleted,
        )
        return threadRepository.createThread(newThread)
    }

    fun getThreadById(id: Long): Threads? {
        return threadRepository.getThreadById(id)

    }

    fun getThreadlist(): List<Threads> {
        return threadRepository.getAllThreads()
    }
    fun getDetailsById(id: Long): Threads? {
        return threadRepository.getDetails(id)
    }

//    fun newPost(title: String, message: String, userId: Long): Threads {
//        val now = java.time.LocalDateTime.now()
//
//        val newThread = Threads(
//            title = title,
//            userId = userId,
//            createdAt = now.toKotlinLocalDateTime(),
//            updatedAt = now.toKotlinLocalDateTime(),
//            deleted = false,
//            id = 0
//        )
//
//        // スレッドを保存して、保存後のスレッドのIDを取得する
////        val savedThread = threadRepository.save(newThread)
//
////        return savedThread  // 保存後のスレッドのIDを返す
//   }


//
//    fun updateThread(
//        id: Long,
//        title: String,
//        userId: Long,
//        createdAt: LocalDateTime,
//        updatedAt: LocalDateTime,
//        deleted: Boolean
//    ): Threads {
//        val existingThread = threadRepository.getThreadById(id)
//            ?: throw IllegalArgumentException("Thread not found with id")
//        val updatedThread = existingThread.copy(
//            title = title,
//            userId = userId,
//            createdAt = createdAt,
//            updatedAt = updatedAt,
//            deleted = deleted
//        )
//        return threadRepository.updateThread(updatedThread)
//    }
//
//    fun deleteThread(id: Long) {
//        threadRepository.deleteThread(id)
//    }
//

    }
