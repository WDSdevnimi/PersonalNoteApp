package com.coding.meet.note_app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.coding.meet.note_app.converters.TypeConverter
import com.coding.meet.note_app.dao.NoteDao
import com.coding.meet.note_app.models.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao : NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        // creating a database instance
        fun getInstance(context: Context): NoteDatabase {
            // ensure that only one thread can execute it at a time
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "task_db"
                ).build().also {
                    INSTANCE = it
                }
            }

        }
    }

}