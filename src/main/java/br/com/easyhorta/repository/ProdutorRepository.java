package br.com.easyhorta.repository;

import br.com.easyhorta.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutorRepository extends JpaRepository<Produtor, Integer> {

}