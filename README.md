<br />
<div align="center">
  <img src="https://github.com/justbadreboot/E-commerce-Administrator/blob/Master/public/images/logo-template.png?raw=true" alt="Logo" >
  <br/>
  <h1 align="center">Kruger Med BackEnd</h1>

![Spring Badge](https://img.shields.io/badge/SpringBoot-20232A?style=for-the-badge&logo=spring&logoColor=green)
![Security Badge](https://img.shields.io/badge/SpringSecurity-20232A?style=for-the-badge&logo=springsecurity&logoColor=green)
![Swagger Badge](https://img.shields.io/badge/Swagger-20232A?style=for-the-badge&logo=swagger&logoColor=#68b618)
![Hibernate Badge](https://img.shields.io/badge/Hibernate-20232A?style=for-the-badge&logo=hibernate&logoColor=yellow)
![MYSQL Badge](https://img.shields.io/badge/MySQL-20232A?style=for-the-badge&logo=mysql&logoColor=orange)
![AlwaysData Badge](https://img.shields.io/badge/Alwaysdata-20232A?style=for-the-badge&logo=alwaysdata&logoColor=pink)
![Railway Badge](https://img.shields.io/badge/Railway-20232A?style=for-the-badge&logo=railway&logoColor=white)

  <p align="center">
    Encuentra los mejores productos farmacéuticos del mercado en un solo lugar!
  
  </p>

</div>

<!-- TABLE OF CONTENTS -->

<br/>
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#-about-the-project">About The Project</a>
      <ul>
        <li><a href="#🔨-built-with">Built with</a></li>
      </ul>
    </li>
    <li>
      <a href="#🤸-getting-started">Getting Started</a>
      <ul>
        <li><a href="#💾-run-locally">Run Locally</a></li>
      </ul>
    </li>
    <li><a href="#⏩-usage">Usage</a></li>
    <li><a href="#📜-license">License</a></li>
    <li><a href="#📫-contact-&-acknowledgments">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

<hr/>


#  🌟 About This Project


Esta aplicación está enfocada en el desarrollo de la logica del negocio y de endpoints destinado al consumo.

Existen 3 roles definidos: ADMINISTRADOR, CLIENTE Y REPARTIDOR

Para la implementación de este proyecto se ha empleado la siguiente arquitectura:

![ProjectArchitecture2 0](https://user-images.githubusercontent.com/80604082/219834772-a94dfd72-6bf2-4328-9e4c-968c9ec7db07.jpg)


### What are the features of this project?

- Desarrollo de microservicios independientes con endpoints de tipo GET, POST, PUT y DELETE adapatados al modelo de negocio.
- Validaciones de campos ingresados
- Auditoria mediante JPAAuditing
- Log Aggregation para ver el ciclo de vida una petición.
- Seguridad basada en tokens con Spring Security mediante un servidor de autenticación. 
- Descubrimiento de servicios mediante Eureka
- Configuración centralizada mediante Config Server
- Api Gateway para redirección de peticiones a través de la misma
- CircuitBreaker para manejo de errores.
- CQRS para separación de lógica entre query & commands.
- DatabasePerService, base de datos para cada microservicio (postgres & mysql)
- Decomposition inherente a microservicios aplicando arquitectura distribuida.
- Métricas mediante prometheus y grafana.


#  🔨 Built with

- ![Spring Badge](https://img.shields.io/badge/SpringBoot-20232A?style=for-the-badge&logo=spring&logoColor=green)
- ![Security Badge](https://img.shields.io/badge/SpringSecurity-20232A?style=for-the-badge&logo=springsecurity&logoColor=green)
- ![Swagger Badge](https://img.shields.io/badge/Swagger-20232A?style=for-the-badge&logo=swagger&logoColor=#68b618)
- ![Hibernate Badge](https://img.shields.io/badge/Hibernate-20232A?style=for-the-badge&logo=hibernate&logoColor=yellow)
- ![MYSQL Badge](https://img.shields.io/badge/MySQL-20232A?style=for-the-badge&logo=mysql&logoColor=orange)
- ![AlwaysData Badge](https://img.shields.io/badge/Alwaysdata-20232A?style=for-the-badge&logo=alwaysdata&logoColor=pink)
- ![Railway Badge](https://img.shields.io/badge/Railway-20232A?style=for-the-badge&logo=railway&logoColor=white)
- [Spring Cloud](https://www.springcloud.io/)
- [Eureka Server](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
- [Config Server](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)
- [Jwt Spring Boot](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)
- [Gateway](https://cloud.spring.io/spring-cloud-gateway/reference/html/)


<!-- GETTING STARTED -->

# 🤸 Getting Started

Es necesario tener Git y Maven instalado en tu computadora antes de correr este proyecto 👀
<br/>

## 💾 Run It Locally

<br/>
Clonar el repositorio

```bash
  git clone https://github.com/justbadreboot/E-commerce-Backend.git
```

Ir al directorio del proyecto

```bash
  cd my-project
```

Instalar todas las dependencias

```bash
  mvn install
```

Al ser microservicios se debe iniciar cada proyecto individualmente en un ID de desarrollo

Por defecto la aplicación se ejecutará en tu navegador en http://localhost:8080 o en el puerto establecido en el config server


## 🧪 Running Tests

Para ejecutar las pruebas de la aplicación, utilizar el siguiente comando

```bash
  mvn test
```

<!-- USAGE EXAMPLES -->

# ⏩ Usage (Endpoints)

## 👀 Públicos

Cualquier persona puede consumir estos endpoints mediante el gateway, se los reconoce por el path "public".


## 👨‍⚕️ Cliente

Estos endpoint son de consumo mediante token de usuario con rol CLIENTE a través del gateway y contienen el path "cliente".

## 👨‍⚕️ Administrador

Estos endpoint son de consumo mediante token de usuario con rol ADMINISTRADOR a través del gateway y contienen el path "admin".

## 🚚 Repartidor

Estos endpoint son de consumo mediante token de usuario con rol REPARTIDOR a través del gateway y contienen el path "repartidor".


<!-- ROADMAP -->

# 💻 Live Demo

  Puedes revisar el deploy de cada uno de los microservicos mediante los siguentes enlaces que se dirigen a su documentación en swagger:
  - [Landing microservice](https://landing-production-11fd.up.railway.app/swagger-ui/index.html)
  - [Product microservice](https://product-production-cf12.up.railway.app/swagger-ui/index.html)
  - [Order microservice](https://order-production-bfbc.up.railway.app/swagger-ui/index.html)
  - [Client microservice](https://client-production-d410.up.railway.app/swagger-ui/index.html)
  - [Service microservice](https://service-production-bb52.up.railway.app/swagger-ui/index.html)
  - [Invoice microservice](https://invoice-production-ea9a.up.railway.app/swagger-ui/index.html)

  Los servidores se encuentran desplegados en los siguentes enlaces
  - [Discovery Server](https://discovery-server-production.up.railway.app) 
  - [Config Server](https://config-server-production-3c6d.up.railway.app)
  - [Auth Service](https://authserve-production.up.railway.app)
  - [Gateway](https://api-gateway-production-d841.up.railway.app)


<!-- LICENSE -->

# 📜 License

Kruger Med está distribuida bajo los terminos de Apache License Version 2.0. La version completa de la licencia esta disponible en el archivo [LICENSE](LICENSE) de este repositorio. Cualquier contribucion a este proyecto sera licenciada bajo la licencia Apache License Version 2.0.

<!-- CONTACT -->

# 📫 Contact & Acknowledgments

<table>
  <tbody>
  <tr>
      <td>
      <div>
<img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/66704761?v=4" width="100px;" alt="photo author"/>

<sub><b>Bryan Quisaguano</b></sub>
<br />

[![linkedin][linkedin.js]][linkedin3-url] [![github][github.js]][github3-url]
</div>
      </td>
      <td>
      <div>
<img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/80604082?v=4" width="100px;" alt="photo author"/>

<sub><b>Jonathan Sánchez</b></sub>
<br />

[![linkedin][linkedin.js]][linkedin4-url] [![github][github.js]][github4-url]
      </div>
      </td>
  </tr>
    <tr>
      <td>
      <div>
          <img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/52048016?v=4" width="100px;" alt="photo author"/>

<sub><b>Daniela Cisneros</b></sub>
<br />

[![linkedin][linkedin.js]][linkedin-url] [![github][github.js]][github-url]
</div>
      </td>
      <td>
      <div>
<img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/82623546?v=4" width="100px;" alt="photo author"/>

<sub><b>Adrian Bastidas</b></sub>
<br />

[![linkedin][linkedin.js]][linkedin2-url] [![github][github.js]][github2-url]
</div>
      </td>
    </tr>
  <div>    
    <tr>
      <td>
      <div>
    <a href="https://github.com/Juanse7793">
      <img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/96317674?v=4" width="100px;" alt="Juan Sebastian Sotomayor"/>
      <br />
      <sub><b>Juan Sebastian Sotomayor</b></sub>
    </a>
    <br />
    <p>FrontEnd Kruger Mentor</p>
  </div>
      </td>
      <td><div>
      <a href="https://github.com/jaimepsayago">
        <img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/27781106?v=4" width="100px;" alt="Jaime Sayago Heredia"/>
        <br />
        <sub><b>Jaime Sayago Heredia</b></sub>
      </a>
      <br />
      <p>BackEnd Kruger Mentor</p>
  </div></td>
    </tr>
  </tbody>
</table>



[linkedin.js]: https://img.shields.io/badge/-LinkedIn-1C82AD?logo=LinkedIn
[linkedin-url]: https://www.linkedin.com/in/daniela-cisneros
[linkedin2-url]: https://www.linkedin.com/search/results/all/?heroEntityKey=urn%3Ali%3Afsd_profile%3AACoAAC7ePl0BFj6WkCWQGsQqwEgPGrrp8Kzpe7s&keywords=adrian%20rafael%20bastidas%20moya&origin=RICH_QUERY_SUGGESTION&position=0&searchId=a944fdbf-5a03-4a71-8a32-11a700849fc3&sid=b%40k
[linkedin3-url]: https://www.linkedin.com/in/bryan-quisaguano
[linkedin4-url]:https://www.linkedin.com/in/jsnchezlucas/
[github.js]: https://img.shields.io/badge/-GitHub-181717?logo=GitHub
[github-url]: https://github.com/DaniCis
[github2-url]: https://github.com/Adrian-Bastidas
[github3-url]: https://github.com/BryanArmando
[github4-url]: https://github.com/jonato96

[usage-screenshot]: /src/assets/img/main.gif
[client-screenshot]: /src/assets/img/carrito.gif
