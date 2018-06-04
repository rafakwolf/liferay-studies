find . -name "*.soy.js" -type f -delete
../../gradlew buildSoy
../../gradlew clean deploy
