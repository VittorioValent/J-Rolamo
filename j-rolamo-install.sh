#!/bin/bash
# Author: Vittorio Valent
#

echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------- Starting  J-Rolamo Installation ------------------------"
echo "-----------------------------------------------------------------------------------"
echo

echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Downloading Repository ----------------------------"
echo "-----------------------------------------------------------------------------------"
echo

cd ~ 

git clone https://github.com/VittorioValent/J-Rolamo.git

git clone https://github.com/VittorioValent/j-rolamo-code-generator.git

cd J-Rolamo

git checkout $(git describe --tags $(git rev-list --tags --max-count=1))

cd ~/j-rolamo-code-generator

git checkout $(git describe --tags $(git rev-list --tags --max-count=1))

echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------- Installing Library -------------------------------"
echo "-----------------------------------------------------------------------------------"
echo

mvn install


echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Installing Archetype ------------------------------"
echo "-----------------------------------------------------------------------------------"
echo

cd ~/J-Rolamo

mvn install



echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Installing j-rolamo command -----------------------"
echo "-----------------------------------------------------------------------------------"
echo

chmod +x j-rolamo.sh

cp ./j-rolamo.sh ~/

cd ~ 

mkdir -p bin

mv -f ./j-rolamo.sh ./bin/

echo "alias j-rolamo='j-rolamo.sh'" >> .bashrc

echo 'export PATH="$PATH:$HOME/bin"' >> .bashrc

. ~/.bashrc

echo "[INFO] To start J-Rolamo type 'j-rolamo' in your workspace directory "
echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] -------------------- J-Rolamo Installation Completed -----------------------"
echo "-----------------------------------------------------------------------------------"
