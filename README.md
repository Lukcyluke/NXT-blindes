# TODO
1. build api
2. programm http server
3. run with https://www.npmjs.com/package/homebridge-minimal-http-blinds
4. use [HAP-Java](https://github.com/hap-java/HAP-Java)

# Installing the tool chain

## MacOS

To compile and flash the software to your NXT 2.0 Brick [leJos](http://www.lejos.org) is needed.
Watch the following video until 12:24 and follow the steps.

[Video](https://youtu.be/smNl7-HUvfA "YouTube: install lejos on nxt by Green Connector")

The steps are:

1. <a name="1"></a> **Download and install Java 6** from [https://support.apple.com/kb/DL1572?locale=de_DE](https://support.apple.com/kb/DL1572?locale=de_DE "Apple: Download Java for OS X 2017-001").
<br/>
Notice that your java virtual machine isn't installed in the location mentioned in the video.
It is installed at

   ```
   /Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
   ```

   To determine the location run (see https://stackoverflow.com/a/26507569)

   ``` bash
   /usr/libexec/java_home -V
   ```

2. <a name="2"></a> **Download and install leJOS** from [https://sourceforge.net/projects/lejos/files/lejos-NXJ/](https://sourceforge.net/projects/lejos/files/lejos-NXJ/ "sourceforge: leJOS").
Choose the latest version.

* Unpack the `tar.gz`
* Move the folder to some suitable directory (home for instance).

    ``` bash
    mv ~/Downloads/leJOS_NXJ_* ~/leJOS_NXJ
    ```
* Set the environment variables. You can use the commands from [this](http://www.lejos.org/nxt/nxj/tutorial/Preliminaries/GettingStartedMac.htm#10) page. But make sure to use the paths from [1.](#1) and [2.](#2)

    ``` bash
    export NXJ_HOME="~/leJOS_NXJ"
    export LEJOS_NXT_JAVA_HOME="/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home"
    export PATH="$NXJ_HOME/bin:$PATH"
    ```
3. <a name="3"></a> Install the drivers for the brick.
Download the drivers from [https://www.lego.com/de-de/mindstorms/downloads](https://www.lego.com/r/www/r/mindstorms/-/media/franchises/mindstorms%202014/downloads/firmware%20and%20software/nxt%20software/nxt%20fantom%20drivers%20v120.zip?l.r2=-964392510) and install them.

Now you should be able to build and flash when running the [build.sh](./build.sh).

## Linux and Windows

Sorry, I don't have information about that.
