# language: pt

Funcionalidade: Pesquisa e compra de produtos por categoria.

Contexto: 
	Dado Que o usuario esteja na tela inicial com a intencao de realizar uma pesquisa por categoria ou uma compra
    Quando Ele efetuar o login
    E Ele clicar no link da categoria do produto
    E Clicar no produto desejado

@TesteDeSucesso
Cenario: Teste de pesquisa e compra de produto por categoria
    E Clicar no botao de adicionar ao carrinho
    E Clicar no pop up de checar o produto no carrinho
    E Passar para a proxima fase de compra
    E Logar na conta Pay
    E Clicar no botao de efetuar compra
    Entao Verifica se a compra foi efetuada com sucesso
  
@TesteDeFalha  
Cenario: Teste de compra de produto acima da quantidade permitida no carrinho de compras
    E Alterar a quantidade de produtos para compra acima do aceitavel no carrinho
    E Clicar no botao de adicionar ao carrinho novamente
    E Clicar no pop up de checar o produto no carrinho novamente
    Entao Checar se a quantidade de produtos solicitada corresponde a quantidade no carrinho