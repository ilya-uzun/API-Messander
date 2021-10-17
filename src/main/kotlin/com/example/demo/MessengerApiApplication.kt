package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class MessengerApiApplication


fun main(args: Array<String>) {
	SpringApplication.run(MessengerApiApplication::class.java, *args)
}
