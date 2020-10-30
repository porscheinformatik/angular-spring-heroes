FROM cypress/base:12

COPY . /tmp/heroes-acceptence-tests/

WORKDIR /tmp/heroes-acceptence-tests

RUN CI=true npm ci

ENTRYPOINT [ "./node_modules/.bin/cypress", "run" ]
