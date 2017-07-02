# Angular Spring Heroes

This projects shows the integration of Angular with a Spring Boot backend.

## Build

Run `mvn clean package` to build the project. The final application will be located under `heroes-webapp/target/heroes-webapp.jar`.
The application can be run via `java -jar heroes-webapp.jar`.

## Frontend 

The frontend is written in Angular and built with [Angular CLI](https://github.com/angular/angular-cli).

### Development server

Run `npm start` in heroes-frontend for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files. This server proxies calls to `/api` to the backend server `http://localhost:4200/`.

### Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|module`.

### Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Backend

The backend is written in Spring Boot. The whole backend code is located under heroes-backend.

### Development server

Run the main class `heroes.HeroesApplication` from your favourite IDE. The application will be available via `http://localhost:8080/`
