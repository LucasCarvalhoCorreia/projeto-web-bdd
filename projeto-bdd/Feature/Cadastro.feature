Feature: Teste de cadastro de novo usuario.

Scenario: Teste de cadastro com sucesso
    Given Que o usuario esteja na tela inicial
    When Ele clicar no link de login
    And Clicar no link de cadastrar
    And Preencher o formulario de cadastro
    And Clicar na caixa de receber ofertas
    And Clicar no botao de aceitar os termos
    And Clicar no botao de registrar
    Then Verifica se o usuario esta logado
    
Scenario: Teste de cadastro com falha
    Given Que o usuario esteja na tela inicial novamente
    When Ele clicar no link de login novamente
    And Clicar no link de cadastrar novamente
    And Preencher o formulario de cadastro com a confirmacao de senha diferente da senha
    And Clicar na caixa de receber ofertas novamente
    And Clicar no botao de aceitar os termos novamente
    And Clicar no botao de registrar novamente
    Then O usuario nao pode efetuar o registro
    
  