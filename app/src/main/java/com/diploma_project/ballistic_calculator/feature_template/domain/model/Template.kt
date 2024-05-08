package com.diploma_project.ballistic_calculator.feature_template.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diploma_project.ballistic_calculator.ui.theme.BabyBlue
import com.diploma_project.ballistic_calculator.ui.theme.LightGreen
import com.diploma_project.ballistic_calculator.ui.theme.RedOrange
import com.diploma_project.ballistic_calculator.ui.theme.RedPink
import com.diploma_project.ballistic_calculator.ui.theme.Violet

@Entity
data class Template(
    val title: String,
    val comment: String,
    val color: Int,
    val timestamp: Long,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val templateColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidTemplateException(message: String): Exception(message)
