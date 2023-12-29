@echo off

REM Change to the directory where your code is located
cd "C:\Users\alokd\OneDrive\Desktop\MicroServices Practice"

REM Add all changes to the staging area
git add .

REM Commit the changes with a default commit message
git commit -m "Update code"

REM Push the changes to the default remote repository (origin) and current branch
git push -u origin main

echo Code has been added, committed, and pushed to GitHub.
pause
