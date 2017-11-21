#!/bin/bash

set -e

while [ -z $sample_number ]
do
  echo -n "Enter the sample number (1 to 8): "
  read -r sample_number
done

echo "This script will deploy a sample backend run the sample" . $sample_number . " scenario."
echo

while [ -z $CARBON_HOME ]
do
  echo -n "Enter location for CARBON_HOME: "
  read -r CARBON_HOME
done

ts_path=$CARBON_HOME/repository/resources/security/client-truststore.jks

while [ -z $use_default ]
do
  echo -n "Use Trust Store ${ts_path} (y/n): "
  read -r use_default
done

if [ $use_default != "y" ]; then
  unset ts_path
  while [ -z $ts_path ]
  do
    echo -n "Enter Client Trust Store Path: "
    read -r ts_path
  done
fi

cp $(pwd)/backend/sample-data-backend.war $CARBON_HOME/repository/deployment/server/webapps/

echo "Waiting for backend services to be deployed..."
sleep 15

echo "Running Sample"$sample_number"..."

jar_path="sample"$sample_number"/target/org.wso2.carbon.apimgt.samples.sample"$sample_number"-1.0.0-jar-with-dependencies.jar"

java -jar -Djavax.net.ssl.trustStore=$ts_path $jar_path
echo $'\e[1;32m'"DONE!"$'\e[0m'