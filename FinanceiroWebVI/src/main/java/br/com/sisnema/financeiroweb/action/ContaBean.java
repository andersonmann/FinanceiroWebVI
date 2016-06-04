package br.com.sisnema.financeiroweb.action;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sisnema.financeiroweb.model.Conta;
import br.com.sisnema.financeiroweb.negocio.ContaRN;

@ManagedBean
@RequestScoped
public class ContaBean extends ActionBean<Conta> {

	private Conta selecionada = new Conta();
	private List<Conta> lista;

	public ContaBean() {
		super(new ContaRN());
	}

	public Conta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Conta selecionada) {
		this.selecionada = selecionada;
	}

	public List<Conta> getLista() {
		if (lista == null) {
			lista = negocio.pesquisar(new Conta(obterUsuarioLogado()));
		}
		return lista;
	}

}
