BUILD_DIR=./build

CLASS=Singleton
SRC=singleton.java

.PHONY: pre clean

default: pre
	javac $(SRC) -d $(BUILD_DIR)
	java -cp $(BUILD_DIR) $(CLASS)

pre: clean
	@mkdir -p $(BUILD_DIR)

clean:
	@rm -rf $(BUILD_DIR)
