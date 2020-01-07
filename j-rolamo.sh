
echo "Welcome to J-Rolamo, please enter your project name"

read -p "Project Name: " projectname

echo [INFO] Creating New Project with name $projectname

mvn archetype:generate -DarchetypeGroupId=it.contrader -DarchetypeArtifactId=j-rolamo -DoutputDirectory= $projectname
