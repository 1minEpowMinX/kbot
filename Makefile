APP=$(shell basename $(shell git remote get-url origin))
REGISTRY=1minepowminx
VERSION=$(shell git describe --tags --abbrev=0)-$(shell git rev-parse --short HEAD)

TARGETOS=linux #linux, macOS, windows
TARGETARCH=amd64 #arm64 | shell dpkg --print-architecture

format:
	gofmt -s -w ./

lint:
	golint

test:
	go test -v

dependencies:
	go get

build: format dependencies
	CGO_ENABLED=0 GOOS=$(TARGETOS) GOARCH=$(TARGETARCH) go build -v -o kbot -ldflags "-X="github.com/1minepowminx/kbot/cmd.appVersion=$(VERSION)

image:
	docker build . -t ${REGISTRY}/${APP}:${VERSION}-${TARGETARCH}

push:
	docker push ${REGISTRY}/${APP}:${VERSION}-${TARGETARCH}

clean:
	rm -rf kbot
	docker rmi ${REGISTRY}/${APP}:${VERSION}-${TARGETARCH}