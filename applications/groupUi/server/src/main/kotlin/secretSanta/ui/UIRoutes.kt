package secretSanta.ui

import org.springframework.context.ResourceLoaderAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader
import org.springframework.web.reactive.function.server.*

@Configuration
class UIRoutes : ResourceLoaderAware {
    private lateinit var resourceLoader: ResourceLoader

    @Bean
    fun resourceRoute(): RouterFunction<ServerResponse> {
        val rootContext = "uiHere"

        return RouterFunctions.route(
            RequestPredicates.GET("/$rootContext/**")
            , HandlerFunction<ServerResponse> { request ->

                val uri = request.uri()
                val path = uri.path
                val isResource = path.contains("\\.")

                println("PATH: $path")
                println("URI: $uri isJs: $isResource")
                println("HEADERS : ${request.headers()}")

                var resource = resourceLoader.getResource("classpath:/public/ui/index.html")

                if (isResource) {
                    val resourcePath = path.split(rootContext)[1]
                    resource = resourceLoader.getResource("classpath:/public/ui/$resourcePath")
                }

                ServerResponse.ok()
//                    .contentType(MediaType.TEXT_HTML)
                    .bodyValue(resource)
            }
        )
    }

    override fun setResourceLoader(resourceLoader: ResourceLoader) {
        this.resourceLoader = resourceLoader
    }
}