package br.com.rsinet.hub_bdd.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pageFactory.HomePage;
import br.com.rsinet.hub_bdd.pageFactory.PesquisaPage;
import br.com.rsinet.hub_bdd.utils.Constant;
import br.com.rsinet.hub_bdd.utils.DriverFactory;
import br.com.rsinet.hub_bdd.utils.DriverFactory.DriverType;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.Prints;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ConsultaPorBarraDePesquisa {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;

	@Dado("Que o usuario esteja na tela inicial com a intencao de realizar uma consulta por barra de pesquisa")
	public void que_o_usuario_esteja_na_tela_inicial_com_a_intencao_de_realizar_uma_consulta_por_barra_de_pesquisa()
			throws Throwable {
		driver = DriverFactory.iniciaBrowser(DriverType.Chrome, Constant.URL);

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaBarra");
		
		 /* Comando responsavel por iniciar os elementos dentro da pageFactory
		 	especificada.*/
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
	}

	@Quando("Clicar na lupa")
	public void clicar_na_lupa() throws Throwable {
		homePage.bt_Lupa();
	}

	@Quando("Digitar e pesquisar o nome do produto desejado")
	public void digitar_e_pesquisar_o_nome_do_produto_desejado() throws Throwable {
		 /* Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 	uma variavel.*/
		String txt_Pesquisa = (ExcelUtils.getCellData(1, Constant.pesquisaBarra));
		homePage.pesquisar(txt_Pesquisa);
	}

	@Quando("Selecionar o produto desejado")
	public void selecionar_o_produto_desejado() throws Throwable {
		homePage.bt_FechaSugestao(driver);

		String produto = ExcelUtils.getCellData(2, Constant.escolheProduto);
		pesquisaPage.selecionaProduto(driver, produto).click();
	}

	@Entao("Checar se o produto selecionado foi encontrado")
	public void checar_se_o_produto_selecionado_foi_encontrado() throws Throwable {
		 /* Comandos responsaveis por receber os valores necessários para acionar o
		 	assert.*/
		String condicao = ExcelUtils.getCellData(1, Constant.condicaoAssertBarra);
		String mensagem = ExcelUtils.getCellData(2, Constant.mensagemAssertBarra);
		String elemento = pesquisaPage.desc_Produto.getText();
		
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(mensagem, elemento.equals(condicao));
		
		Prints.tirarPrintsDeSucesso("ConsultaPorBarraDePesquisaSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

	@Quando("Digitar e pesquisar o nome do produto desejado que nao existe no banco de dados")
	public void digitar_e_pesquisar_o_nome_do_produto_desejado_que_nao_existe_no_banco_de_dados() throws Throwable {
		 /* Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 	uma variavel.*/
		String txt_Pesquisa = (ExcelUtils.getCellData(5, Constant.pesquisaBarraErro));
		homePage.pesquisar(txt_Pesquisa);
	}

	@Entao("Checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado")
	public void checar_no_banco_de_dados_e_informar_que_nao_foi_encontrado_nenhum_resultado_para_o_produto_desejado()
			throws Throwable {
		homePage.result_Produto(driver);
		
		 /* Comandos responsaveis por receber os valores necessários para acionar o
		 	assert.*/
		String elemento = ExcelUtils.getCellData(5, Constant.pesquisaBarraErro);
		String resposta = homePage.result_Produto.getText();
		
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue("Nenhum resultado encontrado para " + elemento + "!", resposta.equals("No results for " + "\"" + elemento + "\""));
		
		Prints.tirarPrintsDeFalha("ConsultaPorBarraDePesquisaFalha ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
