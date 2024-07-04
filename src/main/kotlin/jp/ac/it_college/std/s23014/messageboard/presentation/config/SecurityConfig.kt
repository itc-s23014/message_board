package jp.ac.it_college.std.s23014.messageboard.presentation.config

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    @Order(1)
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeRequests {
                authorize(anyRequest, permitAll)
            }
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = Argon2PasswordEncoder(
            16, 32, 1, 19 * 1024, 2
        )


    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration().apply {
            allowedMethods = listOf("GET", "POST", "PATCH")
            allowedHeaders = listOf("*")
            allowedOrigins = listOf("http://localhost:3000")
            allowCredentials = true
        }
        val source = UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", config)
        }
        return source
    }

    @Bean
    fun json(): Json {

        val module = SerializersModule {
            contextual(LocalDateTime.serializer())
        }


        return Json {
            serializersModule = module
        }
    }
}
