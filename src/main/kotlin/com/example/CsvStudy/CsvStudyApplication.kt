package com.example.CsvStudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CsvStudyApplication

fun main(args: Array<String>) {
	runApplication<CsvStudyApplication>(*args)

	val csvStudy = CsvStudy()
	val list = csvStudy.csvRead()
	println("---Result---")
	list.forEach {
		println("id: " + it["id"])
		println("name: " + it["name"])
	}
}
