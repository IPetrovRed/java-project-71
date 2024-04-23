### Hexlet tests and linter status:
[![Actions Status](https://github.com/IPetrovRed/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/IPetrovRed/java-project-71/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/f0b119d65be7227da559/maintainability)](https://codeclimate.com/github/IPetrovRed/java-project-71/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/f0b119d65be7227da559/test_coverage)](https://codeclimate.com/github/IPetrovRed/java-project-71/test_coverage) [![Java CI](https://github.com/IPetrovRed/java-project-71/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/IPetrovRed/java-project-71/actions/workflows/main.yml)

### Проект "Вычислитель отличий" 
"Вычислитель отличий" – программа, определяющая разницу между двумя структурами данных.

# Возможности:
* Поддерживает различные форматы файлов: yaml and json
* Настраиваемый отчет о сравнении в формате plain text, stylish и json.

## Вызов справочной информации:
```
./build/install/app/bin/app -h
```
## Запуск и выбор формата сравнения
```
./build/install/app/bin/app filepath1.json filepath2.json

./build/install/app/bin/app -f format filepath1.json filepath2.json
```

## Пример работы программы

[![asciicast](https://asciinema.org/a/4BjVsnodbwDLGfXg3aVQoY5se.png)](https://asciinema.org/a/4BjVsnodbwDLGfXg3aVQoY5se)

# Java package

# Run
```bash
make run
```

## Setup
```bash
make build
```

## Run-dist
```bash
make run-dist
```

## Run test
```bash
make test
```

## Run report
```bash
make report
```

## Run checkstyle
```bash
make lint
```

## Check update dependencies and plugins
```bash
make check-deps
```
