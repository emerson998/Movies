package br.com.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movies.service.ClienteService;
import br.com.movies.vo.ClienteFiltroVO;
import br.com.movies.vo.ClienteVisualizaVO;
import br.com.movies.vo.PesquisarClienteVO;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/filtros")
	public ResponseEntity<Page<PesquisarClienteVO>> buscarClientePorFiltro(
			@PageableDefault(size = 20) Pageable pageable, ClienteFiltroVO filtros) {
		return ResponseEntity.ok(clienteService.buscarClientePorFiltro(filtros, pageable));

	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteVisualizaVO> buscarClientePorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarClientePorFiltro(id));

	}
//
//	@PostMapping()
//	public ResponseEntity<ProdutoCdaCadastroVO> salvarCliente(@Valid @RequestBody ProdutoCdaCadastroVO produtoCda) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(produtoCda));
//	}
//
//	@PutMapping()
//	public ResponseEntity<ProdutoCdaAtualizarVO> alterarCliente(@Valid @RequestBody ProdutoCdaAtualizarVO produtoCda) {
//		return ResponseEntity.status(HttpStatus.OK).body(clienteService.alterarCliente(produtoCda));
//	}
}