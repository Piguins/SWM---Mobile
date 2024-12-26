package com.han.swm.data.datastore

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.han.swm.common.SWMContextProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private const val PREFERENCES_NAME = "token_datastore"
private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class TokenStorageDataStore(
    private val dataStore: DataStore<Preferences> = SWMContextProvider.getApplicationContext().dataStore
) {
    suspend fun saveAccessToken(token: String) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = token
        }
    }

    suspend fun getAccessToken(): String? {
        val preferences = dataStore.data.first()
        return preferences[ACCESS_TOKEN_KEY]
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }

    val accessTokenFlow: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[ACCESS_TOKEN_KEY]
        }
}

object TokenStorage {
    val dataStore: TokenStorageDataStore by lazy { TokenStorageDataStore() }
}