# Stage 1: 빌드 스테이지
FROM openjdk:17-jdk-slim AS builder

# 작업 디렉터리 설정
WORKDIR /app

# 소스 코드 및 Gradle 파일 모두 복사
COPY . .

# Gradle 빌드 실행 (테스트 제외)
RUN ./gradlew build -x test

#---
# Stage 2: 실행 스테이지
FROM openjdk:17-jdk-slim

# 작업 디렉터리 설정
WORKDIR /app

# 빌드 스테이지에서 생성된 JAR 파일 복사
# `builder` 스테이지의 `/app/build/libs` 경로에서 JAR 파일을 가져와 `app.jar`로 복사합니다.
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 실행을 위한 포트 노출
EXPOSE 8080

# 애플리케이션 실행 명령어와 인자들을 배열 형태로 직접 전달
# 이렇게 하면 모든 인자가 'java -jar app.jar'에 정확히 전달됩니다.
ENTRYPOINT ["java", "-jar", "app.jar", \
            "--spring.datasource.url=jdbc:mysql://next-db.c74828wmikhx.ap-northeast-2.rds.amazonaws.com:3306/next?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8", \
            "--spring.datasource.username=admin", \
            "--spring.datasource.password=17Rwi[Cu*G[9*lGuXoWP)MFdyyVA"]
