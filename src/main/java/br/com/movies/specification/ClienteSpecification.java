package br.com.movies.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.movies.entity.ClienteEntity;
import br.com.movies.vo.ClienteFiltroVO;

public class ClienteSpecification implements Specification<ClienteEntity> {

	private transient ClienteFiltroVO filtros;

	public ClienteSpecification(ClienteFiltroVO filtros) {
		this.filtros = filtros;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Predicate toPredicate(Root<ClienteEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> condicoes = new ArrayList<>();

		if (filtros.incluiNome()) {
			Predicate nome = criteriaBuilder.like(root.get("nome"), filtros.getNome() + "%");
			condicoes.add(nome);
		}

		if (filtros.incluiCpf()) {
			Predicate cpf = criteriaBuilder.equal(root.get("cpf"), filtros.getCpf());
			condicoes.add(cpf);
		}

		return criteriaBuilder.and(condicoes.toArray(new Predicate[0]));

	}

}
