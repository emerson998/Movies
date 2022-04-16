package br.com.movies.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "locadora")
public class LocadoraEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome não pode ser nulo ou vazio")
	private String nome;

	@NotBlank(message = "Endereco não pode ser nulo ou vazio")
	private String endereco;

	@NotBlank(message = "Quantidade de dvds não pode ser nulo ou vazio")
	private Long quantidadeDeDvds;

	@NotBlank(message = "Cpf não pode ser nulo ou vazio")
	@Size(max = 14, message = "Cpf inválido")
	private String cnpj;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();;

	@OneToMany
	private List<ClienteEntity> cliente;

	@ManyToMany
	private List<FornecedorEntity> fornecedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getQuantidadeDeDvds() {
		return quantidadeDeDvds;
	}

	public void setQuantidadeDeDvds(Long quantidadeDeDvds) {
		this.quantidadeDeDvds = quantidadeDeDvds;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<FornecedorEntity> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<FornecedorEntity> fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "LocadoraEntity [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", quantidadeDeDvds="
				+ quantidadeDeDvds + ", cnpj=" + cnpj + ", data=" + data + ", fornecedor=" + fornecedor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocadoraEntity other = (LocadoraEntity) obj;
		return Objects.equals(id, other.id);
	}

}
