package com.ext.ai.dto;

import java.util.List;

public class OpenRouterRequest {

    private String model;
    private List<Message> messages;
    private Reasoning reasoning;

    
    public OpenRouterRequest() {
		super();
	}

	public OpenRouterRequest(String model, List<Message> messages, Reasoning reasoning) {
        this.model = model;
        this.messages = messages;
        this.reasoning = reasoning;
    }

    public static class Message {
        private String role;
        private String content;

        
        public Message() {
			super();
		}


		public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}
		
		
    }

    public static class Reasoning {
        private boolean enabled;

        public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public Reasoning() {
			super();
		}

		public Reasoning(boolean enabled) {
            this.enabled = enabled;
        }
    }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Reasoning getReasoning() {
		return reasoning;
	}

	public void setReasoning(Reasoning reasoning) {
		this.reasoning = reasoning;
	}
    
    
}