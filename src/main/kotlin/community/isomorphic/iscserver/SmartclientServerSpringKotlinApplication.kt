package community.isomorphic.iscserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartclientServerSpringKotlinApplication

fun main(args: Array<String>) {
	runApplication<SmartclientServerSpringKotlinApplication>(*args)
}
