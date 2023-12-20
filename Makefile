APP=$(shell basename $(shell git remote get-url origin))
REGISTRY=1minepowminx
VERSION=$(shell git describe --tags --abbrev=0)-$(shell git rev-parse --short HEAD)
TARGETOS=linux
TARGETARCH=arm64

format:
	gofmt -s -w ./

lint:
	golint

test:
	go test -v

dependencies:
	go get
	go mod download

build: format dependencies
	CGO_ENABLED=0 GOOS=${TARGETOS} GOARCH=${shell dpkg --print-architecture} go build -v -o kbot -ldflags "-X="github.com/1minepowminx/kbot/cmd.appVersion=${VERSION}

image:
	docker build . -t ${REGISTRY}/${APP}:${VERSION}-${TARGETARCH}

push:
	docker push ${REGISTRY}/${APP}:${VERSION}-${TARGETARCH}

clean:
	rm -rf kbot