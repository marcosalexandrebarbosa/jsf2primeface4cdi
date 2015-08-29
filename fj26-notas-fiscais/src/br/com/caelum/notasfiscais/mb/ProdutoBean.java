package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void grava() {
		ProdutoDao dao = new ProdutoDao();
		//dao.adiciona(produto);
		if (produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}
		produtos = dao.listaTodos();
		this.produto = new Produto();
		
		//return "/produto.xhtml?faces-redirect=true";
	}
	
	public List<Produto> getProdutos() {
		if(produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = new ProdutoDao().listaTodos();
		}
		return produtos;
	}
	
	public String remove(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		return "/produto.xhtml?faces-redirect=true";
	}

}
