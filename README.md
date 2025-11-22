Arthur Bueno de Oliveira - RM558396

João Vitor Carotta Ribeiro - RM555187

Victor Magdaleno Marcos - RM556729

--------------------------------------------------------------------------

Projeto LibrAI - Painel administrativo - Java

Referenciando o tema futuro do trabalho, a ideia do grupo foi criar um agente de inteligência artifical que transcrevesse a linguagem de sinais em texto em tempo real. 
Além de ser uma ideia inovadora, é uma ideia que permite pessoas surdas e mudas se sentirem inclusas no mercado de trabalho.
Para o desenvolvimento em Java, fizemos o painel administrativo do site, onde os ADM's terão os seguintes acessos:

- Usuários cadastrados na plataforma
- Trilhas realizadas
- Competências
- Sinais de usuários
- Inscrições de usuários nas trilhas

A versão do Java e Spring Boot usados foram: Java version - 23.0.1 Spring boot - v3.3.3

Para executar o projeto localmente:
1. Abra a pasta GS2 e localize a classe "GSApplication.java", Isso vai dar inicio ao Spring boot.
2. Abra a pasta GS2-Frontend, acesse o arquivo "index.html" e abra o mesmo no seu navegador de preferência.
3. Faça login ou cadastre-se na plataforma, depois aproveite os recursos disponíveis.

O banco está configurado para receber 6 tabelas diferentes, sendo elas:

1. Usuários
2. Trilha_Competencia
3. Trilhas
4. Sinais
5. Inscrições
6. Competências

O banco de dados utilizado foi o banco relacional H2 em nuvem. Para acessálo, entre na url a seguir assim que o Spring boot estiver rodando.

Link da url do banco de dados: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:file:./data/demo-db
- User Name: sa
- Password: deixe em branco

  A porta está direcionada para a padrão, sendo ela http://localhost:8080

  lista de endpoints do projeto:

| Método | Endpoint  | Descrição                                                                           |
| ------ | --------- | ----------------------------------------------------------------------------------- |
| POST   | `/signup` | Registrar um novo usuário. Recebe um JSON com os dados do usuário.                  |
| POST   | `/login`  | Autenticar um usuário. Recebe email e senha no JSON e retorna o usuário se correto. |                                            
| ------ | -------------------- | ------------------------------------------------------ |
| GET    | `/competencias`      | Lista todas as competências.                           |
| GET    | `/competencias/{id}` | Busca uma competência pelo ID.                         |
| POST   | `/competencias`      | Cria uma nova competência. Recebe JSON da competência. |
| PUT    | `/competencias/{id}` | Atualiza uma competência existente pelo ID.            |
| DELETE | `/competencias/{id}` | Deleta uma competência pelo ID.                        |                                              
| ------ | --------------------------------------------------- | ---------------------------------------------------------- |
| GET    | `/inscricoes`                                       | Lista todas as inscrições.                                 |
| POST   | `/inscricoes/usuario/{usuarioId}/trilha/{trilhaId}` | Cria uma inscrição de um usuário em uma trilha específica. |
| DELETE | `/inscricoes/{id}`                                  | Deleta uma inscrição pelo ID.                              |
| ------ | -------------- | ----------------------------------------- |
| GET    | `/sinais`      | Lista todos os sinais.                    |
| GET    | `/sinais/{id}` | Busca um sinal pelo ID.                   |
| POST   | `/sinais`      | Cria um novo sinal. Recebe JSON do sinal. |
| PUT    | `/sinais/{id}` | Atualiza um sinal existente pelo ID.      |
| DELETE | `/sinais/{id}` | Deleta um sinal pelo ID.                  |
| ------ | --------------- | -------------------------------------------- |
| GET    | `/trilhas`      | Lista todas as trilhas de aprendizagem.      |
| GET    | `/trilhas/{id}` | Busca uma trilha pelo ID.                    |
| POST   | `/trilhas`      | Cria uma nova trilha. Recebe JSON da trilha. |
| PUT    | `/trilhas/{id}` | Atualiza uma trilha existente pelo ID.       |
| DELETE | `/trilhas/{id}` | Deleta uma trilha pelo ID.                   |
| ------ | ---------------- | --------------------------------------------- |
| GET    | `/usuarios`      | Lista todos os usuários.                      |
| GET    | `/usuarios/{id}` | Busca um usuário pelo ID.                     |
| POST   | `/usuarios`      | Cria um novo usuário. Recebe JSON do usuário. |
| PUT    | `/usuarios/{id}` | Atualiza um usuário existente pelo ID.        |
| DELETE | `/usuarios/{id}` | Deleta um usuário pelo ID.                    |

Exemplo de uso do JSON:

{
  "nome": "João Vitor",
  "email": "joao.vitor@example.com",
  "senha": "teste12345"
}

Link do projeto contendo a IA (atualmente a IA ainda não funciona em celulares, apenas computador, estamos trabalhando na implementação): https://libraai.onrender.com/
  

