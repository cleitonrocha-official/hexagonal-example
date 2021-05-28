# README

Prefira ler o README.md em um leitor online como https://dillinger.io/ ou no git do github

### 8 COISAS LEGAIS QUE TEM NESSE PROJETO JAVA 

##### 1 - Arquitetura Hexagonal
A aplicação foi criada com arquitetura hexagonal, ou seja a base é port e adapters, com essa arquitetura ganha-se um melhor desacomplamento, dividindo entre camadas de entrada de dados (inbound), camada de centralização negocio (core),camada de saida de dados ou de busca de dados (outbound), assima divisão das responsabilidades ficam bem distintas.

##### 2 - Mappers para preservar as camadas
Para que objetos DTOs de outras camadas não se tornem invasores, foi trabalhado com mappers, esses caras vão fazer um proteção das camadas auxiliando no DE_PARA e organizando o codigo.

##### 3 - PUT atualiza registro completo PACTH pode atualizar fragmentos de um registro
Conforme as boas praticas de rest, o metodo HTTP put atualiza um registro por completo, já o Patch ele atualiza parcialmente os fragmentos desse registro, assim foi criado um metod PACTH, que trabalha conforme as boas praticas HTTP

##### 4 - BO (Bussines Object) Centralização da regra de negócio
Muitas vezes temos dificuldade de fazer os verdadeiros testes unitários pois não centralizamos as regras de negócios em classes especificas para isso, independente de injeção de alguma dependência, já usando o padrão de BO, temos um cara responsavel para os testes altamente testavel.

##### 5 - PRODUTIVIDADE (Lombok,devtools,mapperstruct)
Para gerar produtividade , foi acrescentado algumas dependências bem útil para o dia a dia, lombok, mapperstruct e devtools, uma configuração fina foi criada para que as injeções de dependências não precise do autowired deixando por conta do lombok, o mapperstruct também foi bem configurado para usar o modelo de componente spring e não precisar ficar cirando factories.

##### 6 - DESACOPLAMENTO DE EXCEÇÕES
Demonstração do conceito de desacoplamento de exceções, assim uma exceção de regra de negócio não será colocado htto status code ou qualquer coisa que a acople a um contexto rest, ficando um core com exceções distinta da sua tecnologia de entrada e de saída.

##### 7 - DOCUMENTAÇÃO COM SWAGGER
Está configurado um Swagger ui bem simples na url http://localhost:8080/stoom/swagger-ui.html, assim fica mais fácil interagir com a api.

##### 8 - TESTS INTEGRADOS E UNITARIOS
Falado um pouco acima mas agora com ênfase nos testes , tem uma demonstração simples de dois tipos de testes, um integrado, que testa de ponta a ponta o fluxo do sistema, e um exemplo de teste unitário onde pega-se um BO no caso o BO do core e testa ali algumas das regras determinadas na classe





