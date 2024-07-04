#!/bin/bash

set -e

cd `dirname $0`
r=`pwd`
echo $r

# Product Service
echo "Starting Product Service..."
cd $r/product-service
mvn -q clean spring-boot:run &

# Order Service
echo "Starting Order Service..."
cd $r/order-service
mvn -q clean spring-boot:run &

# Inventory Service
echo "Starting Inventory Service..."
cd $r/inventory-service
mvn -q clean spring-boot:run &

# Discovery Server
echo "Starting Discovery Server..."
cd $r/discovery-server
mvn -q clean spring-boot:run &

# API Gateway
echo "Starting API Gateway..."
cd $r/api-gateway
mvn -q clean spring-boot:run &
