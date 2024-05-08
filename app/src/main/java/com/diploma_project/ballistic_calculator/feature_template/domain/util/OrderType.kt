package com.diploma_project.ballistic_calculator.feature_template.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}