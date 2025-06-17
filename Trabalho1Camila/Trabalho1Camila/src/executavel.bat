@echo off
title Sistema de Cursos - Java

:: === CONFIGURAÇÕES ===
set MYSQL_JAR=mysql-connector-j-8.0.33.jar
set SQLSERVER_JAR=mssql-jdbc-12.4.2.jre11.jar

echo Compilando arquivos .java...
javac -cp ".;%MYSQL_JAR%;%SQLSERVER_JAR%" *.java

if errorlevel 1 (
    echo Erro ao compilar os arquivos Java.
    pause
    exit /b
)

echo.
echo Iniciando o sistema...
java -cp ".;%MYSQL_JAR%;%SQLSERVER_JAR%" Main

echo.
pause
