package br.com.rsinet.hub_bdd.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PesquisaPage {

	/* Area onde sao encontrados os elementos na pagina de pesquisa. */

	/*
	 * Encontra os Editores de Texto, Botoes, ComboBox e CheckBox para o campo
	 * correspondente ao nome da variavel e atribui na mesma.
	 */
	/*
	 * Utilizado para preencher as informacoes de pesquisa e inicio de compra de
	 * produto.
	 */
	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement bt_SalvaProduto;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement bt_Comprar;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement txt_Quantidade;

	@FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/td[2]/a/label[1]")
	public WebElement qtd_Produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public WebElement desc_Produto;

	@FindBy(how = How.ID, using = "27")
	public WebElement id_Produto;

	/* Metodo utilizado para selecionar o produto desejado na tela de pesquisa. */
	public WebElement selecionaProdutoCat(WebDriver driver, String produto) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(produto)));
		element.click();
		return element;
	}
	
	/*Metodo utilizado para selecionar produto na tela de pesquisa por id. */
	public WebElement selecionaProduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(this.id_Produto));
		element.click();
		return element;
	}

	/* Metodo utilizado para clicar no botao de adicionar o produto ao carrinho. */
	public void bt_SalvaProduto() {
		this.bt_SalvaProduto.click();
	}

	/* Metodo utilizado para clicar no botao de iniciar a compra do produto. */
	public void bt_Comprar() {
		this.bt_Comprar.click();
	}

	/*
	 * Metodo utilizado para alterar a quantidade de produtos que serao adicionados
	 * no carrinho de compras.
	 */
	public void quantidadeProduto(String txt_Quantidade) {
		this.txt_Quantidade.sendKeys(txt_Quantidade);
	}
}
