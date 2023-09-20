package com.coding.meet.note_app.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.coding.meet.note_app.models.Task
import com.coding.meet.note_app.repository.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application)
    val taskStateFlow get() =  noteRepository.taskStateFlow
    val statusLiveData get() =  noteRepository.statusLiveData
    val sortByLiveData get() =  noteRepository.sortByLiveData

    fun setSortBy(sort:Pair<String,Boolean>){
        noteRepository.setSortBy(sort)
    }

    fun getTaskList(isAsc : Boolean, sortByName:String) {
        noteRepository.getTaskList(isAsc, sortByName)
    }

    fun insertNote(task: Task){
        noteRepository.insertNote(task)
    }

    fun deleteNote(task: Task) {
        noteRepository.deleteNote(task)
    }

    fun deleteNoteUsingId(taskId: String){
        noteRepository.deleteNoteUsingId(taskId)
    }

    fun updateNote(task: Task) {
        noteRepository.updateNote(task)
    }

    fun updateNotePaticularField(taskId: String, title:String, description:String) {
        noteRepository.updateNotePaticularField(taskId, title, description)
    }
    fun searchNoteList(query: String){
        noteRepository.searchNoteList(query)
    }
}