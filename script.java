document.addEventListener('DOMContentLoaded', () => {
    const input = document.getElementById('userInput');
    const sendBtn = document.getElementById('sendBtn');
    const chatBody = document.getElementById('chatMessages');

    function addMessage(text, type) {
        const msgDiv = document.createElement('div');
        msgDiv.className = `msg ${type}`;
        msgDiv.innerText = text;
        chatBody.appendChild(msgDiv);
        chatBody.scrollTop = chatBody.scrollHeight;
    }

    function getAIResponse(userText) {
        const text = userText.toLowerCase();
        
        // Simulating thinking time
        setTimeout(() => {
            let response = "I'm listening. Please tell me more about that.";
            
            if (text.includes("sad") || text.includes("unhappy") || text.includes("bad")) {
                response = "I'm sorry you're feeling this way. It's okay to have bad days. I'm right here with you.";
            } else if (text.includes("hello") || text.includes("hi")) {
                response = "Hello! I'm your MindfulAI companion. How can I support you today?";
            } else if (text.includes("thank")) {
                response = "You're very welcome. We're in this together.";
            } else if (text.includes("anxious") || text.includes("stress")) {
                response = "That sounds heavy. Let's take a slow breath together. What's on your mind?";
            }

            addMessage(response, 'bot');
        }, 1000);
    }

    function sendMessage() {
        const message = input.value.trim();
        if (message !== "") {
            addMessage(message, 'user');
            input.value = "";
            getAIResponse(message);
        }
    }

    sendBtn.addEventListener('click', sendMessage);

    input.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') sendMessage();
    });
});

function focusChat() {
    const chatInput = document.getElementById('userInput');
    document.getElementById('chatWidget').scrollIntoView({ behavior: 'smooth' });
    chatInput.focus();
}
