package puj.javeriana.sistemanotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SistemanotasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemanotasApplication.class, args);
	}

	@Bean
	public ReactiveWebServerFactory reactiveWebServerFactory() {
		return new NettyReactiveWebServerFactory();
	}
}
