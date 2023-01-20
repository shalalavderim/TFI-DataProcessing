#!/bin/bash

#This script deploys the succesfully tested and compiled TFI-DataProcessor to Databricks Jobs on Azure.

#Configure databricks CLI
export DATABRICKS_HOST=https://adb-1952563685381701.1.azuredatabricks.net/
export DATABRICKS_TOKEN=$conntoken
export LC_ALL=C.UTF-8
export LANG=C.UTF-8

#Copy Jar and configs to databricks tmp
./scripts/databricksrun.sh fs rm -r dbfs:/tmp/jars/tfi-dataprocessor
./scripts/databricksrun.sh fs cp --overwrite target/scala-*/tfi-dataprocessor*.jar dbfs:/tmp/jars/tfi-dataprocessor/tfi-dataprocessor.jar
./scripts/databricksrun.sh fs cp --overwrite conf/TFI-DataProcessor.conf dbfs:/mnt/raw-data/ConfigFiles/TFI-DataProcessor.conf

#Update existing job or create new job for SKParser in Q
DataProcessorName="job-processor-tfi"
DataProcessorId=$(./scripts/databricksrun.sh jobs list | grep "$DataProcessorName" | cut -d " " -f1)
DataProcessorSize=${#DataProcessorId}
if [ $DataProcessorSize -ge 1 ]
then
      ./scripts/databricksrun.sh jobs reset --job-id $DataProcessorId --json-file scripts/DataProcessor.json
else
      ./scripts/databricksrun.sh jobs create --json-file scripts/DataProcessor.json
fi
echo "Successfully deployed new version of TFI-DataProcessor"