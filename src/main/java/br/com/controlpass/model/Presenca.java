package br.com.controlpass.model;

public class Presenca extends Aluno {
	
	private String data;
	private String entrada;
	private String saida;
	private String situacao;
	private String totalPresenca;

    public Presenca(int idAluno, Usuario usuario, int codigoBiometria) {
        super(idAluno, usuario, codigoBiometria);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTotalPresenca() {
        return totalPresenca;
    }

    public void setTotalPresenca(String totalPresenca) {
        this.totalPresenca = totalPresenca;
    }
	

}
