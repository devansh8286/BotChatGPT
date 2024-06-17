package com.chatBot.dev.model;

import java.time.LocalDate;

//import dev.langchain4j.model.output.structured.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

	private Integer id;
	private String title;
//	@Description("should be less than 20 words" )
	private String description;
	private String genres;
	private LocalDate dateOfPublication;
	private String author;

}
