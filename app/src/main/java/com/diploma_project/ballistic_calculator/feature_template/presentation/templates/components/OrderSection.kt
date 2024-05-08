package com.diploma_project.ballistic_calculator.feature_template.presentation.templates.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diploma_project.ballistic_calculator.feature_template.domain.util.OrderType
import com.diploma_project.ballistic_calculator.feature_template.domain.util.TemplateOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    templateOrder: TemplateOrder = TemplateOrder.Date(OrderType.Descending),
    onOrderChange: (TemplateOrder) -> Unit
){
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Название", selected = templateOrder is TemplateOrder.Title, onSelect = { onOrderChange(TemplateOrder.Title(templateOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Дата", selected = templateOrder is TemplateOrder.Date, onSelect = { onOrderChange(TemplateOrder.Date(templateOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Цвет", selected = templateOrder is TemplateOrder.Color, onSelect = { onOrderChange(TemplateOrder.Color(templateOrder.orderType)) })
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}