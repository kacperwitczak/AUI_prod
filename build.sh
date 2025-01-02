function main() {
    cd ./simple-rpg-character/; sh ./build.sh; cd ..
    cd ./simple-rpg-profession/; sh ./build.sh; cd ..
    cd ./simple-rpg-user/; sh ./build.sh; cd ..
    cd ./simple-rpg-gateway/; sh ./build.sh; cd ..
    cd ./simple-rpg-ng/; sh ./build.sh; cd ..
    cd ./simple-rpg-js/; sh ./build.sh; cd ..
}

main "$@"
