#!/bin/bash
# Author: Vittorio Valent
#

echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ---------------------- Starting  J-Rolamo Update ---------------------------"
echo "-----------------------------------------------------------------------------------"
echo

cd ~

cd J-Rolamo

git pull origin master
git fetch
git checkout $(git describe --tags $(git rev-list --tags --max-count=1))

cd ~/j-rolamo-code-generator

git pull origin master
git fetch
git checkout $(git describe --tags $(git rev-list --tags --max-count=1))


cd ~/j-rolamo-generics

git pull origin master
git fetch
git checkout $(git describe --tags $(git rev-list --tags --max-count=1))

echo "-----------------------------------------------------------------------------------"
echo "[INFO] -------------------------- Updating Libraries --------------------------------"
echo "-----------------------------------------------------------------------------------"
echo

mvn install


cd ~/j-rolamo-code-generator

mvn clean install

echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------- Updating Archetype -------------------------------"
echo "-----------------------------------------------------------------------------------"
echo

cd ~/J-Rolamo

mvn install

chmod +x j-rolamo.sh

cp ./j-rolamo.sh ~/

cd ~

mkdir -p bin

mv -f ./j-rolamo.sh ./bin/

echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ----------------------- J-Rolamo Update Completed --------------------------"
echo "-----------------------------------------------------------------------------------"

