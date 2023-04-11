### supermercado-api
A aplicação supermercado-api é uma API Restful criada com base no Ecossistema do J2E, e contém como principais módulos o Jersey, EJB, CDI e Hibernate.

A aplicação foi projetada com base na Arquitetura em Camadas, onde os principais componentes são:

- Recursos (Resources) para receber requisições HTTP em endpoints publicamente expostos, trafegando objetos JSON;
- Serviços (Services) para validações de negócio e controle de transação;
- DAOS para realizar a persistência dos dados;

Todas estas camadas estão sendo injetadas pelo framework via Injeção de Dependência.

A camada de persistência faz uso do Gerenciador de Entidades (Entity Manager) e se comunica com o banco de dados, bem como JPQL para realizar consultas customizadas, por exemplo, para trazer uma lista de produtos com algum caractere contido no nome do produto.

Todos os endpoints foram mapeados no modelo de maturidade RESTful baseado em recursos e identificados via verbo HTTP.

A aplicação foi servida com Wildfly, usando banco de dados MySQL.

Tecnologias usadas:
- Java 11+
- Hibernate
- MySQL
- RESTful
- JSON
- WildFly/JBoss
- CDI
- EJB
- Postman
- Git
