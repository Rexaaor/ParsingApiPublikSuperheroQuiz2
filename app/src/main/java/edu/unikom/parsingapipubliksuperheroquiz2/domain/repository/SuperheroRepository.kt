package edu.unikom.parsingapipubliksuperheroquiz2.domain.repository

import edu.unikom.parsingapipubliksuperheroquiz2.data.model.SuperheroResponse

interface SuperheroRepository {
    fun getAllHeroes(callback: (List<SuperheroResponse>?, Throwable?) -> Unit)
}