package com.archit.moviequiz.util

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserManager(context: Context) {
    private val dataStore = context.createDataStore(name = "user_prefs")

    companion object {
        val USER_SCORE_KEY = preferencesKey<Int>("USER_SCORE")
    }

    suspend fun saveToDataStore(score: Int){
        dataStore.edit {
            it[USER_SCORE_KEY] = score
        }
    }

    val readFromDataStore: Flow<Int> = dataStore.data
        .catch {exception ->
            if(exception is IOException){
                Log.d("DataStore",exception.message.toString())
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }
        .map {
        it[USER_SCORE_KEY]?: -1
    }
}