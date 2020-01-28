# projeto-bdd
Projeto desenvolvido com o objetivo de testar conhecimentos em relação a desenvolvimento de testes de automação em BDD com Cucumber.

Conteúdo e descrições do projeto:

projeto-bdd

  - src/main/java (pasta onde estão as classes e pacotes)

    - br.com.rsinet.hub_bdd.pageFactory (pacote onde foram criadas as classes de manipulação de elementos por pagina.)
      - CadastroPage.java (classe responsável por executar os elementos localizados na página de cadastro.)
      - HomePage.java (classe responsável por executar os elementos localizados na página inicial.)
      - PagamentoPage.java (classe responsável por executar os elementos localizados na página de pagamento dos produtos.)
      - PesquisaPage.java (classe responsável por executar os elementos localizados na página de pesquisa de produtos.)
    
    - br.com.rsinet.hub_bdd.stepDefinitions (pacote onde foram criadas as classes para executar os cenários descritos nas features.)
      - Cadastro.java (classe responsável por testar os cenários descritos na feature de cadastro.)
      - ConsultaPorBarraDePesquisa.java (classe responsável por testar os cenários descritos na feature de consulta por barra de pesquisa.)
      - ConsultaPorCategoria.java (classe responsável por testar os cenários descritos na feature de consulta de produto por categoria na tela inicial.)
      
    - br.com.rsinet.hub_bdd.testData (pacote onde está o arquivo responsável por armazenar a massa de dados.)
      - MassaDeDados.xlsx (arquivo de massa de dados.)
      
    - br.com.rsinet.hub_bdd.testRunner (pacote onde está a classe responsável por executar todos os testes de uma vez.)
      - TestRunner.java (classe responsável por executar todos os cenários das features aplicando funcionalidades do cucumber e gerando o extend report no final.)
    
    - br.com.rsinet.hub_bdd.utils (pacote onde estão classes com algumas utilidades do projeto.)
      - Constantes.java (classe responsável por localizar a coluna de cada elemento utilizado nos testes dentro do arquivo de massa de dados.)
      - DriverFactory.java (classe que contém métodos responsáveis por iniciar e fechar o browser dos testes.)
      - ExcelUtils.java (classe responsável por fazer a comunicação dos testes com o arquivo de massa de dados.)
      - PegaMassa.java (classe responsável por pegar dados do arquivo de massa e retornar na classe de teste.)
      - Prints.java (classe que contem métodos responsáveis por tirar prints dos cenários de teste.)
  
  - configs
    - extension-config.xml (arquivo responsável por executar o extendreport e suas configurações.)
    
  - Features (pasta onde estão localizados os arquivos de feature onde são escritos os stories dos usuários para o desenvolvimento dos cenários.)
    - Cadastro.feature
    - ConsultaPorBarraDePesquisa.feature
    - ConsultaPorCategoria.feature
  
  - target
    - cucumber-reports
      - Reports.html (arquivo gerado depois da execução dos testes que demonstra um relatório do comportamento de cada teste.)
      
    - falhas (pasta onde são guardados os prints de testes de falha.)
    - sucessos (pasta onde são guardados os prints de testes de sucesso.)
    
  - pom.xml (arquivo onde são declaradas as dependencias do maven.)
