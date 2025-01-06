#!/bin/bash
echo "Build weapontype"
mvn clean install -DskipTests
if [ $? -ne 0 ]; then
  echo "Build failed weapontype"
  exit 1
fi
echo "Weapontype success"