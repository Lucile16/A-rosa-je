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
FROM tonyctalope/arosaje as server