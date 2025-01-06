#!/bin/bash
echo "Build spa"
npm install --force
npm run build --force


if [ $? -ne 0 ]; then
  echo "Build failed spa"
  exit 1
fi
echo "spa success"