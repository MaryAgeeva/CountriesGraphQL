package com.hssoft.countriesgraphql.domain.entities

class Country(val code: String, val name: String, val phone: String?,
              val currency: String?, val native: String?,
              val emoji: String?, val languages: List<Language> = listOf())