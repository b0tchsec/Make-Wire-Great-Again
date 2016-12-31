# Make Wire Great Again


## Features
- Disables all outgoing pings
- Disables all outgoing calls


## Getting Started

### Install precompiled APK
Copy or download the [latest apk](https://github.com/b0tchsec/Make-Wire-Great-Again/releases/download/0.1/MakeWireGreatAgain-XposedMod-v0.1.apk) to your Android phone.

Use your preferred Android filebrowser to navigate to the APK and install.

### Compile from source

There are multiple ways to import the project into Android Studio, but this seems to be the easiest.

- Clone this repo to the folder of your choice.
- Launch Android Studio, if you already have a project open, click `File -> Close Project`.
- At the main welcome wizard, click `Import project (Eclipse ADT, Gradle, ect.)` and navigate to the folder you cloned the repo to.
- To compile, go to `Build -> Make Project (Ctrl + F9)`
- To install and run on a connected Android phone, go to `Run -> Run 'app' (Shift + F10)`


## TODO
- Update UI to include buttons that allow the user to toggle features on/off
- Configure Travis-CI builds
- Disable incoming pings
- Disable incoming calls
- Allow the user to selectively block calls/pings for each conversation
- Instead of blocking pings/calls altogether, generate a pop-up asking for confirmation before sending the ping/call.


## License

    Make Wire Great Again

    Copyright (C) 2016 Aaron Gallagher <aaron.b.gallagher@gmail.com>
 
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
