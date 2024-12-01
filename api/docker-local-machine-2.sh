../gradlew :api:stage
docker build -t lexurgy-services-local .
docker run -it -p 8082:8080 \
  -e API_KEY='exampleApiKey' \
  -e SINGLE_STEP_TIMEOUT=1 \
  -e REQUEST_TIMEOUT=5 \
  -e TOTAL_TIMEOUT=60 \
  -e FLY_MACHINE_ID='b2b2b2' \
  lexurgy-services-local
