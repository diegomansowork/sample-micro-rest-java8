package com.diego.microSampe;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

	private static final String template = "Hola, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/saludo")
	public Saludo greeting(@RequestParam(value = "nombre", defaultValue = "Istio") String name) {
		return new Saludo(counter.incrementAndGet(), String.format(template, name));
	}
}