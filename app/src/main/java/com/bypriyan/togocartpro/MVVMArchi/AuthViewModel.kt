//package com.bypriyan.togocartpro.MVVMArchi
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.bypriyan.togocartpro.repository.PhoneAuthRepository
//import com.google.firebase.auth.FirebaseAuth
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//class AuthViewModel @Inject constructor(private val phoneAuthRepository:PhoneAuthRepository)  :ViewModel() {
//
//
//    private val _registrationStatus = MutableLiveData<Boolean>()
//    val registrationStatus: LiveData<Boolean>
//        get() = _registrationStatus
//
//
//    fun registerUser(phoneNumber: String) {
//        viewModelScope.launch {
//            _registrationStatus.value = phoneAuthRepository.loginWithPhoneNumber(phoneNumber)
//        }
//    }
//
//}