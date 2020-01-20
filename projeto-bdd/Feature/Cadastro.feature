#language: pt
Funcionalidade: Teste de cadastro de novo usuário.

  Cenário: Teste de cadastro com sucesso.
    Dado Que o usuário esteja na tela inicial
    Quando ele clicar no link de login
    E Clicar no link de cadastrar
    E Preencher o usuario de login "lucascarvalho"
    E Preencher a senha de login "10203040Lcc"
    E Preencher o email "lucas.carvalho99@hotmail.com"
    E Preencher a confirmação de senha de login "10203040Lcc"
    E Preencher o primeiro nome "Lucas"
    E Preencher o sobrenome "Carvalho Correia"
    E Preencher o número de telefone "96755-3055"
    E Preencher o pais "Brazil"
    E Preencher a cidade "Guarulhos"
    E Preencher o endreço "lucinda fernandes"
    E Preencher o estado "São Paulo"
    E Preencher o cep "07080-320"
    E Clicar na caixa de receber ofertas
    E Clicar no botão de aceitar os termos
    E Clicar no botão de registrar
    Então Verifica se o usuário esta logado "<verifica_Logado>"
