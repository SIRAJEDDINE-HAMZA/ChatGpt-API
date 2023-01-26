package de.bsi.openai.chatgpt;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ChatGPTCSVWriter {

    public void write(ChatGPTResponse response) throws IOException {

        File file=new File("/chatgpt/data/response.csv");
        FileWriter writer=new FileWriter(file,true);
        writer.write(String.format("\n{\n \"question\" : \"%s\",\n \"answer\": \"%s\"\n }",response.getQuestion(),response.getAnswer()));
        writer.close();
    }


}
