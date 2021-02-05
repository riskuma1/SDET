package activity

class Activity1a {

	public static main(args) {

		def list = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]

		def numList=[]
		def strList=[]

		for (element in list) {

			switch(element.getClass()) {
				case "class java.lang.String":
					def flag = strList.add(element)
					break

				case "class java.lang.Integer":
					def flag = numList.add(element)
					break
			}
		}
		strList.sort()
		numList.sort()

		println("The sorted num list : ${numList}")
		println("*********************************")
		println("The sorted string list : ${strList}")
	}
}
