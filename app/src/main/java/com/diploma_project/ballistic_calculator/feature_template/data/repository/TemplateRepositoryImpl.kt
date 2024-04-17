package com.diploma_project.ballistic_calculator.feature_template.data.repository

import com.diploma_project.ballistic_calculator.feature_template.data.data_source.TemplateDao
import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.repository.TemplateRepository
import kotlinx.coroutines.flow.Flow

class TemplateRepositoryImpl(
    private val dao: TemplateDao
) : TemplateRepository {
    override fun getTemplates(): Flow<List<Template>> {
        return dao.getTemplates()
    }

    override suspend fun getTemplateById(id: Int): Template? {
        return dao.getTemplateById(id)
    }

    override suspend fun insertTemplate(template: Template) {
        dao.insertTemplate(template)
    }

    override suspend fun deleteTemplate(template: Template) {
        dao.deleteTemplate(template)
    }
}