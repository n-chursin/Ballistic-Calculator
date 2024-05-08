package com.diploma_project.ballistic_calculator.feature_template.domain.util

sealed class TemplateOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): TemplateOrder(orderType)
    class Date(orderType: OrderType): TemplateOrder(orderType)
    class Color(orderType: OrderType): TemplateOrder(orderType)
}