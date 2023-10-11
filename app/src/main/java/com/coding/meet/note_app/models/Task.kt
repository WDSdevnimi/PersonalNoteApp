package com.coding.meet.note_app.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity()
//class that primarily holds data
data class Task(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "taskId")
    val id: String,
    @ColumnInfo(name = "taskTitle")
    val title: String,
    val description: String,
    val date: Date,
)
