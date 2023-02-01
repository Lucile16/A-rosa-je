################################################
###                 CLIENT                   ###
################################################
FROM node:19-alpine3.16 as client

WORKDIR /home/node

COPY ./client .

RUN npm install

################################################
###                 SERVER                   ###
################################################
FROM maven:3.8.7-openjdk-18-slim as server

RUN mkdir /usr/src/server

ENV workdir=/usr/src/server
WORKDIR ${workdir}

COPY ./server .

COPY ./entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
ENTRYPOINT [ "/entrypoint.sh" ]