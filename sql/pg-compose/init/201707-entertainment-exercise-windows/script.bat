cls
@echo off
echo Hello!
echo This is an automatic installation program for the postgresql sql training.
echo.
echo Start the installation.
echo.
echo Starting installation.
echo.
psql -U scott -d entertainment -a -f script-win.sql
echo.
echo installation Complete.
