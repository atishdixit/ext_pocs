package com.ext.ai.dto;

import java.util.List;

public class OpenRouterResponse {

    public OpenRouterResponse() {
		super();
	}

	private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public static class Choice {
        private Message message;

        public Choice() {
			super();
		}

		public Message getMessage() {
            return message;
        }

		public void setMessage(Message message) {
			this.message = message;
		}
		
		
    }

    public static class Message {
        private String role;
        private String content;

        public Message() {
			super();
		}

		public String getContent() {
            return content;
        }

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
		
    }

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
    
}