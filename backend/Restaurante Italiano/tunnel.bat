@echo off
echo Iniciando túnel SSH para o MySQL da Oracle Cloud...

REM Nome da chave SSH que está na mesma pasta do .bat
set KEY_PATH=oracle-key.pem

REM Informações do túnel
set USER=ubuntu
set HOST=129.153.40.67
set LOCAL_PORT=3307
set REMOTE_HOST=10.0.0.159
set REMOTE_PORT=3306

REM Tente abrir o túnel
ssh -i "%~dp0%KEY_PATH%" -L %LOCAL_PORT%:%REMOTE_HOST%:%REMOTE_PORT% %USER%@%HOST% -N

REM Se fechar, espere o usuário ver o erro
echo.
echo O túnel SSH foi encerrado. Pressione qualquer tecla para fechar...
pause > nul
