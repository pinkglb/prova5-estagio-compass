package br.com.compasso.pedidos.controller.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ManyToOne;

import br.com.compasso.pedidos.modelo.Item;
import br.com.compasso.pedidos.modelo.Oferta;

public class ItemDto {
	
	private Long id;
	private String nome;
	private LocalDateTime dataCriacao;
	private Date dataValidade;
	private float valor;
	private String descricao;
	private List<Oferta> ofertas;
	
	public ItemDto(Item item) {
		this.id = item.getId();
		this.nome = item.getNome();
		this.dataCriacao = item.getDataCriacao();
		this.dataValidade = item.getDataValidade();
		this.valor = item.getValor();
		this.descricao = item.getDescricao();
		this.ofertas = item.getOfertas();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public float getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	
	public static List<ItemDto> converter(List<Item> itens){
		return itens.stream().map(ItemDto::new).collect(Collectors.toList());
	}
}
