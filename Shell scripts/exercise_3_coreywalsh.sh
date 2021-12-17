#!/bin/bash
#prompt the user for a name of a file or directory

echo "Enter the file path"
read FILE

if [ -f "$FILE" ]
	then	
  		echo "$FILE is a regular file"

elif [ -d "$FILE" ]
 	then
  		echo "$FILE is a directory"

else
 	echo "$FILE is of another file type"
fi

ls -l $FILE
