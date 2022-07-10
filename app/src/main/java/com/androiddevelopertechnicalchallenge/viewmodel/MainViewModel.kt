package com.androiddevelopertechnicalchallenge.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.androiddevelopertechnicalchallenge.data.entities.ProductEntity
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import com.androiddevelopertechnicalchallenge.repositories.Repository
import com.androiddevelopertechnicalchallenge.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application){

    /** ROOM DATABASE */
    private fun insertProducts(productEntity: ProductEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertProducts(productEntity)
        }

    /** RETROFIT */
    var productResponse: MutableLiveData<NetworkResult<ProductDTO>> = MutableLiveData()

    fun getProducts(queries: Map<String, String>) = viewModelScope.launch {
        getProductsSafeCall(queries)
    }

    private suspend fun getProductsSafeCall(queries: Map<String, String>) {
        productResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getProductList(queries)
                productResponse.value = handleProductResponse(response)

                productResponse.value!!.data

            } catch (e: Exception) {
                productResponse.value = NetworkResult.Error("Recipes not found.")
            }
        } else {
            productResponse.value = NetworkResult.Error("No Internet Connection.")
        }
    }

    private fun handleProductResponse(response: Response<ProductDTO>): NetworkResult<ProductDTO> {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("Timeout")
            }
            response.body()!!.products.isNullOrEmpty() -> {
                return NetworkResult.Error("Product not found.")
            }
            response.isSuccessful -> {
                val productResponse = response.body()
                return NetworkResult.Success(productResponse!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}