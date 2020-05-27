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

cd J-Rolamo

git checkout $(git describe --tags $(git rev-list --tags --max-count=1))

echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Installing Archetype ------------------------------"
echo "-----------------------------------------------------------------------------------"
echo

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

echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ----------------- Starting  View-ttorio Installation -----------------------"
echo "-----------------------------------------------------------------------------------"
echo

cd ~ 

git clone https://github.com/VittorioValent/View-ttorio.git

cd View-ttorio

npm install

echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------ View-ttorio Installation Completed ----------------------"
echo "-----------------------------------------------------------------------------------"
