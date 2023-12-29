#!/bin/bash
set -e 
set -x
docker build --network host --build-arg UID=$(id -u $(whoami)) --build-arg GID=$(id -g $(whoami)) -t java-dev:10MAY2023 .