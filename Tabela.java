package lista.exe.trabalho_estrutura;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Tabela implements Comparable<Tabela> {
	DateFormat df = new SimpleDateFormat("ddMMyyyy");

	private String nome_cliente;
	private String data_nascimento;
	private Integer prioridade;

	public Tabela() { 																// Constutor vazio.

	}

	public Tabela(String nome_cliente, String data_nascimento, Integer prioridade) { // Contrutor com argumentos
		super();
		this.nome_cliente = nome_cliente;
		this.data_nascimento = data_nascimento;
		this.prioridade = prioridade;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Apresentando a Lista [Cliente=" + nome_cliente + ", Data de Nascimento=" + data_nascimento
				+ ", Prioridade=" + prioridade + "]";
	}

	@Override
	public int compareTo(Tabela TabelaC) { 												// Faz a comparação da prioridade
		return (prioridade - TabelaC.getPrioridade());
		// return (df.parse(TabelaC.data_nascimento) - df.parse(data_nascimento));
	}

}
