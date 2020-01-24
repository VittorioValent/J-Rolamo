#!/bin/sh

cd frontend/

echo "[INFO] ----------- View-ttorio is creating a new Angular DTO Class -----------------"

ng g view-ttorio:dto --name=$1 --fields=$2 --force 

echo "------------------------------------------------------------------------------------\n"
echo "[INFO] ----------- View-ttorio is creating a new Angular Service -------------------"

ng g view-ttorio:service --name=$1 --force

echo "------------------------------------------------------------------------------------\n"
echo "[INFO] ----------- View-ttorio is creating a new Angular Table Component -----------"
ng g view-ttorio:table-component --name=$1 --force


echo "------------------------------------------------------------------------------------\n"


echo "[INFO] ----------- View-ttorio is Updating the main menu  --------------------------"
ng g view-ttorio:menu-update --name=$1 --force
echo " ------------------------------------------------------------------------------------\n"
