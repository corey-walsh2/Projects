#Write a script to check if /home/cs.scranton.edu/walshc30/myscript.sh exists
if [ -e /home/cs.scranton.edu/walshc30/myscript.sh ]
then 
	echo "file_path indeed exists"
else
	echo "file_path does not exist"
fi

if [ -w /home/cs.scranton.edu/walshc30/myscript.sh ]
then
	echo "You have permissions to edit \"file_path\""
else
	echo " you do NOT have permissions to edit \"file_path\""
fi

