package com.leotorrealba.ikigaidigitalinterview.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leotorrealba.ikigaidigitalinterview.data.model.CreatePostRequest
import com.leotorrealba.ikigaidigitalinterview.data.model.Post
import com.leotorrealba.ikigaidigitalinterview.domain.usecase.FetchDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchDataUseCase: FetchDataUseCase
) : ViewModel() {
    val _uiState = MutableStateFlow<UiState> (UiState.Loading)
    val _post: Post? = null

    init {
        fetchPost()
    }

    private fun fetchPost() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            fetchDataUseCase.getPosts()
                .onSuccess {
                    _uiState.value = UiState.Success(it)
                }
                .onFailure {
                    _uiState.value = UiState.Error(it.message ?: "Unknown error")
                }
        }
    }

    fun createPost(post: CreatePostRequest){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            fetchDataUseCase.createPost(post)
                .onSuccess {
                    _uiState.value = UiState.Success(it)
                }
                .onFailure {
                    _uiState.value = UiState.Error(it.message ?: "Unknown error")
                }
        }
    }
}

sealed class UiState(){
    object Loading : UiState()
    data class Success(val post: Post) : UiState()
    data class Error(val message: String) : UiState()
}