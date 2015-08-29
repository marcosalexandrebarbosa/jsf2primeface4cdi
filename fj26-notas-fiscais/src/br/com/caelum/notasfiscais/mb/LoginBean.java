package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	
	public String efetuaLogin() {
		UsuarioDao dao = new UsuarioDao();
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			return "produto";
		} else {
			this.usuario = new Usuario();
			return "login";
		}
		//System.out.println("O login era valido? " + loginValido);
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

}