run-dist:
	./build/install/app/bin/app -h

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean installDist

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build-run: build run

.PHONY: build