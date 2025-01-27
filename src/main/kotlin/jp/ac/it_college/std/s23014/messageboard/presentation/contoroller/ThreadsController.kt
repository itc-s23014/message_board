package jp.ac.it_college.std.s23014.messageboard.presentation.contoroller
<<<<<<< HEAD

import jp.ac.it_college.std.s23014.messageboard.infrastructure.database.dao.ThreadsTable.title
import jp.ac.it_college.std.s23014.messageboard.infrastructure.database.dao.ThreadsTable.updatedAt
import jp.ac.it_college.std.s23014.messageboard.infrastructure.database.dao.ThreadsTable.userId
import jp.ac.it_college.std.s23014.messageboard.presentation.from.*
import jp.ac.it_college.std.s23014.messageboard.application.service.MessageBoardUserDetailsService
import jp.ac.it_college.std.s23014.messageboard.application.service.ThreadService
import kotlinx.datetime.toJavaLocalDateTime
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/threads")
@CrossOrigin
class ThreadController(
    private val service: ThreadService
) {
    @GetMapping("/list")
    fun getList(): GetThreadListResponse {
        val threadList = service.getThreadlist().map { thread ->
            ThreadInfo(
                id = thread.id,
                title = thread.title,
                createdAt = thread.createdAt.toJavaLocalDateTime()
            )
        }
        return GetThreadListResponse(threadList)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody body: PostThreadRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetailsService
    ): CreatedThreadResponse {
        val newId = service.newPost(body.title, body.message, user.getId())
        return CreatedThreadResponse(newId)
    }
}


    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody body: PutThreadUpdateRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetailsService
    ): ThreadUpdateResponse {
        val thread = service.updateTitle(id, body.title, user.getId())
        return ThreadUpdateResponse(thread.id, thread.title)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteThread(
        @PathVariable id: Long,
        @AuthenticationPrincipal user: MessageBoardUserDetailsService
    ): ThreadDeleteResponse {
        val result = service.deleteThread(id)
        return ThreadDeleteResponse(result.id, result.title, result.updatedAt)
    }
}
=======
//
//import jp.ac.it_college.std.s23014.messageboard.infrastructure.database.dao.ThreadsTable.title
//import jp.ac.it_college.std.s23014.messageboard.presentation.from.*
//import org.springframework.security.core.annotation.AuthenticationPrincipal
//import org.springframework.web.bind.annotation.*
//
//class ThreadsController {
//    @RestController
//    @RequestMapping("/threads")
//    @CrossOrigin
//    class ThreadController(
//        private val service: ThreadService
//    ) {
//        @GetMapping("/list")
//        fun getList(): GetThreadListResponse {
//            val threadList = service.getList().map(::ThreadInfo)
//            return GetThreadListResponse(threadList)
//        }
//
//        @PostMapping("/create")
//        fun create(
//            @RequestBody body: PostThreadRequest,
//            @AuthenticationPrincipal user: MessageBoardUserDetails
//        ): CreatedThreadResponse {
//            val newId = service.newPost(body.title, body.message, user.id)
//            return CreatedThreadResponse(newId)
//        }
//
//        @PutMapping("/update/{id}")
//        fun update(
//            @PathVariable id: Long,
//            @RequestBody body: PutThreadUpdateRequest,
//            @AuthenticationPrincipal user: MessageBoardUserDetails
//        ): ThreadUpdateResponse {
//            val thread = service.updateTitle(id, body.title, user.id)
//            return thread.run { ThreadUpdateResponse(id, title) }
//        }
//
//        @DeleteMapping("/delete/{id}")
//        fun deleteThread(
//            @PathVariable id: Long,
//            @AuthenticationPrincipal user: MessageBoardUserDetails
//        ): ThreadDeleteResponse {
//            val result = service.delete(id, user.id)
//            return result.run {
//                ThreadDeleteResponse(id, title, updatedAt)
//            }
//        }
//    }
//}
>>>>>>> parent of 08f068b (課題最終push)
