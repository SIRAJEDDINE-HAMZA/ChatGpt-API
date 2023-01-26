package de.bsi.openai.chatgpt;

public class ChatGPTRequest {
    public ChatGPTRequest(String question) {
        this.question = question;
    }

    public ChatGPTRequest() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String question;

}
