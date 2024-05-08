package com.diploma_project.ballistic_calculator.di

import android.app.Application
import androidx.room.Room
import com.diploma_project.ballistic_calculator.feature_template.data.data_source.TemplateDatabase
import com.diploma_project.ballistic_calculator.feature_template.data.repository.TemplateRepositoryImpl
import com.diploma_project.ballistic_calculator.feature_template.domain.repository.TemplateRepository
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.AddTemplate
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.DeleteTemplate
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.GetTemplates
import com.diploma_project.ballistic_calculator.feature_template.domain.use_case.TemplateUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTemplateDatabase(app: Application) : TemplateDatabase {
        return Room.databaseBuilder(
            app,
            TemplateDatabase::class.java,
            TemplateDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTemplateRepository(db:TemplateDatabase): TemplateRepository {
        return TemplateRepositoryImpl(db.templateDao)
    }

    @Provides
    @Singleton
    fun provideTemplateUseCases(repository: TemplateRepository):TemplateUseCases {
        return TemplateUseCases(
            getTemplates = GetTemplates(repository),
            deleteTemplate = DeleteTemplate(repository),
            addTemplate = AddTemplate(repository)
        )
    }
}