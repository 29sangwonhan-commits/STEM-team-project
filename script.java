document.addEventListener('DOMContentLoaded', () => {
    const input = document.getElementById('userInput');
    const sendBtn = document.getElementById('sendBtn');
    const chatBody = document.getElementById('chatMessages');

    function addMessage(text, type) {
        const msgDiv = document.createElement('div');
        msgDiv.className = `msg ${type}`;
        msgDiv.innerText = text;
        chatBody.appendChild(msgDiv);
        chatBody.scrollTop = chatBody.scrollHeight; // Auto-scroll
    }

    function getAIResponse(userText) {
        const text = userText.toLowerCase();
        // Show "typing" feeling
        setTimeout(() => {
            let response = "I'm here for you. Tell me more.";
            
            if (text.includes("sad") || text.includes("bad")) {
                response = "I'm sorry things are hard right now. You're very brave for talking about it.";
            } else if (text.includes("hi") || text.includes("hello")) {
                response = "Hello! How has your day been so far?";
            } else if (text.includes("anxious") || text.includes("stress")) {
                response = "Let's take a slow breath. I'm right here. What is weighing on your mind?";
            }
            
            addMessage(response, 'bot');
        }, 1000);
    }

    function processMessage() {
        const message = input.value.trim();
        if (message !== "") {
            addMessage(message, 'user');
            input.value = ""; // Clear input
            getAIResponse(message); // Get AI reply
        }
    }

    // Fix: Listen for the button click
    sendBtn.onclick = processMessage;

    // Fix: Listen for the Enter key
    input.onkeypress = (e) => {
        if (e.key === 'Enter') {
            processMessage();
        }
    };
});

function focusChat() {
    document.getElementById('userInput').focus();
    document.getElementById('chatWidget').scrollIntoView({ behavior: 'smooth' });
}
