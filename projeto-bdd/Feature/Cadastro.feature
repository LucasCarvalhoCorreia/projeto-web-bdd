#language: pt
Funcionalidade: Teste de cadastro de novo usuário.

  Cenário: Teste de cadastro com sucesso.
    Dado Que o usuário esteja na tela inicial
    Quando ele clicar no link de login
    E Clicar no link de cadastrar
    E Preencher o usuario de login "userName"
    E Preencher a senha de login "<password>"
    E Preencher o email "<email>"
    E Preencher a confirmação de senha de login "<confirmPassword>"
    E Preencher o primeiro nome "<firstName>"
    E Preencher o sobrenome "<lastName>"
    E Preencher o número de telefone "<phoneNumber>"
    E Preencher o pais "<country>"
    E Preencher a cidade "<city>"
    E Preencher o endreço "<address>"
    E Preencher o estado "<state>"
    E Preencher o cep "<cep>"
    E Clicar na caixa de receber ofertas
    E Clicar no botão de aceitar os termos
    E Clicar no botão de registrar
    Então Verifica se o usuário esta logado "<verifica_Logado>"
