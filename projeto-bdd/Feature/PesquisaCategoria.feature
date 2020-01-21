Feature: Pesquisa e compra de produtos.

Background: 
	Given Que o usuario esteja na tela inicial com a intencao de realizar uma pesquisa por categoria ou uma compra
    When Ele efetuar o login
    And Ele clicar no link da categoria do produto
    And Clicar no produto desejado

@TesteDeSucesso
Scenario: Teste de pesquisa e compra de produto por categoria
    And Clicar no botao de adicionar ao carrinho
    And Clicar no pop up de checar o produto no carrinho
    And Passar para a proxima fase de compra
    And Logar na conta Pay
    And Clicar no botao de efetuar compra
    Then Verifica se a compra foi efetuada com sucesso
  
@TesteDeFalha  
Scenario: Teste de compra de produto acima da quantidade permitida no carrinho de compras
    And Alterar a quantidade de produtos para compra acima do aceitavel no carrinho
    And Clicar no botao de adicionar ao carrinho novamente
    And Clicar no pop up de checar o produto no carrinho novamente
    Then Checar se a quantidade de produtos solicitada corresponde a quantidade no carrinho