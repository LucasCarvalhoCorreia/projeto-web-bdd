package br.com.rsinet.hub_bdd.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_bdd.pageFactory.HomePage;
import br.com.rsinet.hub_bdd.utils.Constant;
import br.com.rsinet.hub_bdd.utils.DriverFactory;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.Prints;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cadastro {
	
	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;

	@Given("^Que o usuario esteja na tela inicial$")
	public void que_o_usuario_esteja_na_tela_inicial_sucesso() throws Throwable {
		driver = DriverFactory.iniciaBrowser();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Ele clicar no link de login$")
	public void ele_clicar_no_link_de_login_sucesso() throws Throwable {
		homePage.bt_UserIcon();
	}

	@When("^Clicar no link de cadastrar$")
	public void clicar_no_link_de_cadastrar_sucesso() throws Throwable {
		homePage.bt_CriarNovaConta();
	}

	@When("^Preencher o formulario de cadastro$")
	public void preencher_o_formulario_de_cadastro_sucesso() throws Throwable {
		String txt_UserName = ExcelUtils.getCellData(1, Constant.userName);
		String txt_Email = ExcelUtils.getCellData(2, Constant.email);
		String txt_Password = ExcelUtils.getCellData(3, Constant.password);
		String txt_ConfirmPassword = ExcelUtils.getCellData(4, Constant.confirmPassword);
		String txt_FirstName = ExcelUtils.getCellData(6, Constant.firstName);
		String txt_LastName = ExcelUtils.getCellData(7, Constant.lastName);
		String txt_Telefone = ExcelUtils.getCellData(8, Constant.telefone);
		String combo_Pais = ExcelUtils.getCellData(9, Constant.pais);
		String txt_Cidade = ExcelUtils.getCellData(10, Constant.cidade);
		String txt_Endereco = ExcelUtils.getCellData(11, Constant.endereco);
		String txt_Estado = ExcelUtils.getCellData(12, Constant.estado);
		String txt_Cep = ExcelUtils.getCellData(13, Constant.cep);
		
		cadastroPage.cadastrarUsuario(txt_UserName, txt_Email, txt_Password, txt_ConfirmPassword, txt_FirstName, txt_LastName, txt_Telefone, combo_Pais, txt_Cidade, txt_Endereco, txt_Estado, txt_Cep);
	}

	@When("^Clicar na caixa de receber ofertas$")
	public void clicar_na_caixa_de_receber_ofertas_sucesso() throws Throwable {
		cadastroPage.check_Offers();
	}

	@When("^Clicar no botao de aceitar os termos$")
	public void clicar_no_botão_de_aceitar_os_termos_sucesso() throws Throwable {
		cadastroPage.check_Agree();
	}

	@When("^Clicar no botao de registrar$")
	public void clicar_no_botão_de_registrar_sucesso() throws Throwable {
		cadastroPage.bt_Registrar();
	}

	@Then("^Verifica se o usuario esta logado$")
	public void verifica_se_o_usuario_esta_logado_sucesso() throws Throwable {
		String condicao = ExcelUtils.getCellData(1, Constant.userName);
		String mensagem = ExcelUtils.getCellData(3, Constant.mensagemAssertCadastroSucesso);
		
		cadastroPage.pega_UserLogon(driver);
		String pass = cadastroPage.user_Logon.getText();
		Assert.assertTrue(mensagem, pass.equals(condicao));
	}
	
	@Given("^Que o usuario esteja na tela inicial novamente$")
	public void que_o_usuario_esteja_na_tela_inicial_falha() throws Throwable {
		driver = DriverFactory.iniciaBrowser();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Ele clicar no link de login novamente$")
	public void Ele_clicar_no_link_de_login_falha() throws Throwable {
		homePage.bt_UserIcon();
	}

	@When("^Clicar no link de cadastrar novamente$")
	public void clicar_no_link_de_cadastrar_falha() throws Throwable {
		homePage.bt_CriarNovaConta();
	}
	
	@When("^Preencher o formulario de cadastro com a confirmacao de senha diferente da senha$")
	public void preencher_o_formulario_de_cadastro_com_a_confirmacao_de_senha_diferente_da_senha() throws Throwable {
		String txt_UserName = ExcelUtils.getCellData(1, Constant.userName);
		String txt_Email = ExcelUtils.getCellData(2, Constant.email);
		String txt_Password = ExcelUtils.getCellData(3, Constant.password);
		String txt_ConfirmPassword = ExcelUtils.getCellData(4, Constant.confirmPassword);
		String txt_FirstName = ExcelUtils.getCellData(6, Constant.firstName);
		String txt_LastName = ExcelUtils.getCellData(7, Constant.lastName);
		String txt_Telefone = ExcelUtils.getCellData(8, Constant.telefone);
		String combo_Pais = ExcelUtils.getCellData(9, Constant.pais);
		String txt_Cidade = ExcelUtils.getCellData(10, Constant.cidade);
		String txt_Endereco = ExcelUtils.getCellData(11, Constant.endereco);
		String txt_Estado = ExcelUtils.getCellData(12, Constant.estado);
		String txt_Cep = ExcelUtils.getCellData(13, Constant.cep);

		cadastroPage.cadastrarUsuario(txt_UserName, txt_Email, txt_Password, txt_ConfirmPassword, txt_FirstName,
				txt_LastName, txt_Telefone, combo_Pais, txt_Cidade, txt_Endereco, txt_Estado, txt_Cep);
	}
	
	@When("^Clicar na caixa de receber ofertas novamente$")
	public void clicar_na_caixa_de_receber_ofertas_falha() throws Throwable {
		cadastroPage.check_Offers();
	}

	@When("^Clicar no botao de aceitar os termos novamente$")
	public void clicar_no_botão_de_aceitar_os_termos_falha() throws Throwable {
		cadastroPage.check_Agree();
	}

	@When("^Clicar no botao de registrar novamente$")
	public void clicar_no_botão_de_registrar_falha() throws Throwable {
		cadastroPage.bt_Registrar();
	}
	
	@Then("^O usuario nao pode efetuar o registro$")
	public void o_usuario_nao_pode_efetuar_o_registro() throws Throwable {
		String txt_ChangePassword = ExcelUtils.getCellData(5, Constant.confirmInvalidPassword);
		cadastroPage.clear();
		cadastroPage.mudaSenha(txt_ChangePassword);

		cadastroPage.clicaPassword();

		String condicao = ExcelUtils.getCellData(1, Constant.condicaoAssertCadastroErro);
		String mensagem = ExcelUtils.getCellData(2, Constant.mensagemAssertCadastroErro);
		String pass = cadastroPage.not_Password.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(mensagem, pass.equals(condicao));
	}
	
	@After
	public void fim() throws Exception {
		Prints.tirarPrints("Cadastro ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
