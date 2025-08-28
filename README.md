### DSList — API de Catálogo de Jogos

Aplicação desenvolvida durante o Intensivão de Java e Spring do professor Nélio Alves (DevSuperior). O projeto implementa uma API REST para consulta de jogos e listas de jogos, utilizando boas práticas de camadas (entities → repositories → services → controllers) e DTOs para transporte de dados.

## Tecnologias
- **Java 21**
- **Spring Boot 3.5** (Web, Spring Data JPA)
- **H2 Database** (perfil de teste)
- **PostgreSQL** (opcional em produção)
- **Maven**

## Arquitetura e organização
- `entities`: modelos do domínio (`Game`, `GameList`, `Belonging`)
- `repositories`: acesso a dados com Spring Data JPA
- `services`: regras de negócio e transações
- `controllers`: endpoints REST
- `dto`: objetos de transferência (`GameDTO`, `GameMinDTO`, `GameListDTO`)
- `projections`: consultas otimizadas para listagens

Estrutura principal:
```
src/main/java/com/devsuperior/dslist_peu/
  ├── controllers/
  ├── dto/
  ├── entities/
  ├── projections/
  ├── repositories/
  └── services/
src/main/resources/
  ├── application.properties
  ├── application-test.properties
  └── import.sql
```

## Como executar
Pré-requisitos: Java 21 instalado. Maven wrapper incluído (`mvnw` / `mvnw.cmd`).

1) Executar no perfil de teste (H2 em memória):
```bash
# Windows (cmd)
set APP_PROFILE=test && mvnw.cmd spring-boot:run

# Windows (PowerShell)
$env:APP_PROFILE="test"; ./mvnw.cmd spring-boot:run

# Git Bash / WSL / Linux / macOS
APP_PROFILE=test ./mvnw spring-boot:run
```

2) Acessar H2 Console (opcional):
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa` | Password: vazio

3) Popular a base: o arquivo `src/main/resources/import.sql` é executado automaticamente ao iniciar no perfil de teste.

4) Build do JAR:
```bash
# Sem rodar testes
./mvnw -DskipTests package

# Rodando testes
./mvnw test
```

## Configurações
- `spring.profiles.active` é lido de `APP_PROFILE` (por padrão: `test`).
- CORS configurado via `CORS_ORIGINS` (padrão: `http://localhost:5173,http://localhost:3000`).

## Endpoints principais
- `GET /games`: lista de jogos (mínima)
- `GET /games/{id}`: detalhes de um jogo
- `GET /lists`: lista as listas de jogos
- `GET /lists/{listId}/games`: jogos pertencentes a uma lista

## Banco de dados
- Perfil `test`: H2 em memória, console habilitado em `/h2-console`.
- Perfil para produção: configure PostgreSQL via variáveis/`application-*.properties` e utilize o driver incluído no `pom.xml`.

## Notas do curso
Projeto construído acompanhando o Intensivão de Java e Spring do **Nélio Alves (DevSuperior)**, reforçando conceitos como:
- Mapeamento JPA (relacionamentos e chave composta com `Belonging`/`BelongingPK`)
- Projeções para consultas específicas
- Padrão de camadas com serviços transacionais e DTOs
- Boas práticas de CORS e profiles

## Licença
Uso educacional. Ajuste conforme a necessidade do seu repositório.


