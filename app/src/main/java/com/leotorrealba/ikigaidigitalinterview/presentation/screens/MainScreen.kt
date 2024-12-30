package com.leotorrealba.ikigaidigitalinterview.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.leotorrealba.ikigaidigitalinterview.data.model.Post
import com.leotorrealba.ikigaidigitalinterview.presentation.viewmodel.MainViewModel
import com.leotorrealba.ikigaidigitalinterview.presentation.viewmodel.UiState


@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    viewModel: MainViewModel = hiltViewModel()
){
    val uiState by viewModel._uiState.collectAsState()
    var post: Post? = viewModel._post

    var showCreateDialog by remember { mutableStateOf(false) }
    var content by remember { mutableStateOf("") }

    when(uiState){
        is UiState.Error -> TODO()
        UiState.Loading -> {
            CircularProgressIndicator(modifier = Modifier.padding(innerPadding))
        }
        is UiState.Success -> {
            post = (uiState as UiState.Success).post
            Text(modifier = Modifier.padding(innerPadding), text = post.content)
        }
    }
}
