#!/bin/bash

function count_files()
{
  local FILE_COUNT=$(ls -l | wc -l)
  echo "$FILE_COUNT"
}

count_files
