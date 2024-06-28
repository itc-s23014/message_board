package jp.ac.it_college.std.s23014.messageboard.domain.repository

import jp.ac.it_college.std.s23014.messageboard.domain.model.Threads

interface ThreadRepository {
        fun createThread(thread: Threads): Threads
        fun getThreadById(id: Long): Threads?
        fun getAllThreads(): List<Threads>
        fun updateThread(thread: Threads): Threads
        fun deleteThread(id: Long)
    }