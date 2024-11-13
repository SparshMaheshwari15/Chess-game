@echo off
REM Navigate to the directory where your Java files are located
REM cd /d "Y:\ChessGameProject\src"
cd /d %~dp0\src

REM Compile all Java files in the directory
javac *.java

REM Run the main GUI class
java ChessGameGUI
pause
