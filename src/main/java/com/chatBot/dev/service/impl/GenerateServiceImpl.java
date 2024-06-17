package com.chatBot.dev.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chatBot.dev.dto.ChatRequest;
import com.chatBot.dev.model.BookModel;
import com.chatBot.dev.service.AssistanceService;
import com.chatBot.dev.service.GenerativeService;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.model.output.Response;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenerateServiceImpl implements GenerativeService {

	private final AssistanceService assistance;

	private OpenAiChatModel createAiChatModel() {
		return OpenAiChatModel.builder().apiKey("demo").modelName(OpenAiChatModelName.GPT_3_5_TURBO).build();
	}

	@Override
	public String getResponse(ChatRequest request) {

		return createAiChatModel().generate(request.question());
	}

	@Override
	public String getResponseBasedOnLanguage(ChatRequest request) {

		List<ChatMessage> messages = new ArrayList<>();
		messages.add(SystemMessage.systemMessage("Respone in " + request.language()));
		messages.add(UserMessage.userMessage(request.question()));
		Response<AiMessage> generate = createAiChatModel().generate(messages);
		System.out.println("generate : " + generate);

		return generate.content().text();
	}

	@Override
	public String getResponseBaseOnUserId(ChatRequest request) {
		String chat = assistance.chat(request.userId(), request.question());
		return chat;
	}

	@Override
	public BookModel getBookModelFromText(String question) {
		return assistance.extactBookfromText(question);
	}

	@Override
	public BookModel getBookModelFromTextwithGenres(String question) {
		var popularGenres = List.of("Fiction", "Mystery", "Romance", "Science Fiction", "Fantasy", "Thriller",
				"Historical Fiction", "Young Adult", "Non-Fiction", "Biography");
		return assistance.extractBookFromTextwithGenresList(question, popularGenres);
	}

}
