package com.chatBot.dev.service;

import com.chatBot.dev.dto.ChatRequest;
import com.chatBot.dev.model.BookModel;

public interface GenerativeService {

	String getResponse(ChatRequest request);

	String getResponseBasedOnLanguage(ChatRequest request);

	String getResponseBaseOnUserId(ChatRequest request);

	BookModel getBookModelFromText(String question);

	BookModel getBookModelFromTextwithGenres(String question);

}
