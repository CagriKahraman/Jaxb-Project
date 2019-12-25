package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pojo.Job;
import pojo.User;
import wrapper.UserListWrapper;

public class Main {

	public static void main(String[] args) {

		User user = new User(1, "Çağrı", "Çağrı Kahraman", "123");
		Job job = new Job("Coumputer Science", "Engineer");
		user.setJob(job);

		User user1 = new User(2, "Buğra", "Muhammed Buğra Kahraman", "1234");
		Job job1 = new Job("Machine Science", "Engineer");
		user1.setJob(job1);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);

		UserListWrapper userListWrapper = new UserListWrapper();
		userListWrapper.setUserList(userList);

		try {
			System.out.println("Convert Java Object to XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(UserListWrapper.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(userListWrapper, System.out);

			System.out.println("-------------------------");
			System.out.println("Convert XML to Java Object");

			File file = new File("C:\\Users\\pia\\Desktop\\Döküman\\4cagrı\\data.xml");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			user = (User) unmarshaller.unmarshal(file);
			System.out.println(user);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
