package com.chatBot.dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chatBot.dev.service.AssistanceService;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;

@Configuration
public class GenAIConfig {

	@Bean
	AssistanceService assistance() {
		AssistanceService assistanceService = AiServices.builder(AssistanceService.class)
				.chatLanguageModel(aiChatModel())
				.chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10)).build();

		return assistanceService;
	}

	@Bean
	OpenAiChatModel aiChatModel() {
		return OpenAiChatModel.builder()
				.responseFormat("json-object")
				.apiKey("demo").modelName(OpenAiChatModelName.GPT_3_5_TURBO).build();
	}
}
