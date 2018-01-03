package s5.hello


import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

class HelloHandler {

    fun hello(req: ServerRequest): Mono<ServerResponse> {
        val hello = Mono.justOrEmpty(req.pathVariable("name"))
                .map { Hello("Hello $it!") }
        return ServerResponse.ok()
                .body(hello)

    }
}