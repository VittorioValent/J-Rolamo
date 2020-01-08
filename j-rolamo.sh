#!/bin/sh
# Author: Vittorio Valent
#
echo "Welcome to J-Rolamo! What is your project's name?"

echo -n "Project name: "

read projectname

echo -n "Do you want to run the project after installation? (y/N) " 

read run

echo "Creating a new Project with name "$projectname

mvn archetype:generate -B -DarchetypeGroupId=it.contrader -DarchetypeArtifactId=j-rolamo -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=it.target -Dpackage=it.target.$projectname -DartifactId=$projectname -Dversion=1.0-SNAPSHOT -Dname=$projectname

cd $projectname

echo "[INFO] Building "$projectname

mvn clean install

if [ $run = y ];
	then mvn spring-boot:run
else 
	echo "Project created succesfully, have fun!"
fi

