package com.asl.marketing.crm.crm.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

//@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>(); 
	private static int userCounts=4;
	static {
		users.add(new User(1, "pappu", new Date()));
		users.add(new User(2, "sharmin", new Date()));
		users.add(new User(3, "ayaaz", new Date()));
		users.add(new User(4, "fayaaz", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}

	public User save(User s){
		
		if(s.getId()==null)
			s.setId(++userCounts);
		users.add(s);
		return s;
	}
	public User findOne(int s){
		for(User user:users)
		{
			if(user.getId()==s)
				return user;
		}
		return null;
	}
	
	public User deleteById(int s){
		
		Iterator<User> iterator= users.iterator();
		while(iterator.hasNext())
		{
			User user=iterator.next();
			if(user.getId()==s)
			{
				iterator.remove();
				return user;
			}
		}

		return null;
	}
}
