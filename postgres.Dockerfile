FROM postgres:11.5-alpine
COPY docker/postgres/init.sql /docker-entrypoint-initdb.d/
