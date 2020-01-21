Feature: Consulta de produtos por barra de pesquisa.

Background: 
	Given Que o usuario esteja na tela inicial com a intencao de realizar uma consulta por barra de pesquisa
    When Clicar na lupa

@TesteDeSucesso
Scenario: Teste de consulta de produto por barra de pesquisa
	And Digitar e pesquisar o nome do produto desejado
	And Fechar a janela de sugestao de produtos
    And Selecionar o produto desejado
    Then Checar se o produto selecionado foi encontrado
  
@TesteDeFalha  
Scenario: Teste de consulta de produto inexistente por barra de pesquisa
	And Digitar e pesquisar o nome do produto desejado que nao existe no banco de dados
    Then Checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado