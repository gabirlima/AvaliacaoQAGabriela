# AvaliacaoQAGabriela

##Simulador de investimento

###Escopo
**História: Simulação de investimento em poupança**
- Testes funcionais automatizados
- Testes de serviço

###Estratégias
**Testes Integração e Sistema**<br/><br/>
Validar os elementos da funcionalidade de forma a verificar se alguma falha possa ocorrer durante a utilização
com as referentes entradas. Os testes são baseados no requisito informado, verificando se o sistema se comporta conforme
 suas especificações.<br/><br/>
**Testes de aceitação utilizando BDD**<br/><br/>
Com a utilização da linguagem Gherkin é possível validar o fluxo do usuário de forma auto explicativa,
simulando a utilização do sistema seguindo os passos descritos. 

##Ferramentas
**Funcionais e aceitação:**
- BDD com Cucumber
- Java / Gradle
- Selenium WebDriver

**Serviço:**
- Rest assurred
- JUnit 4

##Cenários mapeados:
1. Simular financiamento com sucesso
2. Tentar simular com valor inferior a R$ 20,00
3. Tentar simular sem preencher campos obrigatorios
4. Limpar formulario
5. Chamar serviço de simulação com sucesso

##Execução dos testes<br/><br/>

Para executar os testes na IDE:
- Aceitação: executar a feature SimularInvestimento.feature no diretorio test/resources/features
- API: executar o teste da classe SimuladorTests no diretorio test/java/apiTests

Para executar via linha de comando (é necessário possuir o Gradle instalado):
- Aceitação: gradle testesAceitacao
- API: gradle :cleanTest :test --tests "apiTests.SimuladorTests.chamarServicoSimuladorTest"
