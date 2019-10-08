#language: pt
Funcionalidade: Simular Investimento na Poupanca
  Com o proposito de Simular um Investimento na Poupanca
  como um Associado,
  eu gostaria de preencher o formulario de simulacao
  e ver a tabela de resultado com Mes e Valor

  Esquema do Cenario: Simular investimento com sucesso
    Dado que acessei a tela de simulacao de investimento
    Quando selecionar o radio "<Pessoa>"
    E preencher o campo do valor aplicacao com "<valorAp>"
    E preencher o campo do valor do investimento mensal com "<valorMensal>"
    E preencher o campo de tempo de investimento com "<Tempo>"
    E selecionar o valor "<Periodo>" no combo periodo
    E clicar no botao Simular
    Entao devo acessar a tela de resultado
    E o valor do resultado sera "<Resultado>"

    Exemplos:
    |Pessoa|valorAp|valorMensal|Tempo|Periodo|Resultado|
    |PF    |100000 |10000      |5    |Meses  |R$ 1.519 |
    |PF    |50000  |10000      |12   |Meses  |R$ 1.740 |
    |PJ    |155500 |50000      |2    |Anos   |R$ 14.122|

  Cenario: Tentar simular com valor inferior a R$ 20,00
    Dado que acessei a tela de simulacao de investimento
    Quando preencher o campo do valor aplicacao com "1999"
    E preencher o campo do valor do investimento mensal com "1999"
    Entao devo visualizar hint de valor minimo no campo do valor da aplicacao
    E devo visualizar hint de valor minimo no campo do valor do investimento mensal

  Cenario: Tentar simular sem preencher campos obrigatorios
    Dado que acessei a tela de simulacao de investimento
    Quando clicar no botao Simular
    Entao devo visualizar hint de valor minimo no campo do valor da aplicacao
    E devo visualizar hint de valor minimo no campo do valor do investimento mensal
    E devo visualizar o hint de valor obrigatorio no campo de tempo de investimento

  Cenario: Limpar formulario
    Dado que acessei a tela de simulacao de investimento
    Quando preencher o campo do valor aplicacao com "100000"
    E preencher o campo do valor do investimento mensal com "10000"
    E preencher o campo de tempo de investimento com "5"
    E selecionar o valor "Anos" no combo periodo
    E selecionar o botao Limpar Formulario
    Entao todos os campos devem estar limpos