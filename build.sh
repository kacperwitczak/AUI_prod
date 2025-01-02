#!/bin/bash

main() {
    cd ./WeaponType/; sh ./build.sh; cd ..
    cd ./Weapon/; sh ./build.sh; cd ..
    cd ./Gateway/; sh ./build.sh; cd ..
    cd ./simple-rpg-ng/; sh ./build.sh; cd ..
}

main "$@"
