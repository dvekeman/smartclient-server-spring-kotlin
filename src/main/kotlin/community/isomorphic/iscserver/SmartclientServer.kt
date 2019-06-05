package community.isomorphic.iscserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan
@SpringBootApplication
class SmartclientServer

fun main(args: Array<String>) {
	runApplication<SmartclientServer>(*args, init = {
        // ... init stuff ... //
    })
}
