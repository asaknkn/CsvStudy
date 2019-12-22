package com.example.CsvStudy

import com.fasterxml.jackson.databind.MappingIterator
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.springframework.core.io.ClassPathResource

class CsvStudy {

    companion object {
        private const val RESOURCE_PATH = "sample.csv"
    }

    fun csvRead(): List<Map<String, String>>{
        val result = mutableMapOf<String, String>()
        val bootstrapSchema = CsvSchema.emptySchema().withHeader()
        val mapper = CsvMapper()
        val file = ClassPathResource(RESOURCE_PATH).file
        val iter: MappingIterator<Map<String, String>> =
                mapper.readerFor(Map::class.java).with(bootstrapSchema).readValues(file)
        return iter.readAll()
    }
}