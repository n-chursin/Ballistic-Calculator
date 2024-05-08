package com.diploma_project.ballistic_calculator.feature_template.presentation.templates

import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.util.OrderType
import com.diploma_project.ballistic_calculator.feature_template.domain.util.TemplateOrder

data class TemplatesState(
    val templates: List<Template> = emptyList(),
    val templateOrder: TemplateOrder = TemplateOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)