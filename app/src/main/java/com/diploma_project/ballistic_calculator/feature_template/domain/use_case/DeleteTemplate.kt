package com.diploma_project.ballistic_calculator.feature_template.domain.use_case

import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.repository.TemplateRepository

class DeleteTemplate(
    private val repository: TemplateRepository
) {
    suspend operator fun invoke(template: Template){
        repository.deleteTemplate(template)
    }
}