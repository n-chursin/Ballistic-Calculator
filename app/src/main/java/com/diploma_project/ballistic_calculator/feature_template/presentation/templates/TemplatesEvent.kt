package com.diploma_project.ballistic_calculator.feature_template.presentation.templates

import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.util.TemplateOrder

sealed class TemplatesEvent {
    data class Order(val templateOrder: TemplateOrder) : TemplatesEvent()
    data class DeleteTemplate(val template: Template) : TemplatesEvent()
    object RestoreTemplate: TemplatesEvent()
    object ToggleOrderSection: TemplatesEvent()
}