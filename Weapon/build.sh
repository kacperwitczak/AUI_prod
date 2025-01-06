#!/bin/bash
echo "Build weapon"
mvn clean install -DskipTests
if [ $? -ne 0 ]; then
  echo "Build failed weapon"
  exit 1
fi
echo "Weapon success"