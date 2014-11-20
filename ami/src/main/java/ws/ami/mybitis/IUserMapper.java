package ws.ami.mybitis;

import ws.ami.mybitis.model.User;

public interface IUserMapper {   
	//请注意，这里面有一个方法名 selectUserByID 必须与 User.xml 
	//里面配置的 select 的id 对应（<select id="selectUserByID"）
    public User selectUserByID(int id);
    
}