package com.blueray.bookreader.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {

    val loadingState = MutableStateFlow(LoadingState.IDLE)

    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading


    fun createUserWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {

    }


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // take user to home page
                            home()
                            Log.d("FB", "Sign in with email and password YAAAY ! ${task.result}\" ")
                        } else {
                            Log.d("FB", "Sign in with email and password  ${task.result}")

                        }
                    }
            } catch (ex: Exception) {
                Log.d("FB", "Sign in with password  ${ex.message}")
            }
        }

}