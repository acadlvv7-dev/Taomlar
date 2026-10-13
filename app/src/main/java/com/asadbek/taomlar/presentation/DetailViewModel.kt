package com.asadbek.taomlar.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadbek.taomlar.domain.model.TaomDetail
import com.asadbek.taomlar.domain.usecase.GetTaomDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getTaomDetail: GetTaomDetailUseCase) : ViewModel() {
    private val _taomDetail = MutableLiveData<TaomDetail>()
    val taomDetail: LiveData<TaomDetail> = _taomDetail
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error



    fun loadDetail(id: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                _taomDetail.value = getTaomDetail(id)
            } catch (e: Exception) {
                _error.value = "Malumot yuklab bomadi"
            } finally {
                _loading.value = false
            }
        }
    }
}