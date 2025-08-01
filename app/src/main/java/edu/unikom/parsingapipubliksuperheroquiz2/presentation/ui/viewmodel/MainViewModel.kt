package edu.unikom.parsingapipubliksuperheroquiz2.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.unikom.parsingapipubliksuperheroquiz2.data.model.SuperheroResponse
import edu.unikom.parsingapipubliksuperheroquiz2.data.repository.SuperheroRepositoryImpl
import edu.unikom.parsingapipubliksuperheroquiz2.domain.usecase.GetAllHeroesUseCase

class MainViewModel : ViewModel() {
    private val repository = SuperheroRepositoryImpl()
    private val useCase = GetAllHeroesUseCase(repository)

    private val _heroes = MutableLiveData<List<SuperheroResponse>>()
    val heroes: LiveData<List<SuperheroResponse>> get() = _heroes

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun loadHeroes() {
        useCase.execute { result, throwable ->
            if (result != null) {
                _heroes.postValue(result)
            } else {
                _error.postValue(throwable?.message ?: "Unknown Error")
            }
        }
    }
}