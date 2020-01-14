#!/bin/bash
# Author: Vittorio Valent
#

echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Starting Installation -----------------------------"
echo "-----------------------------------------------------------------------------------"
echo

echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Downloading Repository ----------------------------"
echo "-----------------------------------------------------------------------------------"
echo

cd ~ 

git clone https://github.com/VittorioValent/J-Rolamo.git

cd J-Rolamo

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

FILE=".profile"
if [ ! -f "$FILE" ]
then
LINE='export PATH=$PATH:$HOME/bin'
grep -qF "$LINE" "$FILE" || echo "$LINE" >> "$FILE"
source .profile
fi

FILE=".bash_profile"
if [ ! -f "$FILE" ]
then
LINE='export PATH=$PATH:$HOME/bin'
grep -qF "$LINE" "$FILE" || echo "$LINE" >> "$FILE"
source .bash_profile
fi

echo " alias j-rolamo='j-rolamo.sh" >> .bashrc

echo "[INFO] To start J-Rolamo type 'j-rolamo' in your workspace directory "
echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Installation Completed ----------------------------"
echo "-----------------------------------------------------------------------------------"






