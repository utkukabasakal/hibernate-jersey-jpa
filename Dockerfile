FROM tomcat:9.0-alpine
LABEL maintainer="utkukabasakal58@gmail.com"
ADD target/orm.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]