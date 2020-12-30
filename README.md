# Criando nossa API REST com Spring! 
**Autor:** Afonso Mateus Prado Pinheiro 
**Código fonte:** https://github.com/scriptzeiro
**Resultado em:** https://afonsomateus.com.br
 
## 1. O que é esse tal de Spring?
O [Spring](https://spring.io/) é um framework open source destinado ao desenvolvimento de aplicações em Java  com o objetivo de melhorar a produtividade agilizando a criação de aplicação corporativas. Ele fornece vários recursos e automatiza várias tarefas e configurações facilitando o desenvolvimento. Para realizar essas tarefas o Spring usa conceitos de **Injeção de dependência**,  Desenvolvimento baseado em Interfaces e [POJOs](https://pt.wikipedia.org/wiki/Plain_Old_Java_Objects) nos dando flexibilidade segurança além de um desenvolvimento com um código limpo, fácil de ser mantido.
## 2. Nosso objetivo
O objetivo deste post é explicar de maneira clara como é implantado uma API REST em Spring . Como seria feito a modelagem, quais tecnologias seriam utilizadas até a implementação de cada parte da aplicação.
### 2.1. Desafio a ser desenvolvido
Nossa empresa está desenvolvendo uma API para um banco e foi passo a nós a tarefa de desenvolver o fluxo de cadastro de dados pessoais de uma pessoa. Devolvendo a resposta com o *status code* correto para o caso de sucesso e também para os de erro caso os dados informados não corresponderem ao esperado. 
**Campos obrigatórios para a realização do cadastro:**
 -   Nome
 -   E-mail
 -   CPF
 -   Data de nascimento
## 3. Pensando na solução
Antes da escrita de qualquer código precisamos saber de maneira muito objetiva o que precisamos fazer, quais serão os requisitos do projeto, como iremos resolve-los, a arquitetura a ser utilizada e as regras de negócio do projeto.
### 3.1. Tecnologias que serão utilizadas
A escolha do ecossistema de tecnologias  que serão utilizadas na solução é uma tarefa super importante e delicada no desenvolvimento de sistemas. Como o título já indica, utilizaremos o Spring no desenvolvimento da nossa solução. Mas abaixo estarei listando as tecnologias que serão usadas e o objetivo de cada uma delas.

| Tecnologia | Para que será utilizada |
|--|--|
| Java |O [Java](https://www.w3schools.com/java/java_intro.asp) será adotado como a nossa linguagem de programação nesse projeto |
| Spring | Utilizaremos o [Spring Boot](https://spring.io/projects/spring-boot) para automatizar as configurações e também utilizaremos outros módulos do Spring como o [Spring MVC](https://spring.io/guides/gs/serving-web-content/) e o [Spring JPA](https://spring.io/projects/spring-data) para melhorar o nosso desenvolvimento. |
| Maven | Utilizaremos o [Maven](https://maven.apache.org/) como nosso gerenciador de dependências do projeto|
| Apache | O [Apache](https://maven.apache.org/install.html) juntamente com o Maven será utilizado para fazer o build do projeto. |
| PostgreSQL| O [PostgreSQL](https://www.postgresql.org/download/) será utilizado como o SGBD do banco de dados do nosso projeto|
| Git | O [Git](https://git-scm.com/downloads) é um um software utilizado no controle de versão dos códigos fontes utilizado nas principais empresas do mundo. Utilizaremos ele para mantermos um histórico do nosso código fonte |
| H2 Database| O [H2 Database](https://www.h2database.com/html/main.html) é um banco de dados embarcado cujo o funcionamento não necessita de instalação. Isso quer dizer que poderemos testar o nosso banco de dados apenas em memória.  |
| JUnit| O [JUnit](https://junit.org/junit5/) é um framework utilizado na realização de testes unitários em Java. Ele será utilizado para testarmos o endpoint da nossa aplicação.  |
| Swagger| Swagger é um framework que será utilizado na documentação do projeto. O Swagger permite que as anotações sejam feitas no código do projeto, dessa forma a documentação evolui junto com o projeto.|
| Postman| O [Postman](https://www.postman.com/) O Postman é uma ferramenta que nos permite fazer requisições HTTP com todos os verbos(GET, POST, PUT, DELETE, etc...). O Postman tem várias tecnologias que podem ser utilizadas no desenvolvimento de APIs, mas utilizaremos eles apenas para testar as requisições da nossa aplicação. |

### 3.2. Definindo nossas regras de negócio
#### 3.2.1. Quais serão as validações necessárias?
Já sabemos quais são os campos que nós temos que ter para cadastrar, mas quais são as validações necessárias para que nós possamos permitir que o cadastro seja realizado com sucesso? Vamos listar abaixo os campos e as regras associadas a eles:
| Campo | Regras de validação |
|--|--|
| Nome | Para poder |
| Email |  |
| CPF |  |
| Data de nascimento|  |


#### Como ficaria o diagrama UML?
Como podemos ver acima, todos os campos acima representam de características uma pessoa, que no nosso contexto é um **==cliente==** do banco. Com isso em mente podemos chegar a conclusão que o cliente é uma ==classe== do nosso projeto. Então o a representação da classe Cliente ficaria da seguinte forma:
![uml](https://user-images.githubusercontent.com/48936532/103358091-2fee7b80-4a8b-11eb-911c-98c4101093ec.jpg)
