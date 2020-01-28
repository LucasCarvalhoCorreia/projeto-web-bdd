package br.com.rsinet.hub_bdd.utils;

public class PegaMassa {
	
	/* Classe responsável por pegar os dados do arquivo de massa e jogar na classe de teste.*/
	
	// Cadastro
	public String UserName() throws Exception {
		return ExcelUtils.getCellData(1, Constantes.userName);
	}
	
	public String Email() throws Exception {
		return ExcelUtils.getCellData (2, Constantes.email);
	}
	
	public String Password() throws Exception {
		return ExcelUtils.getCellData(3, Constantes.password);
	}
	
	public String ConfirmPassword() throws Exception {
		return ExcelUtils.getCellData(4, Constantes.confirmPassword);
	}
	
	public String ConfirmPasswordErrado() throws Exception {
		return ExcelUtils.getCellData(5, Constantes.confirmInvalidPassword);
	}
	
	public String FirstName() throws Exception {
		return ExcelUtils.getCellData(6, Constantes.firstName);
	}
	
	public String LastName() throws Exception {
		return ExcelUtils.getCellData(7, Constantes.lastName);
	}
	
	public String Telefone() throws Exception {
		return ExcelUtils.getCellData(8, Constantes.telefone);
	}
	
	public String Pais() throws Exception {
		return ExcelUtils.getCellData(9, Constantes.pais);
	}
	
	public String Cidade() throws Exception {
		return ExcelUtils.getCellData(10, Constantes.cidade);
	}
	
	public String Endereco() throws Exception {
		return ExcelUtils.getCellData(11, Constantes.endereco);
	}
	
	public String Estado() throws Exception {
		return ExcelUtils.getCellData(12, Constantes.estado);
	}
	
	public String Cep() throws Exception {
		return ExcelUtils.getCellData(13, Constantes.cep);
	}
	
	public String MenssagemAssertCadastroSucesso() throws Exception {
		return ExcelUtils.getCellData(3, Constantes.mensagemAssertCadastroSucesso);
	}
	
	public String CondicaoAssertCadastroErro() throws Exception {
		return ExcelUtils.getCellData(1, Constantes.condicaoAssertCadastroErro);
	}
	
	public String MenssagemAssertCadastroErro() throws Exception {
		return ExcelUtils.getCellData(2, Constantes.mensagemAssertCadastroErro);
	}
	
	//PesquisaBarra
	public String PesquisaNaBarra() throws Exception {
		return ExcelUtils.getCellData(1, Constantes.pesquisaBarra);
	}
	
	public String PesquisaNaBarraErro() throws Exception {
		return ExcelUtils.getCellData(5, Constantes.pesquisaBarraErro);
	}
	
	public String CondicaoAssertBarra() throws Exception {
		return ExcelUtils.getCellData(1, Constantes.condicaoAssertBarra);
	}
	
	public String MenssagemAssertBarra() throws Exception {
		return ExcelUtils.getCellData(2, Constantes.mensagemAssertBarra);
	}
	
	//PesquisaCategoria
	public String ClicaNoProduto() throws Exception {
		return ExcelUtils.getCellData(5, Constantes.clicaProduto);
	}
	
	public String CondicaoAssertMassaSucesso() throws Exception {
		return ExcelUtils.getCellData(2, Constantes.condicaoAssertMassaSucesso);
	}
	
	public String MenssagemAssertMassaSucesso() throws Exception {
		return ExcelUtils.getCellData(1, Constantes.mensagemAssertMassaSucesso);
	}
	
	public String CondicaoAssertMassaErro() throws Exception {
		return ExcelUtils.getCellData(4, Constantes.condicaoAssertMassaErro);
	}
	
	public String MenssagemAssertMassaErro() throws Exception {
		return ExcelUtils.getCellData(3, Constantes.mensagemAssertMassaErro);
	}
	
	public String QuantidadeProduto() throws Exception {
		return ExcelUtils.getCellData(8, Constantes.quantidadeCat);
	}
}
