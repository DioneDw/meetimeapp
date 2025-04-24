<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="images/meetime.png" alt="Logo" width="80" height="80">
<h1 align="center" id="tituloprojeto">Case Técnico - Integração com HubSpot</h1>
  <p align="center">
    Projeto de teste técnico API REST em JAVA + integração com plataforma Hubspot.
</div>

## :mag_right: Sobre o desafio
O projeto consiste na realização de um desafio técnico para vaga desenvolvedor back-end Java. O desafio consiste em desenvolver uma aplicação em linguagem de programação Java que seja capaz de integrar com a API do Hubspot, realizando requisição de autenticação, autorização utilizando OAuth 2.0 (authorization code flow), consumo do recurso com criação de contato e webhook para monitoração do evento.

Requisitos principais do desafio:
* Geração da Authorization URL.
* Processamento do Callback OAuth.
* Criação de Contatos.
* Recebimento de Webhook para Criação de Contatos.

## :gear: Tecnologias/Ferramentas usadas
Abaixo temos todas as tecnologias/ferramentas utilizadas durante o desenvolvimento da aplicação.
* [![Java][Java-badge]][Java-url]
* [![Spring Boot][SpringBoot-badge]][SpringBoot-url]
* [![SpringDoc][SpringDoc-badge]][SpringDoc-url]
* [![Maven][Maven-badge]][Maven-url]
* [![Postman][Postman-badge]][Postman-url]
* [![Ngrok][Ngrok-bagde]][Ngrok-url]



<p align="right">(<a href="#tituloprojeto">voltar ao topo</a>)</p>

## Sobre o Projeto

A aplicação foi desenvolvida em Java 21, utilizando o framework Spring Boot 3.4.4 e o gerenciador de dependências Maven. Para testes das requisições HTTP, foi utilizada a ferramenta gratuita Postman. Durante o desenvolvimento, o Ngrok foi utilizado para expor a API local para a internet, facilitando testes com serviços externos.
A documentação da API foi construída com Swagger, permitindo a visualização e teste dos endpoints de maneira interativa.


<img src="images/estrutura.png" align="center" width="350" height="550"/>

A estrutura da aplicação foi planejada para permitir a comunicação eficiente entre o cliente e a API do HubSpot, com o fluxo de autenticação e integração descrito abaixo:

* O cliente inicia o processo ao enviar uma requisição para o endpoint de autorização (/auth).
* A aplicação redireciona essa requisição para a plataforma HubSpot, com os dados necessários para autenticação.
* O cliente realiza o login na HubSpot e escolhe uma conta (de teste).
* O HubSpot retorna um código de autorização para a aplicação.
* A aplicação consome esse código e faz automaticamente a requisição por um token de acesso.
* Após a obtenção do token, o cliente pode realizar requisições autenticadas, como a criação de um novo contato (por exemplo, via Postman).
* A aplicação monitora o evento de criação de contato e registra as interações em uma lista para fins de controle e visualização.


### :gear: Utilizando
O primeiro passo é realizar a **Requisição de autenticação ao Hubspot**, para isso basta acessar o endereço abaixo no rota /auth.
   ```bash

   ```

**Observação importante**: A velocidade da aplicação em *cloud* pode variar conforme a plataforma Render, tendo um delay pequeno para a primeira consulta e seguindo normalmente para as demais.
   ```bash
   
   ```
Para testar os endpoints, você pode utilizar o Postman com os métodos HTTP definidos na documentação.

<p align="right">(<a href="#tituloprojeto">voltar ao topo</a>)</p>




## :computer: Como iniciar o projeto
### :wrench: Pré-requisitos
Antes de rodar o projeto, é necessário ter as seguintes ferramentas instaladas:
* [Git](https://git-scm.com/downloads) (Verifique com: git --version)
* [Java](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) (Verifique com: java -version)
* [Maven](https://maven.apache.org/install.html) (Verifique com: mvn -v)
* [Postman](https://www.postman.com/downloads/) (testar a API)

### :package: Instalação
1. **Clone o repositório**:
   ```bash
   git clone https://github.com/DioneDw/meetimeapp.git

2. **Acesse o diretório do projeto**
   ```bash
   cd meetime
3. **Instale as dependências:**
    ```bash
   mvn install
4. **Rodar o projeto localmente: Para rodar a aplicação localmente, você pode executar o comando:**
   ```bash
   mvn spring-boot:run



## :email: Contato
Linkedin: https://www.linkedin.com/in/dione-evangelista/

GitHub: https://github.com/DioneDw
<p align="right">(<a href="#tituloprojeto">voltar ao topo</a>)</p>



[Java-badge]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/

[SpringBoot-badge]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[SpringBoot-url]: https://spring.io/projects/spring-boot

[SpringDoc-badge]: https://img.shields.io/badge/SpringDoc-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[SpringDoc-url]: https://springdoc.org/

[Maven-badge]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[Maven-url]: https://maven.apache.org/

[Postman-badge]: https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white
[Postman-url]: https://www.postman.com/

[Ngrok-bagde]: https://img.shields.io/badge/Ngrok-1F1F1F?style=for-the-badge&logo=ngrok&logoColor=white
[Ngrok-url]: https://ngrok.com/
