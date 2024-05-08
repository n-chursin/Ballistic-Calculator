package com.diploma_project.ballistic_calculator.feature_template.domain.use_case

import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.repository.TemplateRepository
import com.diploma_project.ballistic_calculator.feature_template.domain.util.OrderType
import com.diploma_project.ballistic_calculator.feature_template.domain.util.TemplateOrder
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

class GetTemplates(
    private val repository: TemplateRepository
) {

    operator fun invoke(
        templateOrder: TemplateOrder = TemplateOrder.Date(OrderType.Descending)
    ): Flow<List<Template>> {
        return repository.getTemplates().map{templates ->
            when(templateOrder.orderType) {
                is OrderType.Ascending -> {
                    when(templateOrder) {
                        is TemplateOrder.Title -> templates.sortedBy {it.title.lowercase()}
                        is TemplateOrder.Date -> templates.sortedBy {it.timestamp}
                        is TemplateOrder.Color -> templates.sortedBy {it.color}
                    }
                }
                is OrderType.Descending -> {
                    when(templateOrder) {
                        is TemplateOrder.Title -> templates.sortedByDescending {it.title.lowercase()}
                        is TemplateOrder.Date -> templates.sortedByDescending {it.timestamp}
                        is TemplateOrder.Color -> templates.sortedByDescending {it.color}
                    }
                }
            }
        }
    }
}