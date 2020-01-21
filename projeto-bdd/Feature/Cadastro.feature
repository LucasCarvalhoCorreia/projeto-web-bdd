Feature: Cadastro de novo usuario.

Background: 
	Given Que o usuario esteja na tela inicial com a intencao de realizar um cadastro
    When Ele clicar no link de login
    And Clicar no link de cadastrar

@TesteDeSucesso
Scenario: Teste de cadastro de novo usuario
    And Preencher o formulario de cadastro
    And Clicar na caixa de receber ofertas
    And Clicar no botao de aceitar os termos
    And Clicar no botao de registrar
    Then Verifica se o usuario esta logado
  
@TesteDeFalha  
Scenario: Teste de cadastro com senhas divergentes
    And Preencher o formulario de cadastro com a confirmacao de senha diferente da senha
    And Clicar na caixa de receber ofertas novamente
    And Clicar no botao de aceitar os termos novamente
    And Clicar no botao de registrar novamente
    Then O usuario nao pode efetuar o registro
    
  