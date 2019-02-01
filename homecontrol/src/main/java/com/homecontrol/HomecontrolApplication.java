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
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ReceitaRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HomecontrolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Salário");
		Categoria cat2 = new Categoria(null, "Empréstimos");
		
		Receita p1 = new Receita(null, "Engineering", 2000.00);
		Receita p2 = new Receita(null, "Empréstimo Cláudio", 800.00);
		Receita p3 = new Receita(null, "Empréstimo Dega", 80.00);
		
		cat1.getReceitas().addAll(Arrays.asList(p1));
		cat2.getReceitas().addAll(Arrays.asList(p2, p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}