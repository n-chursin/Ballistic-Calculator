package com.diploma_project.ballistic_calculator.feature_template.presentation.templates

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diploma_project.ballistic_calculator.feature_template.domain.model.Template
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.DeleteTemplate
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.GetTemplates
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.TemplateUseCases
import com.diploma_project.ballistic_calculator.feature_template.domain.util.OrderType
import com.diploma_project.ballistic_calculator.feature_template.domain.util.TemplateOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.xml.transform.Templates

@HiltViewModel
class TemplatesViewModel @Inject constructor(
    private val templateUseCases: TemplateUseCases
) : ViewModel(){

    private val _state = mutableStateOf(TemplatesState())
    val state: State<TemplatesState> = _state

    private var recentlyDeletedTemplate: Template? = null

    private var getTemplatesJob: Job? = null

    init {
        getTemplates(TemplateOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: TemplatesEvent){
        when(event) {
            is TemplatesEvent.Order -> {
                if(state.value.templateOrder::class == event.templateOrder::class && state.value.templateOrder.orderType == event.templateOrder.orderType){
                    return
                }
                getTemplates(event.templateOrder)
            }
            is TemplatesEvent.DeleteTemplate -> {
                viewModelScope.launch {
                    templateUseCases.deleteTemplate(event.template)
                    recentlyDeletedTemplate = event.template
                }
            }
            is TemplatesEvent.RestoreTemplate -> {
                viewModelScope.launch {
                    templateUseCases.addTemplate(recentlyDeletedTemplate ?: return@launch)
                    recentlyDeletedTemplate = null
                }
            }
            is TemplatesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }
    private fun getTemplates(templateOrder: TemplateOrder){
        getTemplatesJob?.cancel()
        getTemplatesJob = templateUseCases.getTemplates(templateOrder).onEach {templates -> _state.value = state.value.copy(templates = templates, templateOrder = templateOrder)}.launchIn(viewModelScope)
    }
}