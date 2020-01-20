package br.com.rsinet.hub_bdd.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pageFactory.CadastroPage;
import br.com.rsinet.hub_bdd.pageFactory.HomePage;
import br.com.rsinet.hub_bdd.utils.Constant;
import br.com.rsinet.hub_bdd.utils.DriverFactory;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.Prints;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Cadastro {
	
	private WebDriver driver;
	private HomePage homePage;
	private CadastroPage cadastroPage;
	
	@Dado("^Que o usuário esteja na tela inicial$")
	public void que_o_usuário_esteja_na_tela_inicial() throws Throwable {
		driver = DriverFactory.iniciaBrowser();
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Quando("^ele clicar no link de login$")
	public void ele_clicar_no_link_de_login() throws Throwable {
	    homePage.bt_UserIcon();
	}

	@Quando("^Clicar no link de cadastrar$")
	public void clicar_no_link_de_cadastrar() throws Throwable {
	    homePage.bt_CriarNovaConta();
	}

	@Quando("^Preencher o usuario de login \"([^\"]*)\"$")
	public void preencher_o_usuario_de_login(String userName) throws Throwable {
		cadastroPage.userName(userName);
	}

	@Quando("^Preencher a senha de login \"([^\"]*)\"$")
	public void preencher_a_senha_de_login(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o email \"([^\"]*)\"$")
	public void preencher_o_email(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher a confirmação de senha de login \"([^\"]*)\"$")
	public void preencher_a_confirmação_de_senha_de_login(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o primeiro nome \"([^\"]*)\"$")
	public void preencher_o_primeiro_nome(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o sobrenome \"([^\"]*)\"$")
	public void preencher_o_sobrenome(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o número de telefone \"([^\"]*)\"$")
	public void preencher_o_número_de_telefone(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o pais \"([^\"]*)\"$")
	public void preencher_o_pais(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher a cidade \"([^\"]*)\"$")
	public void preencher_a_cidade(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o endreço \"([^\"]*)\"$")
	public void preencher_o_endreço(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o estado \"([^\"]*)\"$")
	public void preencher_o_estado(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Preencher o cep \"([^\"]*)\"$")
	public void preencher_o_cep(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Clicar na caixa de receber ofertas$")
	public void clicar_na_caixa_de_receber_ofertas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Clicar no botão de aceitar os termos$")
	public void clicar_no_botão_de_aceitar_os_termos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Clicar no botão de registrar$")
	public void clicar_no_botão_de_registrar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Então("^Verifica se o usuário esta logado \"([^\"]*)\"$")
	public void verifica_se_o_usuário_esta_logado(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	public void fim() throws Exception {
		Prints.tirarPrintsDeSucesso("CadastroSucesso ", driver);
		DriverFactory.fechaBrowser(driver);
	}

}
