FROM postgres:latest

ENV POSTGRES_DB atividade-dac
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY create.sql /docker-entrypoint-initdb.d/
