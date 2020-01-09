#!/bin/sh
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

LINE='export PATH=$PATH":$HOME/bin"'
FILE='.profile'
grep -qF "$LINE" "$FILE" || echo "$LINE" >> "$FILE"


grep -q grep ~/.bashrc alias\ j-rolamo 
if [ $? -eq 1 ]; then
echo " alias j-rolamo='. ~/bin/j-rolamo.sh' " >> ~/.bashrc
fi

. ~/.profile

echo "[INFO] To start J-Rolamo type 'j-rolamo' in your workspace directory "
echo
echo "-----------------------------------------------------------------------------------"
echo "[INFO] ------------------------ Installation Completed ----------------------------"
echo "-----------------------------------------------------------------------------------"






