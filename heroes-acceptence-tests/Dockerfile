FROM cypress/base:16

COPY . /tmp/heroes-acceptence-tests/

WORKDIR /tmp/heroes-acceptence-tests

RUN CI=true npm install

ENTRYPOINT [ "./node_modules/.bin/cypress", "run" ]
