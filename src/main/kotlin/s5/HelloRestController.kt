package s5

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HelloRestController {

    @GetMapping("/hello/{name}")
    fun hello(@PathVariable name: String): Mono<Hello> {
        return Mono.fromCallable { Hello("Hello $name!") }
    }
}