# language: pt

Funcionalidade: Cadastro de novo usuario.

Contexto: 
	Dado Que o usuario esteja na tela inicial com a intencao de realizar um cadastro
    Quando Ele clicar no link de login
    E Clicar no link de cadastrar

@TesteDeSucesso
Cenario: Teste de cadastro de novo usuario
    E Preencher o formulario de cadastro
    E Clicar na caixa de receber ofertas
    E Clicar no botao de aceitar os termos
    E Clicar no botao de registrar
    Entao Verifica se o usuario esta logado
  
@TesteDeFalha  
Cenario: Teste de cadastro com senhas divergentes
    E Preencher o formulario de cadastro com a confirmacao de senha diferente da senha
    E Clicar na caixa de receber ofertas novamente
    E Clicar no botao de aceitar os termos novamente
    E Clicar no botao de registrar novamente
    Entao O usuario nao pode efetuar o registro
    
  