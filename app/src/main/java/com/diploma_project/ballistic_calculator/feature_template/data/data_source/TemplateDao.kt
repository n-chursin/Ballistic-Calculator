package com.diploma_project.ballistic_calculator.feature_template.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Query("SELECT * FROM template")
    fun getTemplates(): Flow<List<Template>>

    @Query("SELECT * FROM template WHERE id = :id")
    suspend fun getTemplateById(id: Int): Template?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTemplate(template: Template)

    @Delete
    suspend fun deleteTemplate(template: Template)
}
