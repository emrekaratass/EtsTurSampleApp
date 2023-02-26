package com.example.etstursampleapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.domain.usecase.GetMovieUseCase
import com.example.etstursampleapp.domain.usecase.MovieParams
import com.example.etstursampleapp.ui.entity.MovieViewItems
import com.example.etstursampleapp.util.extension.ignoreNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieUseCase: GetMovieUseCase
) : ViewModel() {

    val liveData = MutableLiveData<State>()

    fun fetchMovie() {
        val params = MovieParams //No parameter required
        viewModelScope.launch {

            movieUseCase.execute(params).collect {
                when (it) {
                    is Result.Error -> {
                        liveData.value = State.Error(it.exception.message.ignoreNull())
                    }
                    is Result.Success -> it.data.let { result ->
                        liveData.value = State.Success(result)
                    }
                }
            }
        }
    }
}

sealed class State {
    object Loading : State()
    data class Success(val data: MovieViewItems) : State()
    data class Error(val error: String) : State()
}
