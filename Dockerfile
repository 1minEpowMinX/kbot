FROM golang:1.21.4 as builder

WORKDIR /go/src/app
COPY . .
RUN make dependencies
ARG TARGETARCH
RUN make build TARGETARCH=${TARGETARCH}

FROM scratch
WORKDIR /
COPY --from=builder /go/src/app/kbot .
COPY --from=alpine:latest /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/
ENTRYPOINT ["./kbot", "start"]