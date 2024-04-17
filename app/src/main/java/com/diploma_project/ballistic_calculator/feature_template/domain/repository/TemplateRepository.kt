package com.diploma_project.ballistic_calculator.feature_template.domain.repository

import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {

    fun getTemplates(): Flow<List<Template>>
    suspend fun getTemplateById(id:Int): Template?

    suspend fun insertTemplate(template: Template)

    suspend fun deleteTemplate(template: Template)
}