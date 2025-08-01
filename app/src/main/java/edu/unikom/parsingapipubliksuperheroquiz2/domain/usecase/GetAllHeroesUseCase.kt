package edu.unikom.parsingapipubliksuperheroquiz2.domain.usecase

import edu.unikom.parsingapipubliksuperheroquiz2.data.model.SuperheroResponse
import edu.unikom.parsingapipubliksuperheroquiz2.domain.repository.SuperheroRepository

class GetAllHeroesUseCase(private val repository: SuperheroRepository) {
    fun execute(callback: (List<SuperheroResponse>?, Throwable?) -> Unit) {
        repository.getAllHeroes(callback)
    }
}