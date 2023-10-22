package in.nareshit.raghu;

import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		//Universally Unique IDentifier (UUID)
		String uuid =  UUID
				.randomUUID()
				.toString()
				.replaceAll("-", "");
		System.out.println(uuid);
	}
}
