#!/bin/bash
echo "Build gateway"
mvn clean install -DskipTests
if [ $? -ne 0 ]; then
  echo "Build failed gateway"
  exit 1
fi
echo "gateway success"