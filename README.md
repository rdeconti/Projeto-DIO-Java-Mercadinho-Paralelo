:spiral_calendar: Atualizado em 15 de Junho de 2021 :heart:

<img align="right" alt="GIF" height="160px" src="https://github.com/rdeconti/rdeconti-resources/blob/main/Digital%20Innovation%20One%20-%20Logotipo.png" />

# Projeto Digital Innovation One Java - Bootcamp Avanade Code Anywhere
Este projeto foi proposto durante o bootcamp Code Anywhere
- Link do bootcamp: https://web.digitalinnovation.one/track/code-anywhere
- Link do código original: https://github.com/danubiadona/Avanade-DIO-CodeAnywhere
- Link do projeto original: https://github.com/danubiadona/Avanade-DIO-CodeAnywhere/projects/1

# Proposta de projeto inicial
Nesse desafio você deve desenvolver e entregar um projeto de controle de estoque de produtos seguindo os cards definidos

# Proposta de projeto final
Vamos tentar aplicar os conhecimentos de hoje para expandir o nosso projeto do Mercadinho?
1) Faça um fork do projeto em: danubiadona/Avanade-DIO-CodeAnywhere: CODE ANYWHERE – MENTORIA #4 | Projetos Ágeis com Scrum (github.com)
2) Adicione as classes necessárias para criar um carrinho, adicionando os produtos e os dados do cliente para entrega (USE OS CONCEITOS DE DDD!!!).
3) Persista os dados no banco
4) envie o código para darmos uma olhada!  

# Projeto desenvolvido: Mercadinho Paralelo Versão 1

## Link do projeto: https://github.com/users/rdeconti/projects/3

## Descrição:
A aplicação controla alguns processos de um mercadinho e tem as seguintes funcionalidades:
- Controla as compras e fornecedores;
- Controla as vendas e clientes;
- Controla os estoques e a sua movimentação;
- Vende os produtos pela Internet (pedidos criados pelos clientes)
- Vende os produtos pelo telefone (pedidos criados pelos atendentes)
- Controla o acesso dos usuários de acordo com a função do usuário. 

## Características técnicas:
- Aplicação monolítica
- DDD (data driven domain)
- Linguagem Java
- Lombok
- Sonarqube
- Banco de dados: MySql (utilizado inicialmente o SQL Server que foi trocado, pois estava travando)
- API RestFul
- API documentada com Swagger  
- Spring MVC
- Spring security role based access
- Hibernate+JPA  
- Thymeleaf 

## Link Swagger UI
- http://localhost:8080/swagger-ui/
- 

## Melhorias futuras:
- A versão 2 será uma aplicação que utilizará micro serviços.

## Modelo de banco de dados:
- MySql script para criação BD 'groceryStore': https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo/blob/main/sql/GroceryStoreMySql.sql
- Tabelas:
  Carrinho de compras: CARTS e CARTS_ITEMS;
  Ordens de venda: SALES e SALES_ITEMS;
  Ordens de compra: PURCHASES e PURCHASES_ITEMS;
  Movimento de estoque: MOVEMENTS;
  Estoque: STOCKS;
  Lojas: STORES;
  Produtos: PRODUCTS;
  Clientes: CUSTOMERS;
  Fornecedores: VENDORS;
  Empregados: EMPLOYEES;
  Usuários: USERS;
  Contatos: CONTACTS (são os endereços das lojas, clientes, fornecedores e usuários);
  Imagens: IMAGES (são as fotos dos produtos armazenadas no Github e acessadas por URL para realizar os testes);
- Diagrama: https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo/blob/main/sql/model.pdf



