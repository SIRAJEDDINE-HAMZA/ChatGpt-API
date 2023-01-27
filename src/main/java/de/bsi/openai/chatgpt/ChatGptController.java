package de.bsi.openai.chatgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.bsi.openai.FormInputDTO;
import de.bsi.openai.OpenAiApiClient;
import de.bsi.openai.OpenAiApiClient.OpenAiService;

import java.io.IOException;

@Controller
public class ChatGptController {
	
	private static final String MAIN_PAGE = "index";
	@Autowired
	private ChatGPTCSVWriter csvService;
	@Autowired
	private ObjectMapper jsonMapper;
	@Autowired
	private OpenAiApiClient client;

	private String chatWithGpt3(String message) throws Exception {
		var completion = CompletionRequest.defaultWith(message);
		var postBodyJson = jsonMapper.writeValueAsString(completion);
		var responseBody = client.postToOpenAiApi(postBodyJson, OpenAiService.GPT_3);
		var completionResponse = jsonMapper.readValue(responseBody, CompletionResponse.class);
		return completionResponse.firstAnswer().orElseThrow();
	}
	
	@GetMapping(path = "/")
	public String index() {
		return MAIN_PAGE;
	}
	
	@PostMapping(path = "/")
	public String chat(Model model, @ModelAttribute FormInputDTO dto) {
		try {
			ChatGPTResponse chatGPTResponse=new ChatGPTResponse();
			String response=chatWithGpt3(dto.prompt());
			model.addAttribute("request", dto.prompt());
			model.addAttribute("response", response);
			chatGPTResponse.setAnswer(response);
			chatGPTResponse.setQuestion(dto.prompt());
			csvService.write(chatGPTResponse);
		} catch (Exception e) {
			model.addAttribute("response", "Error in communication with OpenAI ChatGPT API.");
		}
		return MAIN_PAGE;
	}




}
