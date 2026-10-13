package com.asadbek.taomlar.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadbek.taomlar.domain.model.Taom
import com.asadbek.taomlar.domain.usecase.GetTaomByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaomViewModel @Inject constructor(
    private val getTaomByCategory: GetTaomByCategoryUseCase
) : ViewModel() {

    private val _taomlar = MutableLiveData<List<Taom>>()
    val taomlar: LiveData<List<Taom>> = _taomlar

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private var fullList: List<Taom> = emptyList()

    fun loadTaomlar(category: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                fullList = getTaomByCategory(category)
                _taomlar.value = fullList
            } catch (e: Exception) {
                _error.value = "Internetiz yoq"
            } finally {
                _loading.value = false
            }
        }
    }

    fun filterTaomlar(query: String) {
        if (query.isBlank()) {
            _taomlar.value = fullList
        } else {
            _taomlar.value = fullList.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }
}