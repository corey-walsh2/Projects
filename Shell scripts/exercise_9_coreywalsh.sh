#!/bin/bash

function count_files()
{
  local DIRECTORY=$1
  FILE_COUNT=$(ls $DIRECTORY|wc -l)
  
  echo "$DIRECTORY"
  echo "$FILE_COUNT"
}

count_files ~
count_files /var
count_files /usr/bin
