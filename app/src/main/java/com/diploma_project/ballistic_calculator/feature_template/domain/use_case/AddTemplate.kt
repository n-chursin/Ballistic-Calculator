package com.diploma_project.ballistic_calculator.feature_template.domain.use_case

import com.diploma_project.ballistic_calculator.feature_template.domain.model.InvalidTemplateException
import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.repository.TemplateRepository

class AddTemplate(
    private val repository: TemplateRepository
){
    @Throws(InvalidTemplateException::class)
    suspend operator fun invoke(template: Template){
        if(template.title.isBlank()){
            throw InvalidTemplateException("Название шаблона не может быть пустым.")
        }
        repository.insertTemplate(template)
    }
}