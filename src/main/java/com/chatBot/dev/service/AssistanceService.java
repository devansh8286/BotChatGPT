package com.chatBot.dev.service;

import java.util.List;

import com.chatBot.dev.model.BookModel;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface AssistanceService {

	@SystemMessage("""
			You are a helpful assistance. Try to respond in a fair and warm manner.
			If you don't know answer, Just tell it.
			""")
	String chat(@MemoryId int memoryId, @UserMessage String userMessage);

	@SystemMessage("Extract information about a book from {{text}} in json format")
	@UserMessage("And genre should be from this list {{genresList}}")
	BookModel extractBookFromTextwithGenresList(@V("text") String text, @V("genresList") List<String> genres);

	BookModel extactBookfromText(String text);

}
