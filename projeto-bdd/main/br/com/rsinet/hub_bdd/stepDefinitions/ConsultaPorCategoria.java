package br.com.rsinet.hub_bdd.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pageFactory.HomePage;
import br.com.rsinet.hub_bdd.pageFactory.PagamentoPage;
import br.com.rsinet.hub_bdd.pageFactory.PesquisaPage;
import br.com.rsinet.hub_bdd.utils.Constant;
import br.com.rsinet.hub_bdd.utils.DriverFactory;
import br.com.rsinet.hub_bdd.utils.DriverFactory.DriverType;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.Prints;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ConsultaPorCategoria {

	private WebDriver driver;
	private HomePage homePage;
	private PesquisaPage pesquisaPage;
	private PagamentoPage pagamentoPage;

	@Dado("Que o usuario esteja na tela inicial com a intencao de realizar uma pesquisa por categoria ou uma compra")
	public void que_o_usuario_esteja_na_tela_inicial_com_a_intencao_de_realizar_uma_pesquisa_por_categoria_ou_uma_compra()
			throws Throwable {
		driver = DriverFactory.iniciaBrowser(DriverType.Chrome, Constant.URL);

		/* Comando responsavel por ler o arquivo e aba do excel especificados.*/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pagamento");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "PesquisaCat");

		/* Comando responsavel por iniciar os elementos dentro da pageFactory
		 	especificada.*/
		homePage = PageFactory.initElements(driver, HomePage.class);
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
		pagamentoPage = PageFactory.initElements(driver, PagamentoPage.class);
	}

	@Quando("Ele efetuar o login")
	public void ele_efetuar_o_login() throws Throwable {
		 /* Comando responsavel por aguardar o tempo especificado entre as linhas de
		 	comando.*/

		homePage.bt_UserIcon();

		 /* Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 	uma variavel.*/
		String txt_UserLogin = ExcelUtils.getCellData(1, Constant.userNameCat);
		String txt_PasswordLogin = ExcelUtils.getCellData(2, Constant.passwordCat);
		homePage.preencheLogin(txt_UserLogin, txt_PasswordLogin);

		homePage.bt_Logar();
	}

	@Quando("Ele clicar no link da categoria do produto")
	public void ele_clicar_no_link_da_categoria_do_produto() throws Throwable {
		homePage.clicaProdutoCategoria(driver);
	}

	@Quando("Clicar no produto desejado")
	public void clicar_no_produto_desejado() throws Throwable {
		String produto = ExcelUtils.getCellData(5, Constant.clicaProduto);
		pesquisaPage.selecionaProdutoCat(driver, produto);
	}

	@Quando("Clicar no botao de adicionar ao carrinho")
	public void clicar_no_botao_de_adicionar_ao_carrinho() throws Throwable {
		pesquisaPage.bt_SalvaProduto();
	}

	@Quando("Clicar no pop up de checar o produto no carrinho")
	public void clicar_no_pop_up_de_checar_o_produto_no_carrinho() throws Throwable {
		pesquisaPage.bt_Comprar();
	}

	@Quando("Passar para a proxima fase de compra")
	public void passar_para_a_proxima_fase_de_compra() throws Throwable {
		pagamentoPage.bt_Next();
	}

	@Quando("Logar na conta Pay")
	public void logar_na_conta_Pay() throws Throwable {
		String txt_UserNamePay = ExcelUtils.getCellData(1, Constant.userNamePay);
		String txt_PasswordPay = ExcelUtils.getCellData(2, Constant.passwordPay);
		pagamentoPage.logaContaPay(txt_UserNamePay, txt_PasswordPay);

		pagamentoPage.check_SavePay();
	}

	@Quando("Clicar no botao de efetuar compra")
	public void clicar_no_botao_de_efetuar_compra() throws Throwable {
		pagamentoPage.bt_Pay();
	}

	@Entao("Verifica se a compra foi efetuada com sucesso")
	public void verifica_se_a_compra_foi_efetuada_com_sucesso() throws Throwable {
		 /* Comandos responsaveis por receber os valores necessários para acionar o
		 	assert.*/
		String condicao = ExcelUtils.getCellData(2, Constant.condicaoAssertMassaSucesso);
		String mensagem = ExcelUtils.getCellData(1, Constant.mensagemAssertMassaSucesso);
		pagamentoPage.pega_Pago(driver);
		String aviso = pagamentoPage.lbl_Pago.getText();
		
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(mensagem, aviso.equals(condicao));

		Prints.tirarPrintsDeSucesso("ConsultaPorCategoriaSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

	@Quando("Alterar a quantidade de produtos para compra acima do aceitavel no carrinho")
	public void alterar_a_quantidade_de_produtos_para_compra_acima_do_aceitavel_no_carrinho() throws Throwable {
		String txt_Quantidade = ExcelUtils.getCellData(8, Constant.quantidadeCat);
		pesquisaPage.quantidadeProduto(txt_Quantidade);
	}

	@Quando("Clicar no botao de adicionar ao carrinho novamente")
	public void clicar_no_botao_de_adicionar_ao_carrinho_novamente() throws Throwable {
		pesquisaPage.bt_SalvaProduto();
	}

	@Quando("Clicar no pop up de checar o produto no carrinho novamente")
	public void clicar_no_pop_up_de_checar_o_produto_no_carrinho_novamente() throws Throwable {
		pesquisaPage.bt_Comprar();
	}

	@Entao("Checar se a quantidade de produtos solicitada corresponde a quantidade no carrinho")
	public void checar_se_a_quantidade_de_produtos_solicitada_corresponde_a_quantidade_no_carrinho() throws Exception {
		/* Comandos responsaveis por receber os valores necessários para acionar o
	 	assert.*/
		String condicao = ExcelUtils.getCellData(4, Constant.condicaoAssertMassaErro);
		String mensagem = ExcelUtils.getCellData(3, Constant.mensagemAssertMassaErro);
		String aviso = pesquisaPage.qtd_Produto.getText();
	
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(mensagem, aviso.equals(condicao));

		Prints.tirarPrintsDeFalha("ConsultaPorCategoriaErrado ", driver);
		DriverFactory.fechaBrowser(driver);
	}
}
