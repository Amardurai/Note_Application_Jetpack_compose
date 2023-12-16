package com.example.myapplication.ui.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.ui.data.repo.RepositoryImp
import com.example.myapplication.ui.data.room.Dao
import com.example.myapplication.ui.data.room.Database
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
    fun provideNoteDataBase(app: Application): Database {
        return Room.databaseBuilder(app, Database::class.java, Database.name).build()
    }

    @Provides
    @Singleton
    fun provideRepository(dao: Database): RepositoryImp {
        return RepositoryImp(dao)
    }


}