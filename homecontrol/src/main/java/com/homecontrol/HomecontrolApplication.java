package com.homecontrol;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.homecontrol.domain.Categoria;
import com.homecontrol.domain.Receita;
import com.homecontrol.repositories.CategoriaRepository;
import com.homecontrol.repositories.ReceitaRepository;

@SpringBootApplication
public class HomecontrolApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ReceitaRepository receitaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HomecontrolApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Salário");
		Categoria cat2 = new Categoria(null, "Empréstimos");
		Categoria cat3 = new Categoria(null, "Outros");

		Receita r1 = new Receita(null, "Salário", 6600.0);
		Receita r2 = new Receita(null, "Empréstimo Cláudio", 600.0);
		Receita r3 = new Receita(null, "Bônus", 1100.0);

		cat1.getReceitas().addAll(Arrays.asList(r1, r3));
		cat2.getReceitas().addAll(Arrays.asList(r2));

		r1.getCategorias().addAll(Arrays.asList(cat1));
		r2.getCategorias().addAll(Arrays.asList(cat2));
		r3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		receitaRepository.saveAll(Arrays.asList(r1, r2, r3));
		
	}
	

}
