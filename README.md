# Angular Spring Heroes

[![Travis Build Status](https://travis-ci.org/porscheinformatik/angular-spring-heroes.svg?branch=master)](https://travis-ci.org/porscheinformatik/angular-spring-heroes)
[![license](https://img.shields.io/github/license/porscheinformatik/angular-spring-heroes.svg)](LICENSE)

This projects shows the integration of Angular with a Spring Boot backend.

## Build and Run

Run `mvn clean package` to build the project. The final application will be located under `heroes-webapp/target/heroes-webapp.jar`.
The application can be run via `java -jar heroes-webapp.jar`.

## Frontend

The frontend is written in Angular and built with [Angular CLI](https://github.com/angular/angular-cli).

### Running Frontend Build for Development

Run `npm run dev` in heroes-frontend for continuously building the app. Also run the backend to access the webapp (see below).

### Code Scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|module`.

### Running Frontend Unit Tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Backend

The backend is written in Spring Boot. The whole backend code is located under heroes-backend.

### Running Backend Server for Development

Run the main class `heroes.HeroesApplication` from your favorite IDE - please include the Spring Boot profile "dev". The application will be available via [`http://localhost:8080/`](http://localhost:8080/).

## Deployment to Kubernetes/OpenShift

The application can be deployed to [Kubernetes](https://kubernetes.io/) (or [OpenShift](https://www.openshift.org/)) via [Helm](https://helm.sh/).

Setup your cluster and [install Helm (and Tiller)](https://docs.helm.sh/using_helm/). Then you can install the Helm chart with (this uses H2 db):

    helm install charts/angular-spring-heroes

If you want to user PostgreSQL install with:

    helm install --set postgresql.enabled=true charts/angular-spring-heroes
