@echo off
setlocal enabledelayedexpansion
chcp 65001 >nul

:: Get user input
set /p number= Problem ID (e.g. d123):
set /p title= Enter problem title (can contain spaces):

:: Combine main folder name
set "mainFolder=%number%. %title%"

:: Check if main folder exists
if not exist "%mainFolder%" (
    echo [Create] Main folder: %mainFolder%
    mkdir "%mainFolder%"
) else (
    echo [Exists] Main folder already exists: %mainFolder%
)

:: Create subfolders
call :CreateSubFolder "C"
call :CreateSubFolder "CPP"
call :CreateSubFolder "Java"
call :CreateSubFolder "Python"

:: Create README.md (if not exists)
set "readmePath=%mainFolder%\README.md"
set "readmeContent=%number%. [click here to view question](https://zerojudge.tw/ShowProblem?problemid=%number%^)"
if not exist "!readmePath!" (
    echo %readmeContent% > "!readmePath!"
    echo [Create] README.md...
) else (
    echo [Exists] README.md already exists.
)

echo [Sys] All tasks completed.
pause
exit /b

:: Function: Create subfolder
:CreateSubFolder
set "subFolder=%~1"
if not exist "%mainFolder%\!subFolder!" (
    echo [Create] Subfolder: !subFolder!
    mkdir "%mainFolder%\!subFolder!"
) else (
    echo [Exists] Subfolder already exists: !subFolder!
)
exit /b
