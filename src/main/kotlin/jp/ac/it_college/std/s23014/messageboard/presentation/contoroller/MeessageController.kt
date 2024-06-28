package jp.ac.it_college.std.s23014.messageboard.presentation.contoroller

import jp.ac.it_college.std.s23014.messageboard.domain.model.Messages
import jp.ac.it_college.std.s23014.messageboard.infrastructure.database.dao.MessageTable.message
import jp.ac.it_college.std.s23014.messageboard.infrastructure.database.dao.MessageTable.updatedAt
import jp.ac.it_college.std.s23014.messageboard.presentation.from.*
import jp.ac.it_college.std.s23014.messageboard.security.MessageService
import jp.ac.it_college.std.s23014.messageboard.security.ThreadService
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/messages")
@CrossOrigin
class MessageController(
    private val messageService: MessageService,
    private val threadService: ThreadService,
) {
    @GetMapping("/list/thread/{thread_id}")
    fun getList(@PathVariable(value = "thread_id") threadId: Long): GetMessageListResponse {
        val thread = threadService.getDetails(threadId)
        val messages = messageService.getListByThread(threadId)

        if (thread == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND,"Thread not found with id")
        }
        return GetMessageListResponse(
            threadId = threadId,
            title = thread.title,
            messages = messages.map(::MessageInfo)
        )
    }
}

    @PostMapping("/post/thread/{thread_id}")
    fun postMessage(
        @PathVariable(value = "thread_id") threadId: Long,
        @RequestBody req: PostMessageRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): PostedMessageResponse {
        val newMessage = Messages.newPost(threadId, req.message, user.id)
        return PostedMessageResponse(newMessage)
    }

    @PutMapping("/update/{id}")
    fun putMessage(
        @PathVariable(value = "id") id: Long,
        @RequestBody req: PutMessageUpdateRequest,
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): MessageUpdateResponse {
        val updatedMessage = MessageService.updateMessage(id, req.message, user.id)
        return updatedMessage.run {
            MessageUpdateResponse(
                id = id, threadId = thread.id, message = message, updatedAt = updatedAt
            )
        }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteMessage(
        @PathVariable("id") id: Long,
        @AuthenticationPrincipal user: MessageBoardUserDetails
    ): MessageDeleteResponse {
        val result = MessageService.deleteMessage(id, user.id)
        return result.run {
            MessageDeleteResponse(id, thread.id, updatedAt)
        }
    }
}