package com.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.practice.DTO.DirectorDTO;
import com.practice.DTO.MovieDTO;
import com.practice.Service.MovieService;

@SuppressWarnings("unused")
@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(DemoApplication.class, args);
	    
		
		MovieService service = (MovieService)context.getBean("movieservice");
		//Insert 
		MovieDTO dto = new MovieDTO("BNC",LocalDate.now(),LocalDateTime.now());
		List<DirectorDTO> directorList = Arrays.asList(
				new DirectorDTO("qwe", "ivt", "Delhi","qwe@infosys.com",9233213432L),
				new DirectorDTO("asd","vti","Pune","asd@infy.com",9876452312L)
				);
	
		
		
		service.add(dto,directorList);  
		
		
        service.searchBasedOnTitle("qwe");
        service.searchBasedOnTitle("asd");
        
        service.updateReleaseDate(LocalDate.of(2024, 6, 1), "qwe");
        service.updateReleaseDate(LocalDate.of(2023, 2, 5), "asd");
        
        
        
        System.out.println(" Get all Directors from Movie Title ");
        
        service.getDirectorListFromTitle("qwe");
        service.getDirectorListFromTitle("asd");
        
        
        System.out.println(" Get all Movies from Director Name");
        service.getMovieListFromDirectorName("qwe");
        service.getMovieListFromDirectorName("asd");
        
        System.out.println(service.displayAll().toString());       
	}

}
