#!/bin/bash

# compile
nxjc mainClass.java blinde.java window.java BLINDESTATE.java BluetoothCom.java 

# move the .class files to the folder with the package name
mkdir nxtblindes
mv *.class nxtblindes

# link
nxjlink -o main.nxj nxtblindes.mainClass

# upload
nxjupload -r main.nxj

# clean up
rm -r *.nxj nxtblindes