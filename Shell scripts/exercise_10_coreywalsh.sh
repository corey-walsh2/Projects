#!/bin/bash

MESSAGE="random number:$RANDOM"
echo "$MESSAGE"

logger -p user.info "$MESSAGE"
