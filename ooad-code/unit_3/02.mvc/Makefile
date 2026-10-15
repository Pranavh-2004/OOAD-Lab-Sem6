SRC_DIR=src
OUT_DIR=out

SRC=$(shell find $(SRC_DIR) -name "*.java")
FLAGS=-Xlint
MAIN=Main

all: compile

compile:
	mkdir -p $(OUT_DIR)
	javac $(FLAGS) -d $(OUT_DIR) $(SRC)

run: compile
	java -cp $(OUT_DIR) $(MAIN)

clean:
	rm -rf $(OUT_DIR)
