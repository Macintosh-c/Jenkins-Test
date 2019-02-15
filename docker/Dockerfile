FROM centos7/oraclejdk1.8

LABEL maintainer="barry <barry.cao@softtek.com>"

WORKDIR /demo-jenkins

ADD ./demo-jenkins.jar .

EXPOSE 8089

CMD nohup java -jar -Dspring.profiles.active=dev -Dserver.port=8089 -Dlogging.file=/var/log/demo-jenkins/demo.log ./demo-jenkins.jar





