package br.com.rsinet.hub_bdd.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_bdd.pageFactory.HomePage;
import br.com.rsinet.hub_bdd.utils.Constantes;
import br.com.rsinet.hub_bdd.utils.DriverFactory;
import br.com.rsinet.hub_bdd.utils.DriverFactory.DriverType;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.PegaMassa;
import br.com.rsinet.hub_bdd.utils.Prints;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Cadastro {

	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;
	private PegaMassa pegaMassa;

	/*
	 * Tag que retorna o storie descrito no feature para expressar o cenario em
	 * forma de codigo.
	 */
	@Dado("^Que o usuario esteja na tela inicial com a intencao de realizar um cadastro$")
	public void que_o_usuario_esteja_na_tela_inicial_Sucesso() throws Throwable {
		driver = DriverFactory.iniciaBrowser(DriverType.Chrome, Constantes.URL);

		/* Comando responsavel por ler o arquivo e aba do excel especificados. */
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "Cadastro");

		/*
		 * Comando responsavel por iniciar os elementos dentro da pageFactory
		 * especificada.
		 */
		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		pegaMassa = new PegaMassa();
	}

	@Quando("^Ele clicar no link de login$")
	public void ele_clicar_no_link_de_login() throws Throwable {
		homePage.bt_UserIcon();
	}

	@Quando("^Clicar no link de cadastrar$")
	public void clicar_no_link_de_cadastrar() throws Throwable {
		homePage.bt_CriarNovaConta();
	}

	@Quando("^Preencher o formulario de cadastro$")
	public void preencher_o_formulario_de_cadastro() throws Throwable {
		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel.
		 */
		cadastroPage.cadastrarUsuario(pegaMassa.UserName(), pegaMassa.Email(), pegaMassa.Password(),
				pegaMassa.ConfirmPassword(), pegaMassa.FirstName(), pegaMassa.LastName(), pegaMassa.Telefone(),
				pegaMassa.Pais(), pegaMassa.Cidade(), pegaMassa.Endereco(), pegaMassa.Estado(), pegaMassa.Cep());
	}

	@Quando("^Clicar na caixa de receber ofertas$")
	public void clicar_na_caixa_de_receber_ofertas() throws Throwable {
		cadastroPage.check_Offers();
	}

	@Quando("^Clicar no botao de aceitar os termos$")
	public void clicar_no_botao_de_aceitar_os_termos() throws Throwable {
		cadastroPage.check_Agree();
	}

	@Quando("^Clicar no botao de registrar$")
	public void clicar_no_botao_de_registrar() throws Throwable {
		cadastroPage.bt_Registrar();
	}

	@Entao("^Verifica se o usuario esta logado$")
	public void verifica_se_o_usuario_esta_logado() throws Throwable {
		/*
		 * Comandos responsaveis por receber os valores necessarios para acionar o
		 * assert.
		 */
		String condicao = pegaMassa.UserName();
		String mensagem = pegaMassa.MenssagemAssertCadastroSucesso();

		cadastroPage.pega_UserLogon(driver);
		String pass = cadastroPage.user_Logon.getText();

		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(mensagem, pass.equals(condicao));

		Prints.tirarPrintsDeSucesso("CadastroSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

	@Quando("^Preencher o formulario de cadastro com a confirmacao de senha diferente da senha$")
	public void preencher_o_formulario_de_cadastro_com_a_confirmacao_de_senha_diferente_da_senha() throws Throwable {
		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel.
		 */
		cadastroPage.cadastrarUsuario(pegaMassa.UserName(), pegaMassa.Email(), pegaMassa.Password(),
				pegaMassa.ConfirmPasswordErrado(), pegaMassa.FirstName(), pegaMassa.LastName(), pegaMassa.Telefone(),
				pegaMassa.Pais(), pegaMassa.Cidade(), pegaMassa.Endereco(), pegaMassa.Estado(), pegaMassa.Cep());
	}

	@Quando("^Clicar na caixa de receber ofertas novamente$")
	public void clicar_na_caixa_de_receber_ofertas_novamente() throws Throwable {
		cadastroPage.check_Offers();
	}

	@Quando("^Clicar no botao de aceitar os termos novamente$")
	public void clicar_no_botao_de_aceitar_os_termos_novamente() throws Throwable {
		cadastroPage.check_Agree();
	}

	@Quando("^Clicar no botao de registrar novamente$")
	public void clicar_no_botao_de_registrar_novamente() throws Throwable {
		cadastroPage.bt_Registrar();
	}

	@Entao("^O usuario nao pode efetuar o registro$")
	public void o_usuario_nao_pode_efetuar_o_registro() throws Throwable {
		/*
		 * Atribui o valor recebido pela coluna e linha especificada no arquivo excel a
		 * uma variavel.
		 */
		String txt_ChangePassword = pegaMassa.ConfirmPasswordErrado();
		cadastroPage.clear();
		cadastroPage.mudaSenha(txt_ChangePassword);

		cadastroPage.clicaPassword();

		/*
		 * Comandos responsaveis por receber os valores necessários para acionar o
		 * assert.
		 */
		String condicao = pegaMassa.CondicaoAssertCadastroErro();
		String mensagem = pegaMassa.MenssagemAssertCadastroErro();
		String pass = cadastroPage.not_Password.getText();
		/* Comando responsavel por conferir se o teste agiu como o esperado. */
		Assert.assertTrue(mensagem, pass.equals(condicao));

		Prints.tirarPrintsDeFalha("CadastroFalha ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
