package secretSanta.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import secretSanta.ComponentScanRoot

@SpringBootApplication(scanBasePackageClasses = [ComponentScanRoot::class])
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
