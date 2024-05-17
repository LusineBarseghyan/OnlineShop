package com.example.myapplication.module.net.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.module.data.CartsDto
import com.example.myapplication.module.net.repository.ApiResultCallback
import com.example.myapplication.module.net.repository.Repository
import com.example.myapplication.module.net.repository.RepositoryImplementation
import com.example.myapplication.module.net.repository.getApi
import kotlinx.coroutines.launch

class CartViewModel:ViewModel() {


    private val repository:Repository=RepositoryImplementation(getApi())

    private val _cartLiveData:MutableLiveData<CartsDto?> = MutableLiveData()
    val cartLiveData: LiveData<CartsDto?>
        get()=_cartLiveData

    private val _cartErrorLiveData:MutableLiveData<String> = MutableLiveData()
    val cartErrorLiveData: LiveData<String>
        get()=_cartErrorLiveData

    fun getCarts(isShowLoader:Boolean=true){
                viewModelScope.launch {
                    repository.getCarts(object : ApiResultCallback<CartsDto?> {
                        override fun onSuccess(response: CartsDto?) {
                            _cartLiveData.value = response
                        }

                        override fun onError(): Boolean {
                            _cartErrorLiveData.value="Error data"

                            return false
                        }
                    }, isShowLoader)
                }
    }
    }
