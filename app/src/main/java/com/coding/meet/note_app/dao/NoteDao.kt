package com.coding.meet.note_app.dao

import androidx.room.*
import com.coding.meet.note_app.models.Task
import kotlinx.coroutines.flow.Flow

@Dao //data access object for rmm db
interface NoteDao {


    @Query(
        """SELECT * FROM Task ORDER BY
        CASE WHEN :isAsc = 1 THEN taskTitle END ASC, 
        CASE WHEN :isAsc = 0 THEN taskTitle END DESC"""
    )
    fun getNoteListSortByTaskTitle(isAsc: Boolean) : Flow<List<Task>>

    @Query(
        """SELECT * FROM Task ORDER BY
        CASE WHEN :isAsc = 1 THEN date END ASC, 
        CASE WHEN :isAsc = 0 THEN date END DESC"""
    )
    fun getNoteListSortByTaskDate(isAsc: Boolean) : Flow<List<Task>>

    //method to insert data into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(task: Task): Long


    // First way
    @Delete
    suspend fun deleteNote(task: Task) : Int


    // Second Way
    @Query("DELETE FROM Task WHERE taskId == :taskId")
    suspend fun deleteTaskUsingId(taskId: String) : Int


    @Update
    suspend fun updateNote(task: Task): Int


    @Query("UPDATE Task SET taskTitle=:title, description = :description WHERE taskId = :taskId")
    suspend fun updateNotePaticularField(taskId:String, title:String, description:String): Int


    @Query("SELECT * FROM Task WHERE taskTitle LIKE :query ORDER BY date DESC")
    fun searchNoteList(query: String) : Flow<List<Task>>
}