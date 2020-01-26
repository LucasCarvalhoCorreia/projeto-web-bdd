package br.com.rsinet.hub_bdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage {

	/* Area onde sao encontrados os elementos na pagina de cadastro. */

	/*
	 * Encontra os Editores de Texto, Botoes, ComboBox e CheckBox para o campo
	 * correspondente ao nome da variavel e atribui na mesma.
	 */
	/* Utilizado para preencher as informacoes de cadastro. */
	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement txt_UserName;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement txt_Email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement txt_Password;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement txt_ConfirmPassword;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement txt_FirstName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement txt_LastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement txt_Telefone;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement combo_Pais;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement txt_Cidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement txt_Endereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement txt_Estado;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement txt_Cep;

	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	private WebElement check_Offers;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement check_Agree;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement bt_Registrar;

	/* Elemento utilizado para receber o status da confirmacao da senha. */
	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/label")
	public WebElement not_Password;

	/* Elemento utilizado para receber o nome de usuario logado. */
	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	public WebElement user_Logon;

	/*
	 * Metodo utilizado para receber as informacoes da massa de dados e preencher o
	 * formulario.
	 */
	public void cadastrarUsuario(String txt_UserName, String txt_Email, String txt_Password, String txt_ConfirmPassword,
			String txt_FirstName, String txt_LastName, String txt_Telefone, String combo_Pais, String txt_Cidade,
			String txt_Endereco, String txt_Estado, String txt_Cep) {

		this.txt_UserName.sendKeys(txt_UserName);
		this.txt_Email.sendKeys(txt_Email);
		this.txt_Password.sendKeys(txt_Password);
		this.txt_ConfirmPassword.sendKeys(txt_ConfirmPassword);
		this.txt_FirstName.sendKeys(txt_FirstName);
		this.txt_LastName.sendKeys(txt_LastName);
		this.txt_Telefone.sendKeys(txt_Telefone);
		new Select(this.combo_Pais).selectByVisibleText(combo_Pais);
		this.txt_Cidade.sendKeys(txt_Cidade);
		this.txt_Endereco.sendKeys(txt_Endereco);
		this.txt_Estado.sendKeys(txt_Estado);
		this.txt_Cep.sendKeys(txt_Cep);
	}

	/* Metodo utilizado para preencher o campo de confirmacao de senha. */
	public void mudaSenha(String txt_ChangePassword) {
		this.txt_ConfirmPassword.sendKeys(txt_ChangePassword);
	}

	/* Metodo utilizado para limpar o campo de confirmacao de senha. */
	public void clear() {
		this.txt_ConfirmPassword.clear();
	}

	/*
	 * Metodo utilizado para clicar no campo senha para que a notificacao de erro na
	 * confirmacao de senha apareca.
	 */
	public void clicaPassword() {
		this.txt_Password.click();
	}

	/* Metodo utilizado para clicar no check box de ofertas. */
	public void check_Offers() {
		this.check_Offers.click();
	}

	/* Metodo utilizado para clicar no check box de termos de servico. */
	public void check_Agree() {
		this.check_Agree.click();
	}

	/* Metodo utilizado para clicar no botao de registrar. */
	public void bt_Registrar() {
		this.bt_Registrar.click();
	}

	/*
	 * Metodo utilizado para aguardar que o elemento que aparece o nome de usuario
	 * apareca para coletar a informacao.
	 */
	public void pega_UserLogon(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(this.user_Logon));
	}

}
