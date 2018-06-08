#!/bin/sh

mkdir -p /tmp/dutstub/products/files
chmod +x /tmp/dutstub/products/files

cd source-code/
mvn test
