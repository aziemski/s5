package s5

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.test.test


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTests(@LocalServerPort port: Int) {
    private val webClient:WebClient = WebClient.create("http://localhost:$port")

    @Test
    fun `should return Hello World! message`() {
        webClient.get().uri("/hello/World").retrieve().bodyToFlux<Hello>()
                .test()
                .expectNext(Hello("Hello World!"))
                .verifyComplete()
    }
}