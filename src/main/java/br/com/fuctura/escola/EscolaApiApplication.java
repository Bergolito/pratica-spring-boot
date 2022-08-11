package br.com.fuctura.escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class EscolaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApiApplication.class, args);
	}

	@ResponseBody
	@RequestMapping("/")
	public String index() {
		return "Teste OK!";
	}
}
