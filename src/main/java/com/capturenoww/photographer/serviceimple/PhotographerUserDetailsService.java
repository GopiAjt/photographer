package com.capturenoww.photographer.serviceimple;


import com.capturenoww.photographer.model.Photographer;
import com.capturenoww.photographer.repository.PhotographerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PhotographerUserDetailsService implements UserDetailsService{

	@Autowired
	private PhotographerRepo photographerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Photographer p = photographerRepo.findByEmail(username);
		if(p != null)
		{
			return p;
		}else
		{
			throw new UsernameNotFoundException("Not a Valid User");
		}
	}  
}