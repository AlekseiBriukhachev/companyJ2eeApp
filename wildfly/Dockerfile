FROM jboss/wildfly
LABEL authors="abriukhachev"

COPY standalone.xml $JBOSS_HOME/standalone/configuration/
COPY application.xml $JBOSS_HOME/standalone/deployments/
COPY jboss-deployment-structure.xml $JBOSS_HOME/standalone/deployments/
COPY my-ear-application.ear $JBOSS_HOME/standalone/deployments/

EXPOSE 8080