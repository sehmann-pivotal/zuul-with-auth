#!/usr/bin/env bash
cd simpleApp && ./gradlew clean assemble && cf push
cd ../zuul && ./gradlew clean assemble && cf push
