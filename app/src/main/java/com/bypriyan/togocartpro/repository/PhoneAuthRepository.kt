package com.bypriyan.togocartpro.repository

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PhoneAuthRepository @Inject constructor(val auth:FirebaseAuth = FirebaseAuth.getInstance()) {

    suspend fun loginWithPhoneNumber(phoneNumber:String):Boolean{
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(null) // Activity (for callback binding)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                }

                override fun onVerificationFailed(e: FirebaseException) {

                }

                override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken, ) {

                }
            }) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

}