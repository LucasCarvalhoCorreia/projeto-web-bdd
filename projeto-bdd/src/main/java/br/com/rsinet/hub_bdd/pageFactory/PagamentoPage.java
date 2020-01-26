package br.com.rsinet.hub_bdd.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagamentoPage {
	
	/* Area onde sao encontrados os elementos na pagina de pagamentos. */

	/*
	 * Encontra os Editores de Texto, Botoes, ComboBox e CheckBox para o campo
	 * correspondente ao nome da variavel e atribui na mesma.
	 */
	/* Utilizado para preencher as informacoes de Login na conta Pay. */
	@FindBy(how = How.ID, using = "next_btn")
	private WebElement bt_Next;

	@FindBy(how = How.NAME, using = "safepay_username")
	private WebElement txt_UserNamePay;

	@FindBy(how = How.NAME, using = "safepay_password")
	private WebElement txt_PasswordPay;

	@FindBy(how = How.NAME, using = "save_safepay")
	private WebElement check_SavePay;

	@FindBy(how = How.ID, using = "pay_now_btn_SAFEPAY")
	private WebElement bt_Pay;

	@FindBy(how = How.XPATH, using = "//*[@id=\"orderPaymentSuccess\"]/h2/span")
	public WebElement lbl_Pago;

	/*
	 * Metodo utilizado para clicar no botao para a proxima etapa de compra de
	 * produto.
	 */
	public void bt_Next() {
		this.bt_Next.click();
	}

	/* Metodo utilizado para logar na conta Pay. */
	public void logaContaPay(String txt_UserNamePay, String txt_PasswordPay) {
		this.txt_UserNamePay.clear();
		this.txt_UserNamePay.sendKeys(txt_UserNamePay);
		this.txt_PasswordPay.clear();
		this.txt_PasswordPay.sendKeys(txt_PasswordPay);
	}

	/* Metodo utilizado para clicar na check box de salvar login da conta Pay. */
	public void check_SavePay() {
		this.check_SavePay.click();
	}

	/* Metodo utilizado para clicar no botao para comprar o produto. */
	public void bt_Pay() {
		this.bt_Pay.click();
	}

	/*
	 * Metodo utilizado para aguardar e pegar a mensagem de confirmacao de compra da
	 * tela de pagamento.
	 */
	public void pega_Pago(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(this.lbl_Pago));
	}
}
