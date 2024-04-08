//package com.bypriyan.togocartpro.repository
//
//import android.content.Context
//import com.google.firebase.FirebaseException
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.PhoneAuthCredential
//import com.google.firebase.auth.PhoneAuthOptions
//import com.google.firebase.auth.PhoneAuthProvider
//import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
//import java.util.concurrent.TimeUnit
//import javax.inject.Inject
//
//class PhoneAuthRepository(val context: Context){
//
//    suspend fun loginWithPhoneNumber(phoneNumber:String):Boolean{
//
//        val auth:FirebaseAuth = FirebaseAuth.getInstance()
//
//         var mCallbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks
//
//         mCallbacks = object : OnVerificationStateChangedCallbacks(){
//             override fun onVerificationCompleted(p0: PhoneAuthCredential) {
//                 TODO("Not yet implemented")
//             }
//
//             override fun onVerificationFailed(p0: FirebaseException) {
//                 TODO("Not yet implemented")
//             }
//
//             override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
//                 super.onCodeSent(p0, p1)
//             }
//
//         }
//
//
//        val options = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phoneNumber) // Phone number to verify
//            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//            .setActivity(context) // Activity (for callback binding)
//            .setCallbacks(mCallbacks) // OnVerificationStateChangedCallbacks
//            .build()
//        PhoneAuthProvider.verifyPhoneNumber(options)
//    }
//
//}