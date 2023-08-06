#!/bin/bash
docker run \
--detach \
--name exploring-spring \
--network host \
--rm \
--volume /etc/timezone:/etc/timezone:ro \
--volume /etc/localtime:/etc/localtime:ro \
--volume /home/ubuntu/.git-credentials:/home/ubuntu/.git-credentials:ro \
--volume /home/ubuntu/.gitconfig:/home/ubuntu/.gitconfig:ro \
--volume /home/ubuntu/vscode/exploring-spring:/home/ubuntu/vscode/exploring-spring:rw \
--volume /home/ubuntu/vscode/exploring-reactjs/app/build:/home/ubuntu/vscode/exploring-spring/src/main/resources/public:ro \
java-dev:10MAY2023 tail -f /dev/null