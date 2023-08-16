VERSION=$(grep 'version =' build.gradle.kts | cut -d'"' -f2)
ZIPNAME=cli-$VERSION.zip
unzip -o build/distributions/$ZIPNAME -d build/distributions
build/distributions/cli-$VERSION/bin/cli sc "test/muipidan.lsc" "test/ptr_test.wli"
