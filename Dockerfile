FROM ubuntu:22.04
ARG UID
ARG GID
RUN addgroup --gid $GID ubuntu \
&& adduser --disabled-password --gecos "" --gid $GID --uid $UID ubuntu \
&& apt update \
&& apt install -y vim dnsutils openssl curl wget tree \
&& apt install -y git openjdk-17-jdk maven \
&& wget --output-document /tmp/gradle-8.1.1-bin.zip https://services.gradle.org/distributions/gradle-8.1.1-bin.zip \
&& mkdir -p /opt/gradle \
&& unzip -d /opt/gradle /tmp/gradle-8.1.1-bin.zip \
&& ln -s /opt/gradle/gradle-8.1.1/bin/gradle /usr/bin/gradle \
&& mkdir -p /home/ubuntu/vscode/exploring-spring
USER ubuntu:ubuntu
WORKDIR /home/ubuntu/vscode/exploring-spring
