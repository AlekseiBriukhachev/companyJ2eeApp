FROM jboss/wildfly
LABEL authors="abriukhachev"

COPY standalone.xml $JBOSS_HOME/standalone/configuration/
COPY application.xml $JBOSS_HOME/standalone/deployments/
COPY jboss-web.xml $JBOSS_HOME/standalone/deployments/
COPY companyJ2eeApp-1.0.ear $JBOSS_HOME/standalone/deployments/

EXPOSE 8080