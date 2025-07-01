#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

DIR="$(cd "$(dirname "$0")" && pwd)"
exec "$DIR"/gradle/wrapper/gradle-wrapper.jar "$@"
- name: Grant execute permission for gradlew
  run: chmod +x gradlew
