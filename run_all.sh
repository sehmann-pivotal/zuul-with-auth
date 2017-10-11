cd zuul && SPRING_PROFILES_ACTIVE=local ./gradlew clean bootrun &
cd simpleApp && SPRING_PROFILES_ACTIVE=local ./gradlew clean bootrun &
