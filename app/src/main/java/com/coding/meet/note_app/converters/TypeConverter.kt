package com.coding.meet.note_app.converters

import androidx.room.TypeConverter
import java.util.Date

class TypeConverter {

    @TypeConverter
    // converts a Long (timestamp) to a Date object
    fun fromTimestamp(value:Long): Date {
        return Date(value)
    }

    @TypeConverter
    //converts a Date object to a Long (timestamp) value.
    fun dateToTimestamp(date:Date): Long {
        return date.time
    }
}