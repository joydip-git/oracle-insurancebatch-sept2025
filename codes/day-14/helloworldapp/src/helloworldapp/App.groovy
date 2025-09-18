package helloworldapp

class App {

	static void main(args) {
		println 'hello groovy script'
		println("hello grovvy script!!!")

		int x = 10
		//x='oracle' //no compilation error, but runtime error (since x is strictly typed)
		println x

		def name='Joydip'
		name = 100 //no compilation error and runtime error (since name is optionally/dynamically typed)
		println name
	}
}
