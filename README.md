PROCESSO DE SELEÇÃO DE ESTAGIÁRIOS PLANNER SISTEMAS 
---

PLANNER SISTEMAS E UMA EMPRESA ESPECIALIZADA EM BI E SOFTWARE DE PLANEJAMENTO ORÇAMENTÁRIO, ATUAMOS EM GRANDES CORPORAÇÕES NOS MAIS VARIADOS SETORES COMO, PLANO DE SAÚDE, INDÚSTRIAS, SEGURANÇA, DISTRIBUIDORAS E ETC.

TEMOS A CREDIBILIDADE COMO UMA DAS PRINCIPAIS CARACTERÍSTICAS DOS NOSSOS SERVIÇOS. 

**TRABALHAMOS COM:**
*  PRÁTICAS ÁGEIS COM KANBAN / SCRUM
*  ESCALABILIDADE
*  JAVAEE - CDI - TOMCAT - JPA/HIBERNATE
*  SQL ANSI - SQL SERVER, ORACLE, MYSQL, POSTGRESQL
*  GIT
*  ENTRE OUTRAS TECNOLOGIAS

VENHA FAZER PARTE DA NOSSA EQUIPE E NOS AJUDAR A ESCREVER O FUTURO


COMO PARTICIPAR DA ESCOLHA DO ESTAGIÁRIO PLANNER
---

* FAÇA UM "FORK" DESSE PROJETO PARA SUA CONTA GITHUB.
* IMPLEMENTE O DESAFIO DESCRITO NO TÓPICO ABAIXO.
* FAÇA UM PUSH PARA SEU REPOSITÓRIO COM O DESAFIO IMPLEMENTADO.
* ENVIE UM EMAIL PARA RH@PLANNERSISTEMAS.COM.BR COM O ASSUNTO 'DESAFIO ESTAGIARIO PLANNER' E A URL DO SEU FORK.
* AGUARDE NOSSO CONTATO.


DESAFIO ESTAGIÁRIO PLANNER
---

**ROTINA DE PROMOÇÃO**

* SUA SOLUÇÃO DEVERÁ TER AS SEGUINTES TELAS:
  * CADASTRO DE CARGO
  * CADASTRO DE FUNCIONÁRIO
  * APLICAÇÃO DE PROMOÇÃO
  
OBS:TODAS AS TELAS DEVERÃO SEGUIR O PADRÃO MVC

**CADASTRO DE CARGO**

TERÁ APENAS OS CAMPOS DE CÓDIGO, DESCRIÇÃO E UM DATATABLE LISTANDO TUDO QUE JA FOI CADASTRADO, CRUD BÁSICO.

**CADASTRO DE FUNCIONÁRIO**

TELA ONDE O USUÁRIO PODERÁ CADASTRAR E ALTERAR OS REGISTROS DE UM FUNCIONÁRIOS, DEVERÁ TER UM *DATATABLE* LISTANDO TUDO QUE FOI CADASTRADO E OS SEGUINTES CAMPOS PARA *INPUT*:
*  NOME
*  MATRICULA
*  CARGO
*  SALÁRIO

**APLICAÇÃO DE PROMOÇÃO**

ESSA TELA DEVERÁ TER UM *LISTBOX* COM TODOS OS CARGOS CADASTRADOS, UM *INPUTTEXT* COM O *LABEL* 'PERCENTUAL DE AUMENTO' E UM BOTÃO CHAMADO 'CALCULAR', AO SELECIONAR UM CARGO NO *LISTBOX* O SISTEMA DEVERÁ POPULAR UM *DATATABLE* COM TODOS OS FUNCIONÁRIO CADASTRADOS COM O CARGO SELECIONADO, E AO CLICAR NO BOTÃO 'CALCULAR' O SISTEMA DEVE APLICAR O PERCENTUAL DIGITADO NO *INPUTTEXT* EM TODOS OS FUNCIONÁRIOS LISTADOS E ATUALIZAR O *DATATABLE* EXIBINDO O NOVO SALÁRIO.

**TECNOLOGIAS A SEREM UTILIZADAS**

* JAVAEE
* TOMCAT
* JPA/HIBERNATE COM BANCO HSQLDB
* CDI
* JSF COM PRIMEFACES

**DOCUMENTAÇÃO**

NO ARQUIVO README DO PROJETO EXPLIQUE O FUNCIONAMENTO E A ARQUITETURA DA SOLUÇÃO ADOTADA NA SUA IMPLEMENTAÇÃO. DESCREVA TAMBÉM OS PASSOS PARA EXECUTAR CORRETAMENTE SEU PROJETO.

**AVALIAÇÃO**

ENTRE OS CRITÉRIOS DE AVALIAÇÃO ESTÃO:

* CÓDIGO LIMPO E ORGANIZAÇÃO
* DOCUMENTAÇÃO DE CÓDIGO
* DOCUMENTAÇÃO DO PROJETO (README)
* BOAS PRÁTICAS DE DESENVOLVIMENTO


----------------------------------------------------------------------------------------------------------------------


-DOCUMENTAÇÃO

                                   -FUNCIONAMENTO-
Conforme implementação solicitada, foram criados os cruds de cadastro de cargo com os campos (codigo e descrição), cadastro de funcionário com os campos (matricula, nome, cargo e salário), com o relacionamento de muitos funcionários para um cargo(@ManyToOne). Em seguida foi implementada a rotina de promoção de funcionários com a fucionalidade de aumento de salário por cargo, o usuário seleciona o cargo para popular o *DATATABLE* com os funcionários do cargo selecionado, em seguida o usuário informa o percentual de aumento no *INPUTTEXT*, clica em calcular, logo após a rotina salva o novo salário com o devido aumento e mostra os valores atualizados no *DATATABLE*.

                                    -ARQUITETURA-
                            
-No pacote model foram criadas as entidades Cargo com as variáveis (codigo e descrição) e Funcionário com as variáveis (matricula,nome,cargo e salário).

-No pacote repository foram criados os repositorios cargos e funcionários, e injetado o entityManager para gerenciar as entidades criadas.

-No pacote service foram criadas as regras para cargo, funcionário e promoção de funcionário. O service promoção de funcionário recebe o percentual e o cargo, pelo metodo atualizarSalário, em seguida pega o cargo selecionado e retorna uma lista com os funcionários do respectivo cargo, pelo metodo buscarPorCargo do repository funcionarios, logo após foi criada uma estrutura de repetição para pegar os funcionários retornados na lista e então fazer os calculos (percentual / 100 multiplicado pelo salário atual) para pegar o percentual de aumento, depois foi somado(percentual + salário atual) e foi setado o novo salário dos funcionários.

-No pacote controller foram criados os beans para cadastros e pesquisas das respecitivas entidades criadas e o bean promoção de funcionário.

-Foram criadas as telas Cadastro de funcionários, Pesquisa de funcionários,Cadastro de cargo, Pesquisa de cargo e promoção de funcionários.

                                    -TECNOLOGIAS ULTILIZADAS- 
               
JAVAEE (PROGRAMAÇÃO)
TOMCAT (SERVIDOR)
JPA/HIBERNATE(PERSISTÊNCIA DE DADOS)
CDI(INJEÇÃO DE DEPENDÊNCIAS)
JSF COM PRIMEFACES(CAMADA DE VISÃO)
HSQLDB(BANCO DE DADOS)
               
                                
                            
  

