package com.chatBot.dev.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatBot.dev.dto.ChatRequest;
import com.chatBot.dev.dto.ChatResponse;
import com.chatBot.dev.model.BookModel;
import com.chatBot.dev.service.GenerativeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/chat")
public class GenerativeAiController {

	private final GenerativeService generativeService;

	@PostMapping
	public ChatResponse getChatResponse(@RequestBody ChatRequest request) {

		return new ChatResponse(generativeService.getResponse(request));
	}

	@PostMapping("/language")
	public ChatResponse getchaChatResponseBasedOnLanguage(@RequestBody ChatRequest chatRequest) {

		return new ChatResponse(generativeService.getResponseBasedOnLanguage(chatRequest));
	}

	@PostMapping("/byUserId")
	public ChatResponse getchaChatResponseBasedOnUserId(@RequestBody ChatRequest chatRequest) {

		return new ChatResponse(generativeService.getResponseBaseOnUserId(chatRequest));
	}

	@PostMapping("/getBookInfo")
	public BookModel getBookModelfromText(@RequestBody ChatRequest chatRequest) {
		return generativeService.getBookModelFromText(chatRequest.question());
	}

	@PostMapping("/book")
	public BookModel getBookModelFromText(@RequestBody ChatRequest request) {
		return generativeService.getBookModelFromTextwithGenres(request.question());
	}
}
