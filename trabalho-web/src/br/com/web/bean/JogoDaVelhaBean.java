package br.com.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * 
 * @author Artur
 *
 */

@ManagedBean
@ViewScoped
public class JogoDaVelhaBean {

	private String jogadorX;

	private String jogadorO;

	private String jogadorAtual;

	private String titulo;

	private Character[][] jogadas;

	public String getJogadorX() {
		return jogadorX;
	}

	public void setJogadorX(String jogadorX) {
		this.jogadorX = jogadorX;
	}

	public String getJogadorO() {
		return jogadorO;
	}

	public void setJogadorO(String jogadorO) {
		this.jogadorO = jogadorO;
	}

	public String getJogadorAtual() {
		return jogadorAtual;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void novoJogo(ActionEvent event) {
		jogadorAtual = jogadorO;
		atualizarTitulo();
		limparBotoes();
		jogadas = new Character[3][3];
	}

	private void limparBotoes() {
		UIComponent painel = FacesContext.getCurrentInstance().getViewRoot()
				.findComponent("usuarioForm").findComponent("painelDeBotoes");
		for (UIComponent fiflho : painel.getChildren()) {
			UICommand botao = (UICommand) fiflho;
			botao.setValue("  ");
			botao.getAttributes().put("disabled", false);
		}
	}

	public void realizarJogada(ActionEvent event) {
		String valueX = (String) event.getComponent().getAttributes().get("x");
		String valueY = (String) event.getComponent().getAttributes().get("y");
		int x = Integer.parseInt(valueX);
		int y = Integer.parseInt(valueY);

		char tipo = getTipoJogadorAtual();

		UICommand botao = ((UICommand) event.getComponent());
		botao.setValue(tipo);
		botao.getAttributes().put("disabled", true);

		jogadas[x][y] = tipo;
		verificarJogada();
	}

	private void verificarJogada() {
		Character tipoGanhador = getTipoGanhador();
		if (tipoGanhador == null) {
			proximoJogador();
		} else {
			titulo = String.format("O jogador “%s” ganhou", jogadorAtual);
		}
	}

	private Character getTipoGanhador() {
		Character linhaGanhadora = verificarLinhas();
		Character colunaGanhadora = verificarColunas();
		Character diagonalGanhadora = verificarDiagonais();
		if (linhaGanhadora != null) {
			return linhaGanhadora;
		} else if (colunaGanhadora != null) {
			return colunaGanhadora;
		} else if (diagonalGanhadora != null) {
			return diagonalGanhadora;
		} else {
			return null;
		}
	}

	private Character verificarLinhas() {
		for (int i = 0; i < 3; i++) {
			if (jogadas[i][0] == jogadas[i][1]
					&& jogadas[i][1] == jogadas[i][2] && jogadas[i][2] != null) {
				return jogadas[i][0];
			}
		}
		return null;
	}

	private Character verificarColunas() {
		for (int i = 0; i < 3; i++) {
			if (jogadas[0][i] == jogadas[1][i]
					&& jogadas[1][i] == jogadas[2][i] && jogadas[2][i] != null) {
				return jogadas[0][i];
			}
		}
		return null;
	}

	private Character verificarDiagonais() {
		if (jogadas[0][0] == jogadas[1][1] && jogadas[1][1] == jogadas[2][2]
				&& jogadas[2][2] != null) {
			return jogadas[0][0];
		}
		if (jogadas[0][2] == jogadas[1][1] && jogadas[1][1] == jogadas[2][0]
				&& jogadas[2][0] != null) {
			return jogadas[0][0];
		}
		return null;
	}

	private void proximoJogador() {
		if (jogadorAtual.equals(jogadorO)) {
			jogadorAtual = jogadorX;
		} else {
			jogadorAtual = jogadorO;
		}
		atualizarTitulo();
	}

	private void atualizarTitulo() {
		titulo = String.format("Jogador “%s” ", jogadorAtual);
	}

	private char getTipoJogadorAtual() {
		if (jogadorAtual.equals(jogadorO)) {
			return 'O';
		} else {
			return 'X';
		}
	}

}
