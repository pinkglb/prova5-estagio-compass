package br.com.compasso.pedidos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import br.com.compasso.pedidos.modelo.Item;
import br.com.compasso.pedidos.modelo.Pedido;

public class PedidoDto {
	private Long id;
	private String cpf;
	private float total;
	private List<Item> itens;
	
	public PedidoDto (Pedido pedido) {
		this.id = pedido.getId();
		this.cpf = pedido.getCpf();
		this.total = pedido.getTotal();
		this.itens = pedido.getItens();
	}
	
	public Long getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
	}
	public float getTotal() {
		return total;
	}
	public List<Item> getItens() {
		return itens;
	}
	public static List<PedidoDto> converter(List<Pedido> pedidos){
		return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
	}
}
