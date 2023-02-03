#!/bin/bash

cd "${workdir}" || exit

mvn clean package

java -jar target/server-0.0.1-SNAPSHOT.jar