#language: pt
Funcionalidade: Simular Investimento na Poupanca
  Com o proposito de Simular um Investimento na Poupanca
  como um Associado,
  eu gostaria de preencher o formulario de simulacao
  e ver a tabela de resultado com Mes e Valor

  Cenario: Simular investimento com sucesso
    Dado que acessei a tela de simulacao de investimento
    Quando preencher o campo do valor aplicacao com "100000"
    E preencher o campo do valor do investimento mensal com "10000"
    E preencher o campo de tempo de investimento com "5"
    E selecionar o valor "mensal" no combo periodo
    E clicar no botao Simular
    Entao devo acessar a tela de resultado
    E o valor do resultado sera "1.519"
