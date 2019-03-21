package com.hssoft.countriesgraphql.domain.entities

class Continent(val code: String, val name: String, var countries: List<Country> = listOf())