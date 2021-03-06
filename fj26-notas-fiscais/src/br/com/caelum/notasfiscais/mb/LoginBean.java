package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDao dao;
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	public String efetuaLogin() {
		//UsuarioDao dao = new UsuarioDao();
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			usuarioLogado.loga(usuario);
			return "produto?faces-redirect=true";
		} else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
		//System.out.println("O login era valido? " + loginValido);
	}
	
	public String efetuaLogout() {

		usuarioLogado.efetuaLogout();
		
		return "login";

	}

	public Usuario getUsuario() {
		return this.usuario;
	}

}
