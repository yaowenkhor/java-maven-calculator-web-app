FROM tomcat:9.0
MAINTAINER Ma Ping

RUN rm -rf $CATALINA_HOME/webapps/ROOT
COPY target/ROOT.war $CATALINA_HOME/webapps/ROOT.war

EXPOSE 8080