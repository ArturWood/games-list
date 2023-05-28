<img src="https://github.com/ArturWood/games-list/assets/111249818/434c56b3-9dc9-412a-91f7-2edc3f389c14" width=300px alt="Java Logo" />
<img src="https://github.com/ArturWood/games-list/assets/111249818/d8539fd2-938e-4126-b3d4-7236a1ffdbef" width=500px alt="SpringFramework Logo" />

# Games List - Aplicação Java para Lista de Jogos

### Projeto back-end desenvolvido utilizando Java 17 com Spring Framework

API REST que utiliza padrão DTO em camadas

![DTO](https://github.com/ArturWood/games-list/assets/111249818/7642602a-0f60-413f-b8ab-640571d81081)

Para realizar buscas em banco de dados local H2 e retornar um JSON

![Postman](https://github.com/ArturWood/games-list/assets/111249818/fdff80eb-abe3-45b2-b8bf-0d53f36b3770)
![H2BD](https://github.com/ArturWood/games-list/assets/111249818/638dca5f-e1d4-460c-8779-1ab42d35594e)

## Pré-requisitos

- Java Development Kit (JDK) versão 17
- IDE Java (como Eclipse ou IntelliJ) ou um editor de texto para escrever o código
- Fazer download das depencias e plugins utilizando maven
- Postman (opcional, para testar os endpoints localmente)

## Como executar o projeto

### Back-end
Pré-requisitos: Java JDK 17

```bash
# clonar repositório
git clone https://github.com/ArturWood/games-list.git

# entrar na pasta do projeto
cd games-list

# executar o projeto
./mvnw spring-boot:run
```

## Endpoints

A aplicação expõe os seguintes endpoints:

- `GET /games`: Retorna todos os jogos do seed inserido no H2.
- `GET /games/{id}`: Retorna um jogo específico com base no ID.
- `GET /lists`: Retorna todas as lista criadas.
- `GET /lists/{id}/games`: Retorna todos os jogos que pertencem a uma lista.
- `POST /lists/{id}/update`: Atualiza a posição de um jogo dentro da lista.

## Estrutura do Projeto

O projeto possui a seguinte estrutura de arquivos:

```bash
├───src                                          
│   ├───main                                     
│   │   ├───java                                 
│   │   │   └───com                              
│   │   │       └───dev
│   │   │           └───gameslist
│   │   │               ├───controllers
│   │   │               ├───dto
│   │   │               ├───entities
│   │   │               ├───projections
│   │   │               ├───repositories
│   │   │               └───services
│   │   └───resources
│   │       ├───static
│   │       └───templates
└── .gitignore
└── Games.postman_collection.json
```

- O pacote `src.main.resources` contém o arquivo `application.properties` que configura o ambiente da aplicação, e a configuração do banco de dados no `application-test.properties`.
- O pacote `com.dev.gameslist.controllers` contém as classes que definem os endpoints da API.
- O pacote `com.dev.gameslist.model` contém as classes que representam um objeto jogo ou lista.
- O pacote `com.exemplo.repository` contém as interfaces que definem operações de acesso a dados para as entidades.
- A classe `GameslistApplication.java` é a classe principal que inicia a aplicação.
- Na source do projeto temos o arquivo `.gitignore` que especifica os arquivos e pastas que devem ser ignorados pelo controle de versão do Git e `Games.postman_collection.json` para consulta e exemplos de retornos na API.

## Documentação

No projeto foi utilizado o H2 database para desenvolvimento local e Spring Boot;<br>
Segue links para uso e documentação:

https://github.com/h2database/h2database<br>
https://spring.io/projects/spring-data-jpa<br>
https://docs.spring.io/spring-boot/docs/current/reference/html/web.html
