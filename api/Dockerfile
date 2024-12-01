FROM openjdk:11
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/install/api/bin /app/bin
COPY ./build/install/api/lib /app/lib
ENTRYPOINT export AFFINITY_HEADERS="fly-force-instance-id:${FLY_MACHINE_ID}"; app/bin/api
