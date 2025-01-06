#!/bin/bash

build_project() {
  project=$1
  echo "Building project: $project"
  cd "$project" || { echo "Directory $project not found!"; exit 1; }
  chmod +x build.sh
  ./build.sh
  if [ $? -ne 0 ]; then
    echo "Build failed for project: $project"
    exit 1
  fi
  cd ..
}

# Build each project
build_project "Gateway"
build_project "Weapon"
build_project "WeaponType"
build_project "simple-rpg-ng"

echo "All projects built successfully."
