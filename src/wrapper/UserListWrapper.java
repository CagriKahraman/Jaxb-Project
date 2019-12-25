package wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pojo.User;

@XmlRootElement(name = "userlist")
public class UserListWrapper {

	private List<User> userList;

	@XmlElement(name = "user")
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserListWrapper{" + "userList=" + userList + '}';
	}

}
