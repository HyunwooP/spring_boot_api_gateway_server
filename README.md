# Spring Boot - Gateway Server (API)

## React Client + React Admin + Gateway Server + API Server + Style Server

![Architecture](https://user-images.githubusercontent.com/20429356/158008003-23315066-bca4-402c-af4e-10d81a886ec7.png)

## Client Repository

https://github.com/awakelife93/react-boilerplate

## Admin Repository

https://github.com/awakelife93/react-admin-boilerplate

## API Server Repository

https://github.com/awakelife93/express-boilerplate

## Style Server Repository

https://github.com/awakelife93/express-design-system-boilerplate

## [Note]

## [Description]

1. [install lombok error case](https://github.com/GabrielBB/vscode-lombok/issues/23)
2. Basically, the api token check proceeds.
3. Inspect the endpoint and associate it with the corresponding server's host.
   (If not applicable, the request is not made to each server.)
4. By using a circuit breaker, failure is prevented.
5. By using a rate limiter, Limit up to 500 requests per 10 seconds to control traffic per api
6. If you run jvm as a docker container, do docker build & run.

## Author
```
2020.07.05 =>
Author: Hyunwoo.Park
```
