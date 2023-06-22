#!/usr/bin/env sh

# shellcheck disable=SC2034
BOSS_HOME=/devtools/WildFly/wildfly-preview-24.0.1.Final
USERNAME=AlexCompany
PASSWORD=Password01

# shellcheck disable=SC2086
# shellcheck disable=SC2153
$JBOSS_HOME/bin/add-user.sh -u $USERNAME -p $PASSWORD --silent