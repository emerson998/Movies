package br.com.movies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.movies.entity.ClienteEntity;
import br.com.movies.exception.NaoEncontradoException;
import br.com.movies.exception.ParametroInvalidoException;
import br.com.movies.repository.ClienteRepository;
import br.com.movies.specification.ClienteSpecification;
import br.com.movies.vo.ClienteFiltroVO;
import br.com.movies.vo.ClienteVisualizaVO;
import br.com.movies.vo.PesquisarClienteVO;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

	public Page<PesquisarClienteVO> buscarClientePorFiltro(ClienteFiltroVO filtros, Pageable page) {

		logger.info("PESQUISA COM FILTROS");

		if (filtros.isFiltrosInexistentes()) {
			logger.error("PESQUISA INVÁLIDA: FILTROS INEXISTENTES");
			throw new ParametroInvalidoException("Filtros inexistentes");
		}

		Page<ClienteEntity> clienteFiltrado = clienteRepository.findAll(new ClienteSpecification(filtros), page);

		logger.info("FINALIZANDO PESQUISA COM FILTROS");
		return clienteFiltrado.map(this::converterResultadoParaVO);

	}

	public ClienteVisualizaVO buscarClientePorFiltro(Long id) {

		logger.info("PESQUISAR CLIENTES POR ID{}", id);
		ClienteEntity clienteEntity = clienteRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Nenhum cliente encontrado com id: " + id));

		return converterParaVisualizaVO(clienteEntity, new ClienteVisualizaVO());

	}

	private ClienteVisualizaVO converterParaVisualizaVO(ClienteEntity entity, ClienteVisualizaVO vo) {
		vo.setId(entity.getId());
		vo.setCpf(entity.getCpf());
		vo.setNome(entity.getNome());
		return vo;
	}

	private PesquisarClienteVO converterResultadoParaVO(ClienteEntity entity) {
		PesquisarClienteVO vo = new PesquisarClienteVO();
		vo.setNome(entity.getNome());
		vo.setCpf(entity.getCpf());
		return vo;

	}

}
