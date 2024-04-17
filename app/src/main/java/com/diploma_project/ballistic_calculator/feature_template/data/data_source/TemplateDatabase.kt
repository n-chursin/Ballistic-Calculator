package com.diploma_project.ballistic_calculator.feature_template.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template

@Database(
    entities = [Template::class],
    version = 1
)
abstract class TemplateDatabase: RoomDatabase() {

    abstract val templateDao: TemplateDao
}