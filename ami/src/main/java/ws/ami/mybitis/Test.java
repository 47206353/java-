package ws.ami.mybitis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ws.ami.mybitis.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("db/Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		// test1();
		// test2();
		// getList();
		//getList("summer", 1);
		addUser();

	}

	/**
	 * 第一个例子
	 */
	public static void test1() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = (User) session.selectOne(
					"ws.ami.mybitis.model.User.UserMapper.selectUserByID", 1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}

	/**
	 * 以接口编程例子
	 */
	public static void test2() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
			User user = iUserMapper.selectUserByID(1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}

	/**
	 * 得到list
	 * 
	 */

	public static void getList() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
			List<User> users = iUserMapper.selectUsers("summer");
			System.out.println("list.size=" + users.size());
			User user = users.get(0);
			System.out.println("list.size=" + user.getUserName());

		} finally {
			session.close();
		}

	}

	/**
	 * 得到list
	 * 
	 */

	public static void getList(String name, int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
			List<User> users = iUserMapper.selectUserbyid(name, id);
			System.out.println("list.size=" + users.size());
			User user = users.get(0);
			System.out.println("list.size=" + user.getUserName());

		} finally {
			session.close();
		}

	}

	public static void addUser() {
		SqlSession session = sqlSessionFactory.openSession();
		User u = new User();
		u.setUserAddress("hunan");
		u.setUserAge("20");
		u.setUserName("h");
		IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
		iUserMapper.addUser(u);
		System.out.println("增加成功 ");
		
		
		
	}

}
