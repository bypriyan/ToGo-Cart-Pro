package com.bypriyan.togocartpro.MVVMArchi

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val auth: FirebaseAuth)  :ViewModel() {



}