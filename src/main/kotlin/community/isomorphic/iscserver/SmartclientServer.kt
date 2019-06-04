package community.isomorphic.iscserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartclientServer

fun main(args: Array<String>) {
	runApplication<SmartclientServer>(*args)
}
