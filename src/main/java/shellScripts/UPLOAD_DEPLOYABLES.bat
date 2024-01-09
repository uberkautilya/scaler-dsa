@echo off

set LocalWarFolder="Wars"
set LocalUWADataFolder="UWADataMEJ"
set S3BucketFolder="s3://uwa-uat/Term/"


set server_IP=%1
set tempRemoteDirectory="/home/app_user/temporary_uploads/"

set "psCommand=powershell -Command "$pword = read-host 'Enter Password' -AsSecureString ; ^
    $BSTR=[System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($pword); ^
        [System.Runtime.InteropServices.Marshal]::PtrToStringAuto($BSTR)""
for /f "usebackq delims=" %%p in (`%psCommand%`) do set password=%%p
set PASS=%password%

For /f "tokens=2-4 delims=/ " %%a in ('date /t') do (set mydate=%%c-%%a-%%b)
set mytime=%TIME%
CALL :TRIM %mytime% mytime
set curr_tm=%mydate%_%mytime%

echo "current DateTime : %curr_tm%"


echo "creating temp folder on server !!"
"C:\Program Files\PuTTY\plink.exe" %server_IP% -ssh -l app_user -pw %PASS% "mkdir -p %tempRemoteDirectory%%curr_tm% && mkdir -p %tempRemoteDirectory%%curr_tm%"

if exist "%LocalUWADataFolder%"\ (
echo "%LocalUWADataFolder% folder exists > copying DRL files to server !!"
"C:\Program Files\PuTTY\pscp.exe" -pw %PASS% -r "%LocalUWADataFolder%" app_user@%server_IP%:%tempRemoteDirectory%%curr_tm%

echo "copying DRL Files to S3 bucket !!"
"C:\Program Files\PuTTY\plink.exe" %server_IP% -ssh -l app_user -pw %PASS% "aws s3 cp %tempRemoteDirectory%%curr_tm%/%LocalUWADataFolder%/ %S3BucketFolder%%LocalUWADataFolder%/ --recursive"
)

if exist "%LocalWarFolder%"\ (
echo "%LocalWarFolder% folder exists > copying WAR files to server !!"
"C:\Program Files\PuTTY\pscp.exe" -pw %PASS% -r "%LocalWarFolder%" app_user@%server_IP%:%tempRemoteDirectory%%curr_tm%

echo "copying WAR Files to S3 bucket !!"
"C:\Program Files\PuTTY\plink.exe" %server_IP% -ssh -l app_user -pw %PASS% "aws s3 cp %tempRemoteDirectory%%curr_tm%/%LocalWarFolder%/ %S3BucketFolder%%LocalWarFolder%/ --recursive"
)

echo "deleting temp folder on server !!"
"C:\Program Files\PuTTY\plink.exe" %server_IP% -ssh -l app_user -pw %PASS% "rm -r %tempRemoteDirectory%"

GOTO :EOF

:TRIM
SET %2=%1
GOTO :EOF
