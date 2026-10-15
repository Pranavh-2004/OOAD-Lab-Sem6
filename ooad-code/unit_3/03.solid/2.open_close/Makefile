BUILD_DIR=./build

BAD_CLASS=BadOpenClose
BAD_SRC=$(wildcard ./bad_*.java)

GOOD_CLASS=GoodOpenClose
GOOD_SRC=$(wildcard ./good_*.java)

.PHONY: pre bad good clean

bad: pre
	javac ./bad_*.java -d $(BUILD_DIR)
	java -cp $(BUILD_DIR) $(BAD_CLASS)

good: pre
	javac ./good_*.java -d $(BUILD_DIR)
	java -cp $(BUILD_DIR) $(GOOD_CLASS)

pre: clean
	@mkdir -p $(BUILD_DIR)

clean:
	@rm -rf $(BUILD_DIR)
