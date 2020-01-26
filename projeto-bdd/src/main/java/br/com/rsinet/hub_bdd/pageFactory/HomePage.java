package br.com.rsinet.hub_bdd.pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	/* Area onde sao encontrados os elementos na pagina de inicio. */

	/*
	 * Encontra os Editores de Texto, Botoes, ComboBox e CheckBox para o campo
	 * correspondente ao nome da variavel e atribui na mesma.
	 */
	/* Utilizado para preencher as informacoes de Login e Pesquisa. */
	@FindBy(how = How.ID, using = "hrefUserIcon")
	private WebElement bt_UserIcon;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement bt_CriarNovaConta;

	@FindBy(how = How.NAME, using = "username")
	private WebElement txt_UserName;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txt_Password;

	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement bt_Logar;

	@FindBy(how = How.ID, using = "laptopsImg")
	private WebElement bt_LaptopImg;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement bt_Lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement txt_Pesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	private WebElement bt_FechaSugestao;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public WebElement result_Produto;

	/*
	 * Metodo utilizado para clicar no botao para acessar a pagina de criar nova
	 * conta.
	 */
	public void bt_CriarNovaConta() {
		this.bt_CriarNovaConta.sendKeys(Keys.ENTER);
	}

	/* Metodo utilizado para clicar no botao da area do usuario. */
	public void bt_UserIcon() {
		this.bt_UserIcon.click();
	}

	/* Metodo tuilizado para preencher os dados de login. */
	public void preencheLogin(String txt_UserLogin, String txt_PasswordLogin) {
		this.txt_UserName.sendKeys(txt_UserLogin);
		this.txt_Password.sendKeys(txt_PasswordLogin);
	}

	/* Metodo tuilizado para clicar no botao de logar. */
	public void bt_Logar() {
		this.bt_Logar.sendKeys(Keys.ENTER);
	}

	/*
	 * Metodo tuilizado para clicar na categoria de produtos na pagina inicial
	 * desejada.
	 */
	public void clicaProdutoCategoria(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement elemento = bt_LaptopImg;
		executor.executeScript("arguments[0].click();", elemento);
	}

	/* Metodo tuilizado para clicar no botao de lupa para realizar consultas. */
	public void bt_Lupa() {
		this.bt_Lupa.click();
	}

	/* Metodo tuilizado para pesquisar produtos na barra de pesquisa. */
	public void pesquisar(String txt_Pesquisa) {
		this.txt_Pesquisa.sendKeys(txt_Pesquisa + Keys.ENTER);
	}

	/*
	 * Metodo tuilizado para clicar no botao de fechar a janela de sugestoes de
	 * pesquisa da barra de pesquisa.
	 */
	public void bt_FechaSugestao(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		this.bt_FechaSugestao.click();
	}

	/*Metodo responsavel por aguardar o texto do produto selecionado na pesquisa aparecer.*/
	public void result_Produto(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(this.result_Produto));
	}

}