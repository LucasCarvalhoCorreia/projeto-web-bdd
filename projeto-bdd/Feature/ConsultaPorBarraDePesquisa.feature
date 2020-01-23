# language: pt

Funcionalidade: Consulta de produtos por barra de pesquisa.

Contexto: 
	Dado Que o usuario esteja na tela inicial com a intencao de realizar uma consulta por barra de pesquisa
    Quando Clicar na lupa

@TesteDeSucesso
Cenario: Teste de consulta de produto por barra de pesquisa
	E Digitar e pesquisar o nome do produto desejado
    E Selecionar o produto desejado
    Quando Checar se o produto selecionado foi encontrado
  
@TesteDeFalha  
Cenario: Teste de consulta de produto inexistente por barra de pesquisa
	E Digitar e pesquisar o nome do produto desejado que nao existe no banco de dados
    Quando Checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado