package main

import "fmt"

func main() {
	fmt.Println("hello world")
	fmt.Println("go" + "lang")
	fmt.Println("1+1=", 1+1)
	fmt.Println(true && true)
	fmt.Println(true || true)
	exampleSwitch()
}

func exampleSwitch() {
	i := 2
	fmt.Print("Write ", i, " as ")
	switch i {
	case 1:
		fmt.Println("one")
	case 2:
		fmt.Println("two")
	case 3:
		fmt.Println("three")
	}
}
