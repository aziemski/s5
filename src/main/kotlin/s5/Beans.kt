package s5

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import s5.hello.HelloHandler
import s5.hello.Routes

fun beans() = beans {
    bean<HelloHandler>()
    bean {
        Routes(ref()).router()
    }
}

class BeansInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(applicationContext: GenericApplicationContext) =
            beans().initialize(applicationContext)
}