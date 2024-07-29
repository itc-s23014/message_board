package jp.ac.it_college.std.s23014.messageboard.security


import jp.ac.it_college.std.s23014.messageboard.domain.model.Messages
import jp.ac.it_college.std.s23014.messageboard.domain.repository.MessageRepository
import org.springframework.stereotype.Service




@Service
class MessageService(private val messageRepository: MessageRepository) {
    fun getListByThread(threadId: Long): List<Messages> {

        return messageRepository.getMessageByThreadId(threadId)
    }


    メッセージ投稿未完成
    fun newPost(threadId: Long, message: String, userId: Long): Messages {
        val now = java.time.LocalDateTime.now()
        val  newThread = Messages(
            threadId = threadId,
            userId = userId,
            message = message,

        )
        }

         メッセージを保存
        return messageRepository.createMessage(newMessage)
    }


    fun updateMessage(id: Long, messages: String, userId: Long): Messages {

        val existingMessage = messageRepository.getMessageById(id) 
            ?: throw IllegalArgumentException("Message not found with id: $id")

        existingMessage.message = messages
        return existingMessage
    }

    fun deleteMessage(id: Long, userId: Long): Messages {

        val existingMessage = messageRepository.getMessageById(id)
            ?: throw IllegalArgumentException("Message not found with id: $id")

        // 論理削除を行う場合
        existingMessage.messageDeleted = true
        return existingMessage
    }
}