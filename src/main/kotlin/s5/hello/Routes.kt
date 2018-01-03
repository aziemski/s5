package s5.hello

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class Routes(private val helloHandler: HelloHandler) {

    fun router() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/hello/{name}", helloHandler::hello)
        }
    }
}